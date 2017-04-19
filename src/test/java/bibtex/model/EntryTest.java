
package bibtex.model;

import gherkin.lexer.Fi;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;


public class EntryTest {
    Entry artikkeli;
    Entry kirja;
    Entry julkaisu;
    
    public EntryTest() {
    }
    
    
    @Before
    public void setUp() {
        artikkeli = new Entry(EntryType.ARTICLE);
        kirja = new Entry(EntryType.BOOK);
        julkaisu = new Entry(EntryType.INPROCEEDINGS);
    }
    
    @Test
    public void addFieldToimiiKunFieldOnRequired() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    
}
