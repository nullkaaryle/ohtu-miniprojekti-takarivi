
package takarivi.bibtex.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    
//    @Test
//    public void addOptionalFieldTypesToimii() {
//        
//    }
//    
//    @Test
//    public void addRequiredFieldTypesToimii() {
//        
//    }
//    
//    @Test
//    public void createBibtexKeyToimiiKunYksiTekija() {
//        
//    }
//    
//    @Test
//    public void createBibtexKeyToimiiKunUseaTekija() {
//        
//    }
//    
//    
//    @After
//    public void tearDown() {
//    }

    
}
