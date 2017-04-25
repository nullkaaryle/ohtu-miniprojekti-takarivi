/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maijanen
 */
public class TextUtilsTest {
    private String aakkosia;
    private String kaannetty;
    
    public TextUtilsTest() {
    }
    
    @Before
    public void setUp() {
        aakkosia = "KÄKÅKÖKÜkäkåkökü";
        kaannetty = "K\\\"{A}K\\AAK\\\"{O}K\\\"{U}k\\\"{a}k\\aak\\\"{o}k\\\"{u}";
    }
    
    @Test
    public void fromToimii() {
        String tulos = TextUtils.convertToSpecial(aakkosia);
        assertEquals(kaannetty, tulos);
    }
    
    @Test
    public void toToimii() {
        String tulos = TextUtils.convertFromSpecial(kaannetty);
        assertEquals(aakkosia, tulos);
    }
}
