package takarivi.bibtex.entities;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import java.io.Serializable;
import java.util.LinkedHashMap;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderColumn;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Entry extends AbstractPersistable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private EntryType entryType;
    private String bibTexKey;
    @MapKeyClass(value = FieldType.class)
    @MapKeyEnumerated(value = EnumType.STRING)
    @ElementCollection
    public Map<FieldType, String> fields;
    @ElementCollection(targetClass = FieldType.class)
    @OrderColumn(name = "field_seq")
    private Set<FieldType> required;
    @ElementCollection(targetClass = FieldType.class)
    @OrderColumn(name = "field_seq")
    private Set<FieldType> optional;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Tag> tags;
    
    public Entry() {
        
    }

    public Entry(EntryType entryType) {
        this.entryType = entryType;
        this.fields = new LinkedHashMap<>();
        this.required = entryType.getRequired();
        this.optional = entryType.getOptional();
        this.tags = new TreeSet<>();
        for (FieldType req : entryType.getRequired()) {
            System.out.println(req);
            fields.put(req, "");
        }
        for (FieldType opt : entryType.getOptional()) {
            System.out.println(opt);
            fields.put(opt, "");
        }
    }

    public Long getId() {
        return id;
    }
    
    public Set<FieldType> getFieldTypes() {
        return fields.keySet();
    }
    
    public Map<FieldType, String> getFields() {
        return fields;
    }

    public void setFields(Map<FieldType, String> fields) {
        this.fields = fields;
    }
    
    public String getField(FieldType ft) {
        return fields.get(ft);
    }
    
    public void /*add*/setField(FieldType fieldType, String field) throws IllegalArgumentException {
        if (required.contains(fieldType) || optional.contains(fieldType))
        {
            fields.put(fieldType, field);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public void removeField(FieldType fieldType) {
        fields.put(fieldType, null);
    }
    
    public void addRequiredFieldTypes(FieldType[] required) {
        this.required.addAll(Arrays.asList(required));
    }
    
    public void addOptionalFieldTypes(FieldType[] optional) {
        this.optional.addAll(Arrays.asList(optional));
    }
    
    public Set<FieldType> getRequired() {
        return required;
    }

    public void setRequired(Set<FieldType> required) {
        this.required = required;
    }
    
    public Set<FieldType> getOptional() {
        return optional;
    }

    public void setOptional(TreeSet<FieldType> optional) {
        this.optional = optional;
    }

    @Enumerated(EnumType.STRING)
    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getBibTexKey() {
        return bibTexKey;
    }

    public void setBibTexKey(String bibTexKey) {
        this.bibTexKey = bibTexKey;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
    
    public boolean containsTag(Tag tag) {
        return tags.contains(tag);
    }
    
    public String createBibTexKey() {
        if (!getFields().containsKey(FieldType.AUTHOR)) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        String[] authors = getField(FieldType.AUTHOR).split(" and ");
        if (authors.length <= 1) {
            sb.append(authors[0].substring(0, 3).toUpperCase());
        } else {
            for (String author : authors) {
                sb.append(author.toUpperCase().charAt(0));
            }
        }
        
        String year = getField(FieldType.YEAR);
        if (!year.equals("")) {
            if (year.length() > 2) {
                sb.append(year.substring(Math.max(0, year.length() - 2), year.length()));
            } else {
                sb.append(year.substring(Math.max(0, year.length() - 4), year.length()));
            }
        }
        
        return sb.toString();
    }
    
//    public boolean validate() {
//        for (FieldType req : required) {
//            if (!fields.containsKey(req) || fields.get(req) == null) {
//               return false; 
//            }
//        }
//        
//        return true;
//    }
}
