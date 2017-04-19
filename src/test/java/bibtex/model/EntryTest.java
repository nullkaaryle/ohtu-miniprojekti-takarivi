
package bibtex.model;

import gherkin.lexer.Fi;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
    Field note;
    Field publisher;
    
    public EntryTest() {
    }
    
    
    @Before
    public void setUp() {
        artikkeli = new Entry(EntryType.ARTICLE);
        author = new Field(FieldType.AUTHOR, "Maija", 0);
        title = new Field(FieldType.TITLE, "Nimi", 0);
        journal = new Field(FieldType.JOURNAL, "Lehti", 0);
        year = new Field(FieldType.YEAR, "1984", 0);
        volume = new Field(FieldType.VOLUME, "8:12", 0);
        note = new Field(FieldType.NOTE, "huomautus tähän", 0);
        
    }
    
    @Test
    public void addFieldToimii() {
        artikkeli.addField(author); artikkeli.addField(title);
        artikkeli.addField(journal); artikkeli.addField(year);
        artikkeli.addField(volume); artikkeli.addField(note);
        artikkeli.addField(title);
        Map<FieldType, Field> fields = new TreeMap<>();
        fields.put(FieldType.AUTHOR, author);
        fields.put(FieldType.TITLE, title);
        fields.put(FieldType.JOURNAL, journal);
        fields.put(FieldType.YEAR, year);
        fields.put(FieldType.VOLUME, volume);
        fields.put(FieldType.NUMBER, null);
        fields.put(FieldType.PAGES, null);
        fields.put(FieldType.MONTH, null);
        fields.put(FieldType.NOTE, note);
        fields.put(FieldType.KEY, null);
        assertEquals(fields, artikkeli.getFields());
        
    }
    
    @Test
    public void removeFieldToimii() {
        artikkeli.addField(title);
        artikkeli.addField(author);
        artikkeli.addField(year);
        artikkeli.removeField(author);
        artikkeli.removeField(year);
        artikkeli.removeField(title);
        Map<FieldType, Field> fields = new TreeMap<>();
        fields.put(FieldType.AUTHOR, null);
        fields.put(FieldType.TITLE, null);
        fields.put(FieldType.JOURNAL, null);
        fields.put(FieldType.YEAR, null);
        fields.put(FieldType.VOLUME, null);
        fields.put(FieldType.NUMBER, null);
        fields.put(FieldType.PAGES, null);
        fields.put(FieldType.MONTH, null);
        fields.put(FieldType.NOTE, null);
        fields.put(FieldType.KEY, null);
        assertEquals(fields, artikkeli.getFields());

    }
    
    @Test
    public void addOptionalFieldTypesToimii() {
        FieldType[] lisattava = new FieldType[1];
        lisattava[0] = FieldType.PUBLISHER;
        artikkeli.addOptionalFieldTypes(lisattava);
        Set<FieldType> verrattava = new TreeSet();
        verrattava.add(FieldType.NUMBER);
        verrattava.add(FieldType.PAGES);
        verrattava.add(FieldType.MONTH);
        verrattava.add(FieldType.NOTE);
        verrattava.add(FieldType.KEY);
        verrattava.add(FieldType.PUBLISHER);
        assertEquals(verrattava, artikkeli.getOptional());
    }
    
    @Test
    public void addRequiredFieldTypesToimii() {
        FieldType[] lisattava = new FieldType[1];
        lisattava[0] = FieldType.PUBLISHER;
        artikkeli.addRequiredFieldTypes(lisattava);
        Set<FieldType> verrattava = new TreeSet();
        verrattava.add(FieldType.AUTHOR);
        verrattava.add(FieldType.TITLE);
        verrattava.add(FieldType.JOURNAL);
        verrattava.add(FieldType.YEAR);
        verrattava.add(FieldType.VOLUME);
        verrattava.add(FieldType.PUBLISHER);
        assertEquals(verrattava, artikkeli.getRequired());
    }
    
    @Test
    public void createBibtexKeyToimiiKunYksiTekija() {
        Field vuosi = new Field(FieldType.YEAR, "92", 0);
        artikkeli.addField(author);
        artikkeli.addField(title);
        artikkeli.addField(vuosi);
        artikkeli.addField(journal);
        artikkeli.addField(volume);
        String vertaus = "MAI92";
        assertEquals(vertaus, artikkeli.createBibTexKey());
    }
    
    @Test
    public void createBibtexKeyToimiiKunUseaTekija() {
        Field manyauthors = new Field(FieldType.AUTHOR, "Maija and Pinni", 0);
        artikkeli.addField(manyauthors);
        artikkeli.addField(title);
        artikkeli.addField(year);
        artikkeli.addField(journal);
        artikkeli.addField(volume);
        String vertaus = "MP84";
        assertEquals(vertaus, artikkeli.createBibTexKey());
    }
    
    
    @After
    public void tearDown() {
    }

    
}
