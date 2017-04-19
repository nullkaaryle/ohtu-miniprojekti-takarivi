
package bibtex.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.model.Entry;


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
    
    @After
    public void tearDown() {
    }

    
}
