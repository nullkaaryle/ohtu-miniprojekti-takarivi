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
public class Article extends Entry {

    private Set<FieldType> requiredField, optionalField;
    
    public Article() {
        super();
        Set<FieldType> requiredField = new TreeSet<>();
        Set<FieldType> optionalField = new TreeSet<>();
        FieldType[] req = {FieldType.AUTHOR, FieldType.TITLE, FieldType.JOURNAL, FieldType.YEAR, FieldType.VOLUME};
        FieldType[] opt = {FieldType.NUMBER, FieldType.PAGES, FieldType.MONTH, FieldType.NOTE, FieldType.KEY};
        super.addFieldTypes(req, opt);
    }

    public Set<FieldType> getRequiredField() {
        return requiredField;
    }

    public void setRequiredField(Set<FieldType> requiredField) {
        this.requiredField = requiredField;
    }

    public Set<FieldType> getOptionalField() {
        return optionalField;
    }

    public void setOptionalField(Set<FieldType> optionalField) {
        this.optionalField = optionalField;
    }
    
    
    
    

    
}
