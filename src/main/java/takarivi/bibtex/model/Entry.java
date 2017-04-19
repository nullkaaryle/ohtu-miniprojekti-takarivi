package takarivi.bibtex.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

public class Entry {
    private EntryType entryType;
    private String bibTexKey;
    private Map<FieldType, Field> fields;
    private Set<FieldType> required, optional;
    private final UUID id = UUID.randomUUID();
    
    public Entry(EntryType entryType) {
        this.entryType = entryType;
        this.fields = new TreeMap<>();
        this.required = new TreeSet<>(entryType.getRequired());
        this.optional = new TreeSet<>(entryType.getOptional());
        for (FieldType req : required) {
            fields.put(req, null);
        }
        for (FieldType opt : optional) {
            fields.put(opt, null);
        }
    }

    public UUID getId() {
        return id;
    }
    
    public Set<FieldType> getFieldTypes() {
        return fields.keySet();
    }
    
    public Map<FieldType, Field> getFields() {
        return fields;
    }

    public void setFields(Map<FieldType, Field> fields) {
        this.fields = fields;
    }
    
    public void addField(Field field) {
        if (required.contains(field.getFieldType()) || optional.contains(field.getFieldType()))
        {
            fields.put(field.getFieldType(), field);
        } else {
            // doom;
        }
    }
    
    public void removeField(Field field) {
        fields.put(field.getFieldType(), null);
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

    public void setBibTexKey(String bibTexKey) {
        this.bibTexKey = bibTexKey;
    }
    
    public boolean validate() {
        for (FieldType req : required) {
            if (!fields.containsKey(req) || fields.get(req) == null) {
               return false; 
            }
        }
        
        return true;
    }
}
