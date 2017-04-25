/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.repositories;

import takarivi.bibtex.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author pyykkomi
 */
@RepositoryRestResource
public interface EntryRepository extends JpaRepository<Entry, Long>{
    
}
