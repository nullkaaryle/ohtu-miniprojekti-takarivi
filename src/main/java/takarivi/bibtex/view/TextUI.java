package takarivi.bibtex.view;

import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Article;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

public class TextUI {

    private IO io;
    private Entry entry;

    public TextUI(IO io) {
        this.io = io;
    }

    public void run() {
        Entry entry = new Article();
        System.out.println("\nRequired fields:");

        for (FieldType ft : entry.getRequired()) {
            System.out.print("Please enter " + ft + ": ");
            entry.addField(new Field(ft, io.readIn(), 0));
        }

        System.out.println("\nOptional fields:");

        for (FieldType ft : entry.getOptional()) {
            System.out.print("Please enter " + ft + ": ");
            entry.addField(new Field(ft, io.readIn(), 0));
        }

        
    }

}
