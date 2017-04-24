/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.entities.Entry;


/**
 *
 * @author jjniitty
 */
public class BibTexFormatter implements Formatter {

    private FileWriter writer;
    private File file;
    private FileReader reader;

    public BibTexFormatter() {

    }

    @Override
    public void export(List<Entry> entries, String filename) {
        file = new File(filename);
        try {
            writer = new FileWriter(file);
            for (Entry entry : entries) {
                CharSequence bibtex = buildString(entry);
                writer.append(bibtex);
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    public String buildString(Entry entry) {
        StringBuilder builder = new StringBuilder();
        Map<FieldType, String> fields = entry.getFields();
        builder.append("@");
        builder.append(entry.getEntryType().toString());
        builder.append("{");
        builder.append(entry.getBibTexKey());
        builder.append(", \n");

        Iterator<FieldType> iterator = fields.keySet().iterator();
        while (iterator.hasNext()) {
            FieldType ft = iterator.next();
            String field = entry.getFields().get(ft);
            if (field == null) {
                break;
            }
          
            if (!(field.equals(""))) {
                builder.append(ft.toString());
                builder.append(" = {");
                builder.append(TextUtils.convertToSpecial((String) field));
                builder.append("}").append(iterator.hasNext() ? "," : "").append("\n");
            }
        }
        builder.append("}");
        builder.append("\n\n");

        String bibtex = builder.toString();

        return bibtex;
    }

    public File getFile() {
        return file;
    }

    public String fileToString() {
        StringBuilder fileContents = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            scanner.close();
            return fileContents.toString();

        } catch (Exception e) {

        }
        return "nyt meni vikaan";
    }

}
