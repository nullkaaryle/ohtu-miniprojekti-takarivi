/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.forms;

import java.util.ArrayList;

/**
 *
 * @author pyykkomi
 */
public class EntryForm {
    private ArrayList<String> requiredList = new ArrayList<>();
    private ArrayList<String> optionalList = new ArrayList<>();
    
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
}
