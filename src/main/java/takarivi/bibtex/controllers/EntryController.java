package takarivi.bibtex.controllers;

import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.forms.EntryForm;
import takarivi.bibtex.services.EntryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        entry = new Entry(entryType);
        EntryForm entryForm = new EntryForm();
        entryForm.setAction("add");
        entryForm.setId(entry.getId());
        model.addAttribute("entry", entry);
        model.addAttribute("entryForm", entryForm);
        model.addAttribute("sendAction", "add");
        return "form";
    }

    @RequestMapping(value = {"/add/{type}/", "/edit/{type}/"}, method = RequestMethod.POST)
    public String saveEntry(Model model, @PathVariable String type, @ModelAttribute Entry entry,
            @ModelAttribute EntryForm entryForm, @ModelAttribute String sendAction,
            HttpServletRequest request) {
        /*
         Tää on aivan hirveetä spagettia syystä ettei Thymeleaf osaa kunnolla
         HashMapeja... yritetään selittää.
         */
        String path = request.getServletPath();
        if (path.contains("add")) {
            entry = new Entry(EntryType.valueOf(type.toUpperCase()));
        } else {
            entry = entryService.findById(entryForm.getId());
        }
        FieldType[] req = fieldTypesOrdered(entry.getRequired());
        FieldType[] opt = fieldTypesOrdered(entry.getOptional());
        setEntryFields(entry, entryForm, req, opt);
        entry.setAuthorsAndTitle();
        if (entryForm.getBibTexKey().equals("")) {
            entry.setBibTexKey(entry.createBibTexKey());
        } else {
            entry.setBibTexKey(entryForm.getBibTexKey());
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
//            entry.addCustomer();
        }
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
        entryForm.setAction("edit");
        entryForm.setId(id);
        entryForm.setBibTexKey(entry.getBibTexKey());
        model.addAttribute("title", "Edit " + entry.getEntryType().toString());
        model.addAttribute("entry", entry);
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
    private FieldType[] fieldTypesOrdered(Set<FieldType> fieldTypes) {
        FieldType[] ret = fieldTypes.toArray(new FieldType[fieldTypes.size()]);
        Arrays.sort(ret);
        return ret;
    }

    private void setEntryFields(Entry entry, EntryForm entryForm, FieldType[] req, FieldType[] opt) {
        for (int idx = 0; idx < entryForm.getRequiredList().size(); idx++) {
            String s = entryForm.getRequiredList().get(idx);
            System.out.println(s);
            entry.setField(req[idx], s);
        }
        for (int idx = 0; idx < entryForm.getOptionalList().size(); idx++) {
            String s = entryForm.getOptionalList().get(idx);
            entry.setField(opt[idx], s);
        }
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

    @ModelAttribute("entryTypeForm")
    public EntryTypeForm loadEntryTypeFormBean() {
        return new EntryTypeForm();
    }

    @ModelAttribute("entryCheckBoxForm")
    public EntryListForm loadEntryCheckBoxFormBean() {
        return new EntryListForm();
    }
}
