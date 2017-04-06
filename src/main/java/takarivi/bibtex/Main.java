package takarivi.bibtex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import takarivi.bibtex.enums.FieldType;
import takarivi.bibtex.model.Article;
import takarivi.bibtex.model.Entry;
import takarivi.bibtex.model.Field;

public class Main {
    
    public static void main(String[] args) {
        List<Entry> entries = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            Entry e = new Article();
            System.out.println("Required fields:\n");
            for (FieldType ft : e.getRequired()) {
                System.out.print(ft + ": ");
                String s = sc.nextLine();
                Field f = new Field(ft, s, 0);
                e.addField(f);
            }
            System.out.println("\nOptional fields:\n");
            for (FieldType ft : e.getOptional()) {
                System.out.print(ft + ": ");
                String s = sc.nextLine();
                Field f = new Field(ft, s, 0);
                e.addField(f);
            }
            System.out.println("");
            for (Field f : e.getFields()) {
                System.out.println(f);
            }
            entries.add(e);
        }
    }
}
