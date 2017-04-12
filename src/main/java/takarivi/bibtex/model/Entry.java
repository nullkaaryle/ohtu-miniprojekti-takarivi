package takarivi.bibtex.model;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

public class Entry {
    private EntryType entryType;
    private String bibTexKey;
    private Set<Field> fields;
    private Set<FieldType> required, optional;
    
    public Entry(EntryType entryType) {
        this.entryType = entryType;
        this.fields = new TreeSet<>();
        this.required = new TreeSet<>();
        this.optional = new TreeSet<>();
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
    
    public void addField(Field field) {
        if (required.contains(field.getFieldType()) || optional.contains(field.getFieldType()))
        {
            fields.add(field);
        } else {
            // doom;
        }
    }
    
    public void removeField(Field field) {
        fields.remove(field);
    }
    
    public void addFieldTypes(FieldType[] required, FieldType[] optional) {
        this.required.addAll(Arrays.asList(required));
        this.optional.addAll(Arrays.asList(optional));
    }

    public Set<FieldType> getRequired() {
        return required;
    }

    public void setRequired(Set<FieldType> required) {
        this.required = required;
    }

    public Set<FieldType> getOptional() {
        return optional;
    }

    public void setOptional(Set<FieldType> optional) {
        this.optional = optional;
    }

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getBibTexKey() {
        return bibTexKey;
    }

    public void setBibtexKey(String bibtexKey) {
        this.bibTexKey = bibtexKey;
    }
    
    
}
