/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takarivi.bibtex.entities.Customer;
import takarivi.bibtex.repositories.CustomerRepository;

/**
 *
 * @author pyykkomi
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
    
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
