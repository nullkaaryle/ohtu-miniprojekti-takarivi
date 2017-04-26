package takarivi.bibtex.enums;

import java.util.LinkedHashSet;
import java.util.Set;

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
              FieldType.NOTE, FieldType.KEY)
    ), BOOKLET ( 
        "booklet",
        toList(FieldType.TITLE),
        toList(FieldType.AUTHOR, FieldType.HOWPUBLISHED, FieldType.ADDRESS, 
              FieldType.MONTH, FieldType.YEAR, FieldType.NOTE, FieldType.KEY)
    ), INBOOK (
        "inbook",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.PAGES, FieldType.PUBLISHER, FieldType.YEAR),
        toList(FieldType.VOLUME, FieldType.SERIES, FieldType.TYPE, FieldType.ADDRESS, 
              FieldType.EDITION, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), INCOLLECTION (
        "incollection",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.BOOKTITLE, FieldType.PUBLISHER, FieldType.YEAR),
        toList(FieldType.EDITOR, FieldType.VOLUME, FieldType.SERIES, FieldType.TYPE, FieldType.CHAPTER, FieldType.PAGES, 
              FieldType.ADDRESS, FieldType.EDITION, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), MANUAL (
        "manual",
        toList(FieldType.TITLE),
        toList(FieldType.AUTHOR, FieldType.ORGANIZATION, FieldType.ADDRESS, FieldType.EDITION,
              FieldType.MONTH, FieldType.YEAR, FieldType.NOTE, FieldType.KEY)
    ), MASTERTHESIS (
        "masterthesis", 
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.SCHOOL, FieldType.YEAR),
        toList(FieldType.TYPE, FieldType.ADDRESS, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), MISC (
        "misc",
        toList(FieldType.TITLE),
        toList(FieldType.AUTHOR, FieldType.HOWPUBLISHED, FieldType.MONTH, FieldType.YEAR, FieldType.NOTE, FieldType.KEY)
    ), PHDTHESIS (
        "phdthesis",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.SCHOOL, FieldType.YEAR),
        toList(FieldType.TYPE, FieldType.ADDRESS, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), PROCEEDINGS (
        "proceedings",
        toList(FieldType.TITLE, FieldType.YEAR),
        toList(FieldType.EDITOR, FieldType.VOLUME, FieldType.SERIES, FieldType.ADDRESS, FieldType.MONTH, 
              FieldType.PUBLISHER, FieldType.ORGANIZATION, FieldType.NOTE, FieldType.KEY)
    ), TECHREPORT (
        "techreport",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.INSTITUTION, FieldType.YEAR),
        toList(FieldType.TYPE, FieldType.VOLUME, FieldType.ADDRESS, FieldType.MONTH, FieldType.NOTE, FieldType.KEY)
    ), UNPUBLISHED (
        "unpublished",
        toList(FieldType.AUTHOR, FieldType.TITLE, FieldType.NOTE),
        toList(FieldType.MONTH, FieldType.YEAR, FieldType.KEY)
    );

    private final String name;
    private final Set<FieldType> required;
    private final Set<FieldType> optional;
    
    EntryType(String name, Set<FieldType> required, Set<FieldType> optional) {
        this.required = required;
        this.optional = optional;
        this.name = name;
    }
    
    private static Set<FieldType> toList(FieldType... fieldtypes) {
        Set<FieldType> s = new LinkedHashSet<>();
        for (FieldType ft : fieldtypes) {
            s.add(ft);
        }
        return s;
    }
    
    public Set<FieldType> getRequired() {
        return required;
    }
    
    public Set<FieldType> getOptional() {
        return optional;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
