package takarivi.bibtex;

import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Article;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;
import takarivi.bibtex.view.IO;
import takarivi.bibtex.view.IOSystem_in;
import takarivi.bibtex.view.TextUI;

public class Main {
    
    public static void main(String[] args) {
        IO io = new IOSystem_in();
        TextUI ui = new TextUI(io);
        ui.run();
        }
        
    }
