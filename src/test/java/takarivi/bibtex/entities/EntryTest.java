
package takarivi.bibtex.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;


public class EntryTest {
    Entry artikkeli;
    Entry verrattava;
    Map<FieldType, String> fields;
    Set<FieldType> fieldtypes;
    FieldType[] types;
    
    public EntryTest() {
    }
    
    
    @Before
    public void setUp() {
        artikkeli = new Entry(EntryType.ARTICLE);
        verrattava = new Entry(EntryType.ARTICLE);
        fields = new HashMap<>();
        fields.put(FieldType.TITLE, "Nimi");
        fields.put(FieldType.AUTHOR, "Tekijä");
        fields.put(FieldType.YEAR, "2000");
        verrattava.setFields(fields);
        types = new FieldType[]{FieldType.EDITOR, FieldType.ADDRESS};
        
    }
    
    @Test
    public void getFieldsToimii() {
        Map<FieldType, String> fieldsTest;
        fieldsTest = artikkeli.getFields();
        String testi = "";
        if (fieldsTest.containsKey(FieldType.AUTHOR)) {
            testi = "success";
        }
        assertEquals("success", testi);
    }
    
    @Test
    public void setFieldsToimii() {
        artikkeli.setFields(fields);
        assertEquals(verrattava, artikkeli);
    }
    
    @Test
    public void removeFieldToimii() {
        artikkeli.setFields(fields);
        artikkeli.setField(FieldType.JOURNAL, "Lehti");
        artikkeli.removeField(FieldType.JOURNAL);
        assertEquals(verrattava, artikkeli);

    }
    
    @Test
    public void setFieldToimii() {
        artikkeli.setField(FieldType.TITLE, "Nimi");
        artikkeli.setField(FieldType.AUTHOR, "Tekijä");
        artikkeli.setField(FieldType.YEAR, "2000");
        assertEquals(verrattava, artikkeli);
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void setFieldToimii2() throws Exception {
        artikkeli.setField(FieldType.EDITION, "Edition");
    }
    
    @Test
    public void addOptionalFieldTypesToimii() {
        artikkeli.addOptionalFieldTypes(types);
        Set<FieldType> setti = new HashSet<>();
        for(FieldType type : artikkeli.getOptional()) {
            setti.add(type);
        }
        for(FieldType type : types) {
            setti.add(type);
        }
        assertEquals(setti, artikkeli.getOptional());
    }
    
    @Test
    public void addRequiredFieldTypesToimii() {
        artikkeli.addRequiredFieldTypes(types);
        Set<FieldType> setti = new HashSet<>();
        for(FieldType type : artikkeli.getRequired()) {
            setti.add(type);
        }
        for(FieldType type : types) {
            setti.add(type);
        }
        assertEquals(setti, artikkeli.getRequired());
    }
    
    @Test
    public void createBibtexKeyToimiiKunYksiTekija() {
        artikkeli.setFields(fields);
        artikkeli.setField(FieldType.YEAR, "99");
        String bibtexkey = artikkeli.createBibTexKey();
        assertEquals("TEK99", bibtexkey);
    }
    
    @Test
    public void createBibtexKeyToimiiKunUseaTekija() {
        artikkeli.setFields(fields);
        artikkeli.setField(FieldType.AUTHOR, "Maija and Karitsa");
        String bibtexkey = artikkeli.createBibTexKey();
        assertEquals("MK00", bibtexkey);
    }
    
    @Test
    public void getAuthorsToimii() {
        artikkeli.setFields(fields);
        artikkeli.setField(FieldType.AUTHOR, "Maija and Karitsa");
        artikkeli.setAuthorsAndTitle();
        List<String> authors = artikkeli.getAuthors();
        assertEquals("Nimi", artikkeli.getTitle());
        assertEquals("[Maija, Karitsa]", authors.toString());
    }
    
    @Test
    public void setgetRequiredToimii() {
        artikkeli.setRequired(fieldtypes);
        assertEquals(fieldtypes, artikkeli.getRequired());
    }
    
    @Test
    public void setgetOptionalToimii() {
        TreeSet<FieldType> types = (TreeSet<FieldType>) fieldtypes;
        artikkeli.setOptional(types);
        assertEquals(types, artikkeli.getOptional());
        
    }
    
//    
//    @After
//    public void tearDown() {
//    }

    
}
