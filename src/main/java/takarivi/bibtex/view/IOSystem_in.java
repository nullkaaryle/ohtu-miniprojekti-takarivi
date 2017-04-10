
package takarivi.bibtex.view;

import java.util.Scanner;

public class IOSystem_in implements IO {
    
    private Scanner lukija;
    
    public IOSystem_in() {
        this.lukija = new Scanner(System.in);
    }

    @Override
    public void printOut(String toPrint) {
        System.out.println(toPrint);
        System.out.flush();
    }

    @Override
    public String readIn(String line) {
        System.out.print(line);
        System.out.flush();
        String teksti = this.lukija.nextLine();
        
        return teksti;
    }
    
    
    
    
}
