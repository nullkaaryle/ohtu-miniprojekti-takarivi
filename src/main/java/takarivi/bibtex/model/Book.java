package takarivi.bibtex.model;

import java.util.Set;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

public class Book extends Entry {

    public Book() {
        super(EntryType.BOOK);
        
        FieldType[] req = {
            FieldType.AUTHOR,
            FieldType.TITLE,
            FieldType.PUBLISHER,
            FieldType.YEAR};
        
        FieldType[] opt = {
            FieldType.VOLUME,
            FieldType.SERIES,
            FieldType.ADDRESS,
            FieldType.EDITION,
            FieldType.MONTH,
            FieldType.NOTE,
            FieldType.KEY};
        
        super.addFieldTypes(req, opt);
    }

}
