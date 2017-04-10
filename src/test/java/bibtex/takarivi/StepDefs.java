/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibtex.takarivi;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import takarivi.bibtex.view.IOStub;
import takarivi.bibtex.view.TextUI;

/**
 *
 * @author pyykkomi
 */
public class StepDefs {

    private IOStub io;
    private TextUI ui;
    
    private List<String> inputLines = new ArrayList<>();
    
    @Before
    public void setUp() {
        io = new IOStub(inputLines);
        ui = new TextUI(io);
    }
    
    @After
    public void tearDown() {
    }

    @Given("^add article is selected$")
    public void add_article_is_selected() throws Throwable {
        inputLines.add("add");
        ui.run();
    }

    @When("^\"([^\"]*)\" is given$")
    public void is_given(String input) throws Throwable {
        inputLines.add(input);
        ui.run();
    }

    @Then("^article is added$")
    public void article_is_added() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^error message is shown$")
    public void error_message_is_shown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
