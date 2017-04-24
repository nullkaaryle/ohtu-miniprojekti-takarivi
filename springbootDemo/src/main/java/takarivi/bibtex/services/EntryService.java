/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.services;

import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.repositories.EntryRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pyykkomi
 */
@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;
    
    public List<Entry> findall() {
        List<Entry> entries = new ArrayList<>();
        entries.addAll((Collection<? extends Entry>) entryRepository.findAll());
        return entries;
    }
    
    public void save(Entry entry) {
        entryRepository.save(entry);
    }
    
    public Entry findById(long id) {
        return entryRepository.findOne(id);
    }
}
