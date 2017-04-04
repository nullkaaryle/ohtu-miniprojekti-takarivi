/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.model;

/**
 *
 * @author pyykkomi
 */
public class Field implements Comparable<Field> {
    private FieldType field;
    private ContentType content;
    private int index;
    
    public Field(FieldType field, ContentType content, int index) {
        this.field = field;
        this.content = content;
        this.index = index;
    }

    public FieldType getField() {
        return field;
    }

    public void setField(FieldType field) {
        this.field = field;
    }

    public ContentType getContent() {
        return content;
    }

    public void setContent(ContentType content) {
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Field o) {
        return o.index - index;
    }
    
    
    
}
