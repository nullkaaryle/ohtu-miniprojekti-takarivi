/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import takarivi.bibtex.entities.Customer;

/**
 *
 * @author pyykkomi
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByUsername(String username);
}
