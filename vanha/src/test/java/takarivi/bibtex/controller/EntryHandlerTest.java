
package takarivi.bibtex.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.controller.EntryHandler;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.model.Entry;


public class EntryHandlerTest {
    EntryHandler eh;
    Entry artikkeli;
    Entry kirja;
    Entry julkaisu;
    
    public EntryHandlerTest() {
    }
    
    @Before
    public void setUp() {
        eh = new EntryHandler();
        artikkeli = new Entry(EntryType.ARTICLE);
        kirja = new Entry(EntryType.BOOK);
        julkaisu = new Entry(EntryType.INPROCEEDINGS);
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void addEntryToimii() {
        eh.addEntry(artikkeli);
        eh.addEntry(kirja);
        eh.addEntry(julkaisu);
        List<Entry> testilista = new ArrayList<>();
        testilista.add(artikkeli);
        testilista.add(kirja); 
        testilista.add(julkaisu);
        
        assertEquals(testilista, eh.getEntries());
    }
    
    @Test
    public void getEntriesToimii() {
        eh.addEntry(artikkeli);
        eh.addEntry(kirja);
        eh.addEntry(julkaisu);
        eh.addEntry(kirja);
        eh.addEntry(kirja);
        List<Entry> testilista = new ArrayList<>();
        testilista.add(artikkeli);
        testilista.add(kirja); 
        testilista.add(julkaisu);
        testilista.add(kirja);
        testilista.add(kirja);
        assertEquals(testilista.toString(), eh.getEntries().toString());
    }
}
