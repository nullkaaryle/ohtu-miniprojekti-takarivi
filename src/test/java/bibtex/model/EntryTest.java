
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
    Field author;
    Field title;
    Field journal;
    Field year;
    Field volume;
    
    public EntryTest() {
    }
    
    
    @Before
    public void setUp() {
        artikkeli = new Entry(EntryType.ARTICLE);
        author = new Field(FieldType.AUTHOR, "Maija", 0);
        title = new Field(FieldType.TITLE, "Nimi", 0);
        journal = new Field(FieldType.JOURNAL, "Lehti", 0);
        
        
    }
    
    @Test
    public void addFieldToimiiKunFieldOnRequired() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    
}
