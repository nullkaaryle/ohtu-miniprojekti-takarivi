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
import takarivi.bibtex.util.BibTexFormatter;
import takarivi.bibtex.util.Formatter;

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
    
    public List<Entry> findByListOfIds(List<Long> ids) {
        List<Entry> entries = new ArrayList<>();
        for (Long id : ids) {
            Entry e = findById(id);
            if (e != null) {
                entries.add(e);
            }
        }
        return entries;
    }
    
    public void delete(Entry entry) {
        entryRepository.delete(entry);
    }
    
    public void deleteByListOfIds(List<Long> ids) {
        List<Entry> entries = findByListOfIds(ids);
        for (Entry e : entries) {
            delete(e);
        }
    }

    public String formatBibTex(List<Entry> entries) {
        BibTexFormatter formatter = new BibTexFormatter();
        String output = "";
        for (Entry e : entries) {
            output += formatter.buildString(e);
        }
        return output;
    }
}
