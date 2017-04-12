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

    public String getInputErrorCheck(String field) {
        String input = "";
        while (input.equals("")) {
            input = io.readIn("Please enter " + field + ": ");
            if (input.equals("")) {
                io.print(field + " is required!\n");
            }
        }
        return input;
    }
    
    public void run() {
        EntryHandler entryHandler = new EntryHandler();

        while (true) {

            String cmd = io.readIn("Command (add, list, quit, write): ");

            if (cmd.equals("add")) {

                Entry entry = new Article();
                io.printLn("\nRequired fields:");
                entry.setBibTexKey(getInputErrorCheck("Please enter BibTexKey: "));
                for (FieldType ft : entry.getRequired()) {
                    String input = getInputErrorCheck("Please enter " + ft + ": ");
                    entry.addField(new Field(ft, input, 0));
                }

                io.printLn("\nOptional fields:");

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
                        io.printLn(f.toString());
                    }
                    io.printLn("");
                }
            }
            if (cmd.equals("quit")) {
                return;
            }
            if (cmd.equals("write")) {
                String filename = io.readIn("Enter file name: ");
                f.export(entryHandler.getEntries(), EntryType.ARTICLE, filename);
                
            }

        }

    }

}
