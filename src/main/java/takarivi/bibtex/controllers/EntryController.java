package takarivi.bibtex.controllers;

import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.forms.EntryForm;
import takarivi.bibtex.services.EntryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import takarivi.bibtex.entities.builders.EntryBuilder;
import takarivi.bibtex.forms.EntryListForm;
import takarivi.bibtex.forms.EntryTypeForm;
import takarivi.bibtex.services.CustomerDetailsService;
import takarivi.bibtex.services.CustomerService;

@Controller
public class EntryController {

    @Autowired
    public EntryService entryService;
    @Autowired
    public CustomerDetailsService customerDetailsService;
    @Autowired
    public CustomerService customerService;
    public EntryBuilder entryBuilder = new EntryBuilder();

    @RequestMapping(value = "/addrandom", method = RequestMethod.GET)
    public String addRandom(Model model) {
        Entry e = new Entry(EntryType.BOOK);
        e.setField(FieldType.AUTHOR, UUID.randomUUID().toString().substring(0, 8));
        e.setField(FieldType.YEAR, "1972");
        e.setBibTexKey(e.createBibTexKey());
        entryService.save(e);
        return "redirect:/list";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addEntryOfEntryType(Model model, @ModelAttribute EntryTypeForm entryTypeForm) {
        for (EntryType et : EntryType.values()) {
            if (entryTypeForm.getSelection().equals(et.toString())) {
                return "redirect:/add/" + entryTypeForm.getSelection() + "/";
            }
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/add/{type}/", method = RequestMethod.GET)
    public String addEntry(Model model, @PathVariable String type, @ModelAttribute Entry entry) {
        EntryType entryType = findEntryType(type);
        if (entryType == null) {
            return "list";
        }
        Set<FieldType> required = entryType.getRequired();
        Set<FieldType> optional = entryType.getOptional();
        EntryForm entryForm = new EntryForm(type, "add", entry.getId());
        model.addAttribute("title", "Add " + entryType.toString().toLowerCase());
        model.addAttribute("required", required);
        model.addAttribute("optional", optional);
        model.addAttribute("entryForm", entryForm);
        model.addAttribute("sendAction", "add");
        return "form";
    }

    @RequestMapping(value = {"/add/{type}/", "/edit/{type}/"}, method = RequestMethod.POST)
    public String saveEntry(Model model, @PathVariable String type,
            @ModelAttribute TreeSet<FieldType> required, @ModelAttribute TreeSet<FieldType> optional,
            /*@ModelAttribute Entry entry,*/
            @ModelAttribute EntryForm entryForm, @ModelAttribute String sendAction,
            HttpServletRequest request) {
        String path = request.getServletPath();
        Entry entry = null;
        EntryType entryType = EntryType.valueOf(type.toUpperCase());
        if (entryType == null) {
            return "redirect:/list";
        }
        if (path.contains("add")) {
            entry = entryBuilder.create(entryType)
                                .required(entryForm.getRequiredList())
                                .optional(entryForm.getOptionalList())
                                .bibTexKey(entryForm.getBibTexKey())
                                .build();
        } else {
            Entry editEntry = entryService.findById(entryForm.getId());
            if (editEntry != null) {
                System.out.println(editEntry);
                entry = entryBuilder.edit(editEntry)
                                    .required(entryForm.getRequiredList())
                                    .optional(entryForm.getOptionalList())
                                    .bibTexKey(entryForm.getBibTexKey())
                                    .build();
                System.out.println(entry.getBibTexKey());
            }
        }
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth.isAuthenticated()) {
////            entry.addCustomer();
//        }
        entryService.save(entry);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit/{type}/{id}/", method = RequestMethod.GET)
    public String editEntry(Model model, @PathVariable String type, @PathVariable long id,
            @ModelAttribute Entry entry, @ModelAttribute EntryForm entryForm) {
        entry = entryService.findById(id);
        if (entry == null) {
            return "redirect:/list";
        }
        entryForm = new EntryForm(entry, "edit");
        
        model.addAttribute("title", "Edit " + entry.getEntryType().toString());
        model.addAttribute("entry", entry);
        model.addAttribute("required", entry.getEntryType().getRequired());
        model.addAttribute("optional", entry.getEntryType().getOptional());
        model.addAttribute("entryForm", entryForm);
        model.addAttribute("sendAction", "edit");
        return "form";
    }

    @RequestMapping(value = "/delete/{type}/{id}", method = RequestMethod.GET)
    public String removeEntry(Model Model, @PathVariable String type, @PathVariable long id) {
        Entry entry = entryService.findById(id);
        if (entry != null) {
            entryService.delete(entry);
        }
        return "redirect:/list";
    }

    // helpers
    private EntryType findEntryType(String type) {
        for (EntryType e : EntryType.values()) {
            if (e.toString().toLowerCase().equals(type)) {
                return e;
            }
        }
        return null;
    }

    @ModelAttribute("entryTypeForm")
    public EntryTypeForm loadEntryTypeFormBean() {
        return new EntryTypeForm();
    }

    @ModelAttribute("entryCheckBoxForm")
    public EntryListForm loadEntryCheckBoxFormBean() {
        return new EntryListForm();
    }
}
