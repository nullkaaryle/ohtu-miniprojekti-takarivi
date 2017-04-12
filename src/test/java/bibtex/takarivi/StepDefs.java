package bibtex.takarivi;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
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
        ui = new TextUI(io);
        ui.run();
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
    }

    @Then("^error message is shown$")
    public void error_message_is_shown() throws Throwable {
        outputContains("is required!");
    }

//AFTER
    @After
    public void tearDown() {
    }

//HELPER METHODS
    private void outputContains(String line) {
        boolean found = false;
        for (String s : io.getPrints()) {
            if (s.contains(line)) {
                found = true;
            }
        }
        assertTrue(found);
    }
}
