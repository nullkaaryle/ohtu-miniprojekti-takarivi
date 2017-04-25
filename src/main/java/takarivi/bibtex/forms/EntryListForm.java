/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.forms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pyykkomi
 */
public class EntryListForm {
    private List<Long> selected = new ArrayList<>();
    private String filename;
    
    public List<Long> getSelected() {
        return selected;
    }

    public void setSelected(List<Long> selected) {
        this.selected = selected;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
}
