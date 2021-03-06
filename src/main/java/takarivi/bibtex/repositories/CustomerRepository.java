/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import takarivi.bibtex.entities.Customer;

/**
 *
 * @author pyykkomi
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByUsername(String username);
}
