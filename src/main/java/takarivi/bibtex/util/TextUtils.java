/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex.util;

/**
 *
 * @author pyykkomi
 */
public class TextUtils {
    
    public static String convertFromSpecial(String s) {
        String conv = s.replace("\\\"{a}", "ä");
        conv = conv.replace("\\\"{o}", "ö");
        conv = conv.replace("\\\"{u}", "ü");
        conv = conv.replace("\\aa", "å");
        conv = conv.replace("\\\"{A}", "Ä");
        conv = conv.replace("\\\"{O}", "Ö");
        conv = conv.replace("\\\"{U}", "Ü");
        conv = conv.replace("\\AA", "Å");
        return conv;
    }
    
    public static String convertToSpecial(String s) {
        String conv = s.replace("ä", "\\\"{a}");
        conv = conv.replace("ö", "\\\"{o}");
        conv = conv.replace("ü", "\\\"{u}");
        conv = conv.replace("å", "\\aa");
        conv = conv.replace("Ä", "\\\"{A}");
        conv = conv.replace("Ö", "\\\"{O}");
        conv = conv.replace("Ü", "\\\"{U}");
        conv = conv.replace("Å", "\\AA");
        return conv;
    }
}
