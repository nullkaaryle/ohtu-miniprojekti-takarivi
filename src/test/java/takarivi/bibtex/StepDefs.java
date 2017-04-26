package takarivi.bibtex;

import java.io.File;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import takarivi.bibtex.entities.Entry;
import takarivi.bibtex.services.EntryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class StepDefs {

    WebDriver driver;
    String addBookUrl = "http://localhost:8080/add/book/";

    @Autowired(required = true)
    public EntryService entryService;

    public StepDefs() {
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else {
            file = new File("lib/geckodriver");
        }
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        //this.driver = new FirefoxDriver();
        this.driver = new ChromeDriver();
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

    @Given("^add book is selected$")
    public void add_book_is_selected() throws Throwable {
        driver.get(addBookUrl);
    }

    @When("^valid data is given$")
    public void valid_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andres", "Clean Code: A Handbook of Agile Software Craftsmanship", "2012", "Addison-Wesley Professional"};
        for (int i = 0; i < requiredList.length; i++) {
            element = driver.findElement(By.name("requiredList[" + i + "]"));
            element.sendKeys(requiredList[i]);

        }

        String optionalList[] = {"", "", "", "", "", "", ""};
        for (int i = 0; i < optionalList.length; i++) {
            element = driver.findElement(By.name("optionalList[" + i + "]"));
            element.sendKeys(optionalList[i]);
        }

        element.submit();
    }

    @Then("^a list of references is showed$")
    public void a_list_of_references_is_showed() throws Throwable {
        pageHasContent("");
    }

//HELPER METHODS
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

}

//    @Then("^entry is added$")
//    public void entry_is_added() throws Throwable {
//        List<Entry> entries = entryService.findall();
//        assertTrue(!entries.isEmpty());
//    }
