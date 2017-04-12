/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controller;

import java.util.List;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.model.Entry;

/**
 *
 * @author pyykkomi
 */
public interface Formatter {
    
    public void export(List<Entry> entries, EntryType entrytype);
    
    
}
