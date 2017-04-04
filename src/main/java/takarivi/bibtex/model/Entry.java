/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.model;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pyykkomi
 */
public class Entry {
    private Set<Field> fields;
    
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
        fields.add(field);
    }
    
    public void removeField(Field field) {
        fields.remove(field);
    }
}
