/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Set;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

/**
 *
 * @author jjniitty
 */
public class BibTexFormatter implements Formatter {

    private File file;
    private StringBuilder builder;
    private FileWriter writer;

    public BibTexFormatter() {
        file = new File("tiedosto.txt");
        builder = new StringBuilder();
        try {
            writer = new FileWriter(file);
        } catch (Exception e) {
        }
    }

    @Override
    public void export(Entry entry, EntryType entrytype) {
        CharSequence bibtex = buildString(entry, entrytype);
        try {
            writer.append(bibtex);
            writer.close();
        } catch (Exception e) {
        }
        

    }

    public String buildString(Entry entry, EntryType entrytype) {
        Set<Field> fields = entry.getFields();
        builder.append("@");
        builder.append(entrytype.toString());
        builder.append("{ ");
        for (Field field : fields) {
            if (field.getFieldType() == FieldType.KEY) {
                builder.append((String) field.getContent());
                builder.append(", \n");
            }
        }
        Iterator iterator = fields.iterator();
        while (iterator.hasNext()) {
            Field field = (Field) iterator.next();
            if (field.getFieldType() != FieldType.KEY) {
                builder.append(field.getFieldType().toString());
                builder.append(" = \"");
                builder.append((String) field.getContent());
                if (iterator.hasNext()) {
                    builder.append("\", \n");
                } else {
                    builder.append("\" }");
                }
            }
        }
        String bibtex = builder.toString();
        return bibtex;
    }

}
