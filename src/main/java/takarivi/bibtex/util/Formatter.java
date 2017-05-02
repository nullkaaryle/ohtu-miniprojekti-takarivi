package takarivi.bibtex.util;

import java.util.List;
import takarivi.bibtex.entities.Entry;

public interface Formatter {
    
    public String export(List<Entry> entries);
    
    
}
