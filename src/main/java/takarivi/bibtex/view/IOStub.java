
package takarivi.bibtex.view;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

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
    public String readIn() {
        if (idx < lines.size()) {
            return lines.get(idx++);
        }
        
        return "";
    }
    
    
    
    
}