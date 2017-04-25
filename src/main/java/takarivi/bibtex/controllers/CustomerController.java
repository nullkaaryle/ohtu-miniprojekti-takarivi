/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import takarivi.bibtex.entities.Customer;
import takarivi.bibtex.services.CustomerDetailsService;

/**
 *
 * @author pyykkomi
 */
@Controller
public class CustomerController {
   
    @Autowired
    public CustomerDetailsService customerDetailsService;
    
    @Autowired
    public CustomerController customerController;
    
    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    
    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String newuser(@ModelAttribute String username, @ModelAttribute String password) {
        Customer c = new Customer(username, password);
        customerDetailsService.save(c);
        return "redirect:/";
    }
}
