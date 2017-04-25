/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controllers;

import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.forms.EntryForm;
import takarivi.bibtex.services.EntryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pyykkomi
 */
@Controller
public class EntryController {
    
    @Autowired
    public EntryService entryService;
    
    @RequestMapping(value = "/addrandom", method = RequestMethod.GET)
    public String addRandom(Model model) {
        Entry e = new Entry(EntryType.BOOK);
        e.setField(FieldType.AUTHOR, UUID.randomUUID().toString().substring(0, 8));
        e.setField(FieldType.YEAR, "1972");
        e.setBibTexKey(e.createBibTexKey());
        entryService.save(e);
        List<Entry> entries = entryService.findall();
        model.addAttribute("entries", entries);
        return "list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Entry> entries = entryService.findall();
        model.addAttribute("entries", entries);
        return "list";
    }
    
    @RequestMapping(value = "/add/{type}/", method = RequestMethod.GET)
    public String addReference(Model model, @PathVariable String type, @ModelAttribute Entry entry) {
        EntryType entryType = findEntryType(type);
        if (entryType == null) {
            return "list";
        }
        entry = new Entry(entryType);
        EntryForm entryForm = new EntryForm();
        model.addAttribute("entry", entry);
        model.addAttribute("entryForm", entryForm);
        model.addAttribute("action", "add");
        return "form";
    }
    
    @RequestMapping(value = {"/add/{type}/", "/edit/{type}/"}, method = RequestMethod.POST)
    public String saveReference(Model model, @PathVariable String type, @ModelAttribute Entry entry, 
            @ModelAttribute EntryForm entryForm, @ModelAttribute String action) {
        /*
            Tää on aivan hirveetä spagettia syystä ettei Thymeleaf osaa kunnolla
            HashMapeja... yritetään selittää.
        */
        System.out.println(action);
        if (action.equals("add")) {
            entry = new Entry(EntryType.valueOf(type.toUpperCase()));
        } else {
            entry = entryService.findById(entryForm.getId());
        }
        System.out.println(entryForm.getRequiredList());
        FieldType[] req = entry.getRequired().toArray(new FieldType[entry.getRequired().size()]);
        Arrays.sort(req);
        /*
            Thymeleafista palautuu kaksi ArrayListiä, tuo ^^^ on siksi että FieldTypet olisivat
            req-arrayssä samassa järjestyksessä
        */
        for (int idx = 0; idx < entryForm.getRequiredList().size(); idx++) {
            String s = entryForm.getRequiredList().get(idx);
            System.out.println(s);
            entry.setField(req[idx], s);
        }
        FieldType[] opt = entry.getOptional().toArray(new FieldType[entry.getOptional().size()]);
        Arrays.sort(opt);
        for (int idx = 0; idx < entryForm.getOptionalList().size(); idx++) {
            String s = entryForm.getOptionalList().get(idx);
            System.out.println(s);
            entry.setField(opt[idx], s);
        }
        entryService.save(entry);
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/edit/{type}/{id}/", method = RequestMethod.GET)
    public String editReference(Model model, @PathVariable String type, @PathVariable long id,
            @ModelAttribute Entry entry, @ModelAttribute EntryForm entryForm) {
        entry = entryService.findById(id);
        if (entry == null) {
            return "redirect:/list";
        }
        System.out.println(entry.getField(FieldType.TITLE));
        ArrayList<String> requiredList = new ArrayList<>(entry.getRequired().size());
        ArrayList<String> optionalList = new ArrayList<>(entry.getOptional().size());
        FieldType[] req = entry.getRequired().toArray(new FieldType[entry.getRequired().size()]);
        Arrays.sort(req);
        /*
            Täällä sama sitten toisin päin eli ThymeLeafille annetaan kaksi ArrayListiä
            joissa kenttien arvot, yllä järjestellään taas FieldTypet
        */
        for (int idx = 0; idx < entry.getRequired().size(); idx++) {
            requiredList.add(idx, entry.getField(req[idx]));
        }
        FieldType[] opt = entry.getOptional().toArray(new FieldType[entry.getOptional().size()]);
        Arrays.sort(opt);
        for (int idx = 0; idx < entry.getOptional().size(); idx++) {
            optionalList.add(idx, entry.getField(opt[idx]));
        }
        entryForm.setRequiredList(requiredList);
        entryForm.setOptionalList(optionalList);
        model.addAttribute("entry", entry);
        model.addAttribute("entryForm", entryForm);
        model.addAttribute("action", "edit");
        return "form";
    }
    
    private FieldType findFieldType(String field) {
        for (FieldType ft : FieldType.values()) {
            if (ft.toString().equals(field)) {
                return ft;
            }
        }
        
        return null;
    }
    
    private FieldType findFieldTypeByOrder(Entry e, int idx) {
        if (idx < 0 || idx > FieldType.values().length) {
            return null;
        }
        return FieldType.values()[idx];
    }

    private EntryType findEntryType(String type) {
        for (EntryType e : EntryType.values()) {
            if (e.toString().toLowerCase().equals(type)) {
                return e;
            }
        }
        return null;
    }
}
