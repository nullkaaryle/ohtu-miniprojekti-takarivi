
package takarivi.bibtex.view;

import java.util.ArrayList;
import java.util.Scanner;

public class IOStub implements IO {
    
    private ArrayList<String> list;
    
    public IOStub(ArrayList list) {
        this.list = list;
    }

    @Override
    public void printOut(String toPrint) {
        System.out.println(toPrint);
    }

    @Override
    public String readIn() {
        return list.toString();
    }
    
    
    
    
}