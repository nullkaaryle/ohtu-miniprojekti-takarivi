package takarivi.bibtex.view;

import java.util.List;
import takarivi.bibtex.controller.EntryHandler;
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
        EntryHandler entryHandler = new EntryHandler();

        while (true) {
            System.out.print("Command (add, list, quit): ");
            String cmd = io.readIn();
            if (cmd.equals("add")) {

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

                entryHandler.addEntry(entry);
            }
            if (cmd.equals("list")) {
                List<Entry> entries = entryHandler.getEntries();

                for (Entry e : entries) {
                    for (Field f : e.getFields()) {
                        System.out.println(f);
                    }
                    System.out.println("");
                }
            }
            if (cmd.equals("quit")) {
                return;
            }
        }

    }

}
