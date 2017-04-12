
package takarivi.bibtex.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOStub implements IO {
    
    private List<String> lines;
    private List<String> prints;
    private int idx;
    
    public IOStub(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }

    public void print(String string) {
        prints.add(string);
    }

    @Override
    public void printOut(String toPrint) {
        System.out.println(toPrint);
    }

    public List<String> getPrints() {
        return prints;
    }
    
    @Override
    public String readIn(String line) {
        print(line);
        if (idx < lines.size()) {
            return lines.get(idx++);
        }
        
        return "";
    }
    
    
    
    
}