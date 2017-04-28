/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.util;

import java.util.List;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.entities.Entry;

/**
 *
 * @author pyykkomi
 */
public interface Formatter {
    
    public String export(List<Entry> entries);
    
    
}
