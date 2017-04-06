/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.model;

import takarivi.bibtex.enums.FieldType;

/**
 *
 * @author pyykkomi
 */
public class Field implements Comparable<Field> {
    private FieldType fieldType;
    private ContentType contentType;
    private String content;
    private int index;
    
    public Field(FieldType fieldType, String content, int index) {
        this.fieldType = fieldType;
        this.content = content;
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Field o) {
        if (o.index == index) {
            return fieldType.compareTo(o.fieldType);
        }
        return o.index - index;
    }
    
    
    
}
