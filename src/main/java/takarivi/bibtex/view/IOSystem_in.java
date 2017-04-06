
package takarivi.bibtex.view;

import java.util.Scanner;

public class IOStub implements IO {
    
    private Scanner lukija;
    
    public IOStub() {
        this.lukija = new Scanner(System.in);
    }

    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    @Override
    public String read() {
        String teksti = this.lukija.nextLine();
        return teksti;
    }
    
    
    
    
}
