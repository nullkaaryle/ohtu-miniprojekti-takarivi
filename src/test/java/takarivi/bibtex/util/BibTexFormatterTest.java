/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.util;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;



/**
 *
 * @author maijanen
 */
public class BibTexFormatterTest {

    private List<Entry> entries;
    private Entry test;
    private BibTexFormatter formatter;
    private String key;
    
    public BibTexFormatterTest() {
        
    }

    @Before
    public void setUp() {
        formatter = new BibTexFormatter();
        entries = new ArrayList<>();
        test = new Entry(EntryType.ARTICLE);
        test.setBibTexKey("KEY");
        test.setField(FieldType.AUTHOR, "Maija");
        test.setField(FieldType.YEAR, "1999");
        
    }

    @Test
    public void kirjoittaaTiedostoon() {
        boolean tyhja = false;
        String tiedostonSisalto = formatter.fileToString();
        if (tiedostonSisalto.isEmpty()) {
            tyhja = true;
        }
        
        assertEquals(false, tyhja);
    }
    
    @Test
    public void kirjoittaaOikein() {
        String tuloste = formatter.buildString(test);
        String verrattava = "@article{KEY, \nAuthor = {Maija},\nYear = {1999},\n}\n\n";
        assertEquals(verrattava, tuloste);
    }

}
