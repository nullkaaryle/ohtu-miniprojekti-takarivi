package takarivi.bibtex.view;

import java.util.List;
import takarivi.bibtex.controller.BibTexFormatter;
import takarivi.bibtex.controller.EntryHandler;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

public class TextUI {

    private IO io;
    private EntryHandler entryHandler;
    private BibTexFormatter f;

    public TextUI(IO io) {
        this.io = io;
        f = new BibTexFormatter();
        entryHandler = new EntryHandler();
    }

    public String getInputErrorCheck(String field, String def) {
        String input = "";
        while (input.equals("")) {
            input = io.readIn("Please enter " + field + 
                              (def.equals("") ? "" : " (default: " + def + ")") + ": ");
            if (input.equals("") & def.equals("")) {
                io.print(field + " is required!\n");
            } else if (input.equals("") & !def.equals("")) {
                input = def;
            }
        }
        return input;
    }

    public EntryHandler getEntryHandler() {
        return entryHandler;
    }
    
    public void run() {
        
        String input = "";
        
        while (true) {

            String cmd = io.readIn("Command (add, list, quit, write): ");

            if (cmd.equals("add")) {

                io.printLn("Content types available: ");
                for (EntryType et : EntryType.values()) {
                    io.printLn(et.toString());
                }
                EntryType type = null;
                while (type == null) {
                    input = io.readIn("Content type: ");
                    for (EntryType et : EntryType.values()) {
                        if (input.toLowerCase().equals(et.toString().toLowerCase())) {
                            type = et;
                        }
                    }
                }
                Entry entry = new Entry(type);
                io.printLn("\nRequired fields:");
                for (FieldType ft : entry.getRequired()) {
                    input = getInputErrorCheck(ft.toString(), "");
                    entry.addField(new Field(ft, input, 0));
                }

                entry.setBibTexKey(getInputErrorCheck("BibTexKey", entry.createBibTexKey()));
                io.printLn("\nOptional fields:");

                for (FieldType ft : entry.getOptional()) {
                    input = io.readIn("Please enter " + ft + ": ");
                    entry.addField(new Field(ft, input, 0));
                }

                entryHandler.addEntry(entry);
            }
            if (cmd.equals("list")) {
                List<Entry> entries = entryHandler.getEntries();

                for (Entry e : entries) {
                    io.printLn("Type: " + e.getEntryType().toString());
                    for (FieldType ft : e.getFieldTypes()) {
                        io.printLn(e.getFields().get(ft).toString());
                    }
                    io.printLn("BibTexKey: " + e.getBibTexKey());
                    io.printLn("");
                }
            }
            if (cmd.equals("quit")) {
                return;
            }
            if (cmd.equals("write")) {
                String filename = io.readIn("Enter file name: ");
                f.export(entryHandler.getEntries(), filename);
                
            }

        }

    }

}
