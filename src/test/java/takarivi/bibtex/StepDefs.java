package takarivi.bibtex;

import java.io.File;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefs {

    WebDriver driver;

    public StepDefs() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        this.driver = new FirefoxDriver();
    }
    
//BEFORE    
    @Before
    public void setUp() {
    }

//AFTER
    @After
    public void tearDown() {
        driver.quit();
    }
    
//       @Given("^add article is selected$")
//    public void add_article_is_selected() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^\"([^\"]*)\" is given$")
//    public void is_given(String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^article is added$")
//    public void article_is_added() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^valid data is given$")
//    public void valid_data_is_given(DataTable arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//        // E,K,V must be a scalar (String, Integer, Date, enum etc)
//        throw new PendingException();
//    }
//
//    @Then("^a list of references is showed$")
//    public void a_list_of_references_is_showed() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

}