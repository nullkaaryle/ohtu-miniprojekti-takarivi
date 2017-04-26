/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.forms;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author pyykkomi
 */
public class EntryTypeForm {
    private List<String> entryTypes = new ArrayList<>();
    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    
    public List<String> getEntryTypes() {
        return entryTypes;
    }

    public void setEntryTypes(List<String> entryTypes) {
        this.entryTypes = entryTypes;
    }
}
