/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.entities.builders;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.enums.EntryType;

/**
 *
 * @author pyykkomi
 */
public class EntryBuilderTest {
    
    private EntryBuilder entryBuilder;
    
    // 
    public EntryBuilderTest() {
    }
    
    @Before
    public void setUp() {
        entryBuilder = new EntryBuilder();
    }
    
    @Test
    public void bibtexAndAuthorCorrect() {
        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
        String optionalList[] = {"1", "2", "3", "4", "5"};
        Entry e = entryBuilder.create(EntryType.ARTICLE)
                              .required(toArrayList(requiredList))
                              .optional(toArrayList(optionalList))
                              .bibTexKey("")
                              .build();
        assertEquals("CYN12", e.getBibTexKey());
        assertEquals("Cynthia Andersson", e.getAuthorString());
    }
    
    @Test
    public void bibtexCorrectGiven() {
        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
        String optionalList[] = {"1", "2", "3", "4", "5"};
        Entry e = entryBuilder.create(EntryType.ARTICLE)
                              .required(toArrayList(requiredList))
                              .optional(toArrayList(optionalList))
                              .bibTexKey("kissa")
                              .build();
        assertEquals("kissa", e.getBibTexKey());
    }
    
    @Test
    public void multipleAuthorsGiven() {
        String requiredList[] = {"Andersson and Pettersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
        String optionalList[] = {"1", "2", "3", "4", "5"};
        Entry e = entryBuilder.create(EntryType.ARTICLE)
                              .required(toArrayList(requiredList))
                              .optional(toArrayList(optionalList))
                              .bibTexKey("")
                              .build();
        assertEquals("AP12", e.getBibTexKey()); 
    }
    
    @Test
    public void editEntryTest() {
        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
        String optionalList[] = {"1", "2", "3", "4", "5"};
        Entry e = entryBuilder.create(EntryType.ARTICLE)
                              .required(toArrayList(requiredList))
                              .optional(toArrayList(optionalList))
                              .bibTexKey("")
                              .build();
        String requiredList2[] = {"Tester", "testi", "1999", "testi", "2"};
        Entry e2 = entryBuilder.edit(e)
                               .required(toArrayList(requiredList2))
                               .optional(toArrayList(optionalList))
                               .bibTexKey("")
                               .build();
        assertEquals("TES99", e2.getBibTexKey());
        assertEquals("Tester", e2.getAuthorString());
    }
    
    // helper
    public ArrayList<String> toArrayList(String[] content) {
        return new ArrayList<>(Arrays.asList(content));
    }
}
