/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.model;

import java.util.Set;
import java.util.TreeSet;
import takarivi.bibtex.enums.FieldType;

/**
 *
 * @author pyykkomi
 */
public class Entry {
    private Set<Field> fields;
    private Set<FieldType> required, optional;
    
    public Entry() {
        this.fields = new TreeSet<>();
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
    
    public void addField(Field field) {
        if (required.contains(field.getFieldType()) || optional.contains(field.getFieldType())) {
            fields.add(field);
        } else {
            // doom;
        }
    }
    
    public void removeField(Field field) {
        fields.remove(field);
    }
    
    public void addFieldTypes(FieldType[] required, FieldType[] optional) {
        this.required = new TreeSet<FieldType>();
        this.optional = new TreeSet<FieldType>();
        
        for (FieldType f : required) {
            this.required.add(f);
        }
        for (FieldType f : optional) {
            this.optional.add(f);
        }
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
    
    
}
