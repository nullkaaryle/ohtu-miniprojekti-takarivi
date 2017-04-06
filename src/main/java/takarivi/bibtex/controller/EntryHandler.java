/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controller;

import java.util.ArrayList;
import java.util.List;
import takarivi.bibtex.model.Entry;

/**
 *
 * @author pyykkomi
 */
public class EntryHandler {
    
    private List<Entry> entries;
    
    public EntryHandler() {
        entries = new ArrayList<>();
    }
    
    public void addEntry(Entry entry) {
        entries.add(entry);
    }
    
    public List<Entry> getEntries() {
        return entries;
    }
}
