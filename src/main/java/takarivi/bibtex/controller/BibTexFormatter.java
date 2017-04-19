/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;
import takarivi.bibtex.util.TextUtils;


/**
 *
 * @author jjniitty
 */
public class BibTexFormatter implements Formatter {

    private FileWriter writer;

    public BibTexFormatter() {

    }

    @Override
    public void export(List<Entry> entries, EntryType entrytype, String filename) {
        File file = new File(filename);
        try {
            writer = new FileWriter(file);
        } catch (Exception e) {
        }
        for (Entry entry : entries) {
            CharSequence bibtex = buildString(entry, entrytype);
            try {
                writer.append(bibtex);

            } catch (Exception e) {
            }
        }
        try {
            writer.close();
        } catch (Exception e) {
        }
    }

    public String buildString(Entry entry, EntryType entrytype) {
        StringBuilder builder = new StringBuilder();
        Set<FieldType> fields = entry.getFields().keySet();
        builder.append("@");
        builder.append(entrytype.toString());
        builder.append("{");
        builder.append(entry.getBibTexKey());
        builder.append(", \n");

        Iterator<FieldType> iterator = fields.iterator();
        while (iterator.hasNext()) {
            Field field = entry.getFields().get(iterator.next());
            if (!((String) field.getContent()).equals("")) {
                builder.append(field.getFieldType().toString());
                builder.append(" = {");
                builder.append(TextUtils.convertToSpecial((String) field.getContent()));
                builder.append("}").append(iterator.hasNext() ? "," : "").append("\n");
            }
        }
        builder.append("}");
        builder.append("\n\n");

        String bibtex = builder.toString();
        return bibtex;
    }

}
