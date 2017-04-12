/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.model;

import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

/**
 *
 * @author pyykkomi
 */
public class Article extends Entry {

    
    public Article() {
        super(EntryType.ARTICLE);
        FieldType[] req = {FieldType.AUTHOR, FieldType.TITLE, FieldType.JOURNAL, FieldType.YEAR, FieldType.VOLUME};
        FieldType[] opt = {FieldType.NUMBER, FieldType.PAGES, FieldType.MONTH, FieldType.NOTE, FieldType.KEY};
        super.addFieldTypes(req, opt);
    }
}
