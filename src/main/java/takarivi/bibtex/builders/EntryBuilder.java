/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.builders;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;

/**
 *
 * @author pyykkomi
 */
public class EntryBuilder {
    Entry entry;
    
    public EntryBuilder() {
        entry = null;
    }
    
    public EntryBuilder create(EntryType entryType) {
        entry = new Entry(entryType);
        return this;
    }
    
    public EntryBuilder required(List<String> values) {
        FieldType[] req = fieldTypesOrdered(entry.getRequired());
        for (int idx = 0; idx < values.size(); idx++) {
            String s = values.get(idx);
            entry.setField(req[idx], s);
        }
        return this;
    }
    
    public EntryBuilder optional(List<String> values) {
        FieldType[] opt = fieldTypesOrdered(entry.getOptional());
        for (int idx = 0; idx < values.size(); idx++) {
            String s = values.get(idx);
            entry.setField(opt[idx], s);
        }
        return this;
    }
    
    public EntryBuilder bibTexKey(String key) {
        if (key.equals("")) {
            entry.setBibTexKey(createBibTexKey());
        } else {
            entry.setBibTexKey(key);
        }
        return this;
    }
    
    public Entry build() {
        setAuthorsAndTitle();
        return entry;
    }
    
    // helper
    private FieldType[] fieldTypesOrdered(Set<FieldType> fieldTypes) {
        FieldType[] ret = fieldTypes.toArray(new FieldType[fieldTypes.size()]);
        Arrays.sort(ret);
        return ret;
    }
    
    private void setAuthorsAndTitle() {
        if (entry.getFields().containsKey(FieldType.AUTHOR) && 
            !entry.getFields().get(FieldType.AUTHOR).equals("")) {
            String[] authorArray = entry.getField(FieldType.AUTHOR).split(" and ");
            entry.setAuthors(Arrays.asList(authorArray));
        }
        if (entry.getFields().containsKey(FieldType.TITLE) && 
            !entry.getFields().get(FieldType.TITLE).equals("")) {
            entry.setTitle(entry.getFields().get(FieldType.TITLE));
        }
    }
    
    public String getAuthorString() {
        return entry.getFields().containsKey(FieldType.AUTHOR) ? entry.getFields().get(FieldType.AUTHOR) : "";
    }
    
    public String createBibTexKey() {
        if (!entry.getFields().containsKey(FieldType.AUTHOR)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] auths = entry.getField(FieldType.AUTHOR).split(" and ");
        if (auths.length <= 1) {
            sb.append(auths[0].substring(0, Math.min(auths[0].length(), 3)).toUpperCase());
        } else {
            for (String author : auths) {
                sb.append(author.toUpperCase().charAt(0));
            }
        }
        String year = entry.getField(FieldType.YEAR);
        if (!year.equals("")) {
            if (year.length() > 2) {
                sb.append(year.substring(Math.max(0, year.length() - 2), year.length()));
            } else {
                sb.append(year.substring(Math.max(0, year.length() - 4), year.length()));
            }
        }
        return sb.toString();
    }
}
