package takarivi.bibtex.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.entities.Entry;

public class BibTexFormatter implements Formatter {

    public BibTexFormatter() {

    }

    @Override
    public String export(List<Entry> entries) {
        StringBuilder builder = new StringBuilder();
        for (Entry entry : entries) {
            builder.append(buildString(entry));
        }
        return builder.toString();
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
}
