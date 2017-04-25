
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

    @Override
    public void print(String toPrint) {
        prints.add(toPrint);
        System.out.print(toPrint);
    }
    
    @Override
    public void printLn(String toPrint) {
        print(toPrint + "\n");
    }

    public List<String> getPrints() {
        return prints;
    }
    
    public void addLine(String line) {
        lines.add(line);
    }
    
    @Override
    public String readIn(String line) {
        print(line);
        if (idx < lines.size()) {
            return lines.get(idx++);
        }
        
        return "\u0003";
    }

    
    
    
    
}