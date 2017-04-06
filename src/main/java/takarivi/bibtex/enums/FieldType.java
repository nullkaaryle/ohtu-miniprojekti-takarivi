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
    AUTHOR("Author", ContentType.STRING), 
    TITLE("Title", ContentType.STRING), 
    JOURNAL("Journal", ContentType.STRING), 
    YEAR("Year", ContentType.STRING), 
    VOLUME("Volume", ContentType.STRING), 
    NUMBER("Number", ContentType.STRING), 
    PAGES("Pages", ContentType.STRING), 
    MONTH("Month", ContentType.STRING), 
    NOTE("Note", ContentType.STRING), 
    KEY("Key", ContentType.STRING);
    
    private final String title;
    private final ContentType contentType;
    
    private FieldType(final String title, final ContentType contentType) {
        this.title = title;
        this.contentType = contentType;
    }
    
    @Override
    public String toString() {
        return title;
    }
}
