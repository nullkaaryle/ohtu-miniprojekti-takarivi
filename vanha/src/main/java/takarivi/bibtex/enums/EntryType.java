package takarivi.bibtex.enums;

import java.util.Arrays;
import java.util.List;

public enum EntryType {
    ARTICLE(
        "article",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.JOURNAL, FieldType.YEAR, FieldType.VOLUME),
        toList(FieldType.NUMBER, FieldType.PAGES, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), BOOK(
        "book",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.PUBLISHER, FieldType.YEAR),
        toList(FieldType.VOLUME, FieldType.SERIES, FieldType.ADDRESS, FieldType.EDITION, 
              FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), INPROCEEDINGS(
        "inproceedings",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.BOOKTITLE, FieldType.YEAR),
        toList(FieldType.EDITOR, FieldType.VOLUME, FieldType.SERIES, FieldType.PAGES,
              FieldType.ADDRESS, FieldType.MONTH, FieldType.ORGANIZATION, FieldType.PUBLISHER,
              FieldType.NOTE, FieldType.KEY));

    private final String name;
    private final List<FieldType> required;
    private final List<FieldType> optional;
    
    EntryType(String name, List<FieldType> required, List<FieldType> optional) {
        this.required = required;
        this.optional = optional;
        this.name = name;
    }
    
    private static List<FieldType> toList(FieldType... fieldtypes) {
        return Arrays.asList(fieldtypes);
    }
    
    public List<FieldType> getRequired() {
        return required;
    }
    
    public List<FieldType> getOptional() {
        return optional;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
