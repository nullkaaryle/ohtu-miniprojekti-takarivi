package takarivi.bibtex.view;

import java.util.List;
import takarivi.bibtex.controller.BibTexFormatter;
import takarivi.bibtex.controller.EntryHandler;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Article;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

public class TextUI {

    private IO io;
    private Entry entry;
    private BibTexFormatter f;

    public TextUI(IO io) {
        this.io = io;
        f = new BibTexFormatter();
    }

    public void consolePrintln(String string) {
        consolePrint(string + "\n");
    }
    
    public void consolePrint(String string) {
        System.out.print(string);
        System.out.flush();
    }
    
    public void run() {
        EntryHandler entryHandler = new EntryHandler();

        while (true) {

            String cmd = io.readIn("Command (add, list, quit, write): ");

            if (cmd.equals("add")) {

                Entry entry = new Article();
                consolePrintln("\nRequired fields:");
                for (FieldType ft : entry.getRequired()) {
                    String input = "";
                    while (input.equals("")) {
                        input = io.readIn("Please enter " + ft + ": ");
                        if (input.equals("")) {
                            io.printOut(ft + " is required!");
                        }
                    }
                    
                    entry.addField(new Field(ft, input, 0));
                }

                consolePrintln("\nOptional fields:");

                for (FieldType ft : entry.getOptional()) {
                    String input = io.readIn("Please enter " + ft + ": ");
                    entry.addField(new Field(ft, input, 0));
                }

                entryHandler.addEntry(entry);
            }
            if (cmd.equals("list")) {
                List<Entry> entries = entryHandler.getEntries();

                for (Entry e : entries) {
                    for (Field f : e.getFields()) {
                        consolePrintln(f.toString());
                    }
                    consolePrintln("");
                }
            }
            if (cmd.equals("quit")) {
                return;
            }
            if (cmd.equals("write")) {
                f.export(entryHandler.getEntries().get(0), EntryType.ARTICLE);
            }
        }

    }

}
