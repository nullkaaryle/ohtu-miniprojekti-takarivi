/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtex.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import takarivi.bibtex.controller.BibTexFormatter;
import takarivi.bibtex.enums.EntryType;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

/**
 *
 * @author maijanen
 */
public class BibTexFormatterTest {

    private BibTexFormatter formatter = new BibTexFormatter();
    private Entry entry = new Entry(EntryType.ARTICLE);
    private List<Entry> entrit = new ArrayList<>();
    private FileReader reader;

    public BibTexFormatterTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entry.addField(new Field(FieldType.AUTHOR, "Kakkis", 1));
        entry.setBibTexKey("lol");

        entrit.add(entry);
        formatter.export(entrit, "moi.txt");
    }

    @After
    public void tearDown() {
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
        String tiedostonSisalto = formatter.fileToString();
        String oltava = "@article{lol, \nAuthor = {Kakkis},\n}\n\n";
        assertEquals(oltava, tiedostonSisalto);
    }

}
