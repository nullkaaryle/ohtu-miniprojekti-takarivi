package takarivi.bibtex;

import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Article;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

public class Main {
    
    public static void main(String[] args) {
        Entry e = new Article();
        
        for (FieldType ft : e.getRequired()) {
            Field f = new Field(ft, "sisältö", 0);
            e.addField(f);
        }
        
    }
}
