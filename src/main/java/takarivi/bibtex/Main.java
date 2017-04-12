package takarivi.bibtex;

import java.util.ArrayList;
import takarivi.bibtex.view.IOStub;
import takarivi.bibtex.view.TextUI;

public class Main {

    public static void main(String[] args) {
//        IO io = new IOSystem_in(new Scanner(System.in));
        IOStub io = new IOStub(new ArrayList<>());
        TextUI ui = new TextUI(io);
        io.addLine("add");
        io.addLine("asdf");
        ui.run();

    }
}
