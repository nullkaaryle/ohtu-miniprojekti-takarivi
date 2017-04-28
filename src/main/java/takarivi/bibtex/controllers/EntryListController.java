/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.forms.EntryListForm;
import takarivi.bibtex.forms.EntryTypeForm;
import takarivi.bibtex.services.CustomerDetailsService;
import takarivi.bibtex.services.CustomerService;
import takarivi.bibtex.services.EntryService;

/**
 *
 * @author pyykkomi
 */
@Controller
public class EntryListController {
    @Autowired
    public EntryService entryService;
    @Autowired
    public CustomerDetailsService customerDetailsService;
    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEntries(Model model) {
        List<Entry> entries = entryService.findall();
        model.addAttribute("entries", entries);
        EntryTypeForm entryTypeForm = new EntryTypeForm();
        List<String> entryTypes = new ArrayList<>();
        for (EntryType et : EntryType.values()) {
            entryTypes.add(et.toString());
        }
        entryTypeForm.setEntryTypes(entryTypes);
        model.addAttribute("entryTypeForm", entryTypeForm);
        model.addAttribute("entryCheckBoxForm", new EntryListForm());
//        model.addAttribute("userLoggedIn", customerService.findByUsername("testi"/*auth.getName()*/));
//        System.out.println(customerService.findByUsername("testi"));
//        System.out.println(customerDetailsService.loadUserByUsername("testi"));
        return "list";
    }

    @RequestMapping(value = "/list/selected", params = "action=remove", method = RequestMethod.POST)
    public String removeSelected(Model model, @ModelAttribute EntryListForm entryCheckBoxForm) {
        entryService.deleteByListOfIds(entryCheckBoxForm.getSelected());
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/list/selected", params = "action=bibtex", method = RequestMethod.POST,
                    produces = "application/x-bibtex")
    @ResponseBody
    public String bibtexSelected(Model model, @ModelAttribute EntryListForm entryCheckBoxForm,
                                 HttpServletResponse response) {
        List<Entry> entries = entryService.findByListOfIds(entryCheckBoxForm.getSelected());
        String filename = "default";
        if (!entryCheckBoxForm.getFilename().equals("")) {
            filename = entryCheckBoxForm.getFilename();
        }
        response.addHeader("Content-disposition", "attachment; filename=\""+filename+".bib\"");
        return entryService.formatBibTex(entries);
    }
    
}
