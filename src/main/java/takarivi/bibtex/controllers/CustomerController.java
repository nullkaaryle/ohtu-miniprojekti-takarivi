package takarivi.bibtex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import takarivi.bibtex.entities.Customer;
import takarivi.bibtex.forms.RegisterForm;
import takarivi.bibtex.services.CustomerDetailsService;
import takarivi.bibtex.services.CustomerService;

@Controller
@SessionAttributes({"customer"})
public class CustomerController {
   
    @Autowired
    public CustomerDetailsService customerDetailsService;
    @Autowired
    public CustomerService customerService;
    @Autowired
    public CustomerController customerController;
    
    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }
    
    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String newuser(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult
            /*@ModelAttribute String username, @ModelAttribute String password*/) {
        Customer customer = new Customer(registerForm.getUsername(), registerForm.getPassword());
        customerService.save(customer);
        customerDetailsService.save(customer);
        return "redirect:/";
    }
}
