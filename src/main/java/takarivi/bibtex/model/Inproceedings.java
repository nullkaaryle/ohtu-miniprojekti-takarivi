package takarivi.bibtex.model;

import java.util.Set;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

public class Inproceedings extends Entry {

    public Inproceedings() {
        super(EntryType.INPROCEEDINGS);
        
        FieldType[] req = {
            FieldType.AUTHOR,
            FieldType.TITLE,
            FieldType.BOOKTITLE,
            FieldType.YEAR};
        
        FieldType[] opt = {
            FieldType.EDITOR,
            FieldType.VOLUME,
            FieldType.SERIES,
            FieldType.PAGES,
            FieldType.ADDRESS,
            FieldType.MONTH,
            FieldType.ORGANIZATION,
            FieldType.PUBLISHER,
            FieldType.NOTE,
            FieldType.KEY};
        
        super.addFieldTypes(req, opt);
    }

}
