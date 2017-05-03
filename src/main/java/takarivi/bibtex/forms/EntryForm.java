/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.forms;

import java.util.ArrayList;
import java.util.Arrays;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.FieldType;

/**
 *
 * @author pyykkomi
 */
public class EntryForm {
    private ArrayList<String> requiredList = new ArrayList<>();
    private ArrayList<String> optionalList = new ArrayList<>();
    private Long id;
    private String action;
    private String bibTexKey;
    private String entryType;
    
    /* default constructor for spring */
    public EntryForm() {
        
    }
    
    /* constructor for new entry */
    public EntryForm(String type, String action, Long id) {
        this.action = action;
        this.id = id;
        this.entryType = type;
    }
    
    /* constructor for existing entry */
    public EntryForm(Entry entry, String action) {
        FieldType[] req = entry.getRequired().toArray(new FieldType[entry.getRequired().size()]);
        Arrays.sort(req);
        for (int idx = 0; idx < entry.getRequired().size(); idx++) {
            requiredList.add(idx, entry.getField(req[idx]));
        }
        FieldType[] opt = entry.getOptional().toArray(new FieldType[entry.getOptional().size()]);
        Arrays.sort(opt);
        for (int idx = 0; idx < entry.getOptional().size(); idx++) {
            optionalList.add(idx, entry.getField(opt[idx]));
        }
        this.action = action;
        this.id = entry.getId();
        this.bibTexKey = entry.getBibTexKey();
        this.entryType = entry.getEntryType().toString();
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ArrayList<String> getRequiredList() {
        return requiredList;
    }

    public void setRequiredList(ArrayList<String> requiredList) {
        this.requiredList = requiredList;
    }

    public ArrayList<String> getOptionalList() {
        return optionalList;
    }

    public void setOptionalList(ArrayList<String> optionalList) {
        this.optionalList = optionalList;
    }

    public String getBibTexKey() {
        return bibTexKey;
    }

    public void setBibTexKey(String bibTexKey) {
        this.bibTexKey = bibTexKey;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }
    
    
}
