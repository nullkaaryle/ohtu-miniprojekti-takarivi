
package bibtex.takarivi;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import takarivi.bibtex.view.IOStub;
import takarivi.bibtex.view.TextUI;

public class StepDefs {

    private TextUI ui;
    private List<String> inputLines = new ArrayList<>();
    private IOStub io = new IOStub(inputLines);

//BEFORE    
    @Before
    public void setUp() {
        inputLines.clear();
    }

//GIVEN
    @Given("^add article is selected$")
    public void add_article_is_selected() throws Throwable {
        inputLines.add("add");
    }

//WHEN
    @When("^\"([^\"]*)\" is given$")
    public void is_given(String input) throws Throwable {
        inputLines.add(input);
    }

//THEN
    @Then("^article is added$")
    public void article_is_added() throws Throwable {
        //TextUi:n EntryHandlerin listaan on lisätty article-entry
        inputLines.add("quit");
        ui = new TextUI(io);
        ui.run();
        assertEquals(1, ui.getEntryHandler().getEntries().size());
    }

    @Then("^error message is shown and article is not added$")
    public void error_message_is_shown_and_article_is_not_added() throws Throwable {
        for (int i = 0; i < 20; i++) {
            inputLines.add("x");
        }
        inputLines.add("quit");
        ui = new TextUI(io);
        ui.run();
        assertTrue(outputContains("BibTexKey is required!"));
        assertEquals(0, ui.getEntryHandler().getEntries().size());
    }

//AFTER
    @After
    public void tearDown() {
    }

//HELPER METHODS
    private boolean outputContains(String line) {
        for (String s : io.getPrints()) {
            if (s.contains(line)) {
                return true;
            }
        }
        return false;
    }
}
