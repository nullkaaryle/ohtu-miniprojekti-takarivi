/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import takarivi.bibtex.services.CustomerDetailsService;

/**
 *
 * @author pyykkomi
 */
@Controller
public class BasicController {

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "redirect:/list";
    }
    
}
