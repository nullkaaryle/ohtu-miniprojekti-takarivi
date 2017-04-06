/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.enums;

/**
 *
 * @author pyykkomi
 */
public enum FieldType {
    AUTHOR("Author"), 
    TITLE("Title"), 
    JOURNAL("Title"), 
    YEAR("Year"), 
    VOLUME("Volume"), 
    NUMBER("Number"), 
    PAGES("Pages"), 
    MONTH("Month"), 
    NOTE("Note"), 
    KEY("Key");
    
    private final String title;

    private FieldType(final String title) {
        this.title = title;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
