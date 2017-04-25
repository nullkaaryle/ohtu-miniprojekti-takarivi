
package takarivi.bibtex.view;

import java.util.Scanner;

public class IOSystem_in implements IO {
    
    private Scanner lukija;
    
    public IOSystem_in(Scanner lukija) {
        this.lukija = lukija;
    }

    @Override
    public void print(String toPrint) {
        System.out.print(toPrint);
        System.out.flush();
    }

    @Override
    public String readIn(String line) {
        System.out.print(line);
        System.out.flush();
        String teksti = this.lukija.nextLine();
        
        return teksti;
    }

    @Override
    public void printLn(String toPrint) {
        print(toPrint + "\n");
    }
    
    
    
    
}
