package takarivi.bibtex;

import java.io.File;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import takarivi.bibtex.services.EntryService;

@SpringBootTest
public class StepDefs {

    WebDriver driver;
    String baseUrl = "http://localhost:8080/list";

    @Autowired(required = true)
    public EntryService entryService;

    public StepDefs() {
        File file = new File("lib/linux/chromedriver");

        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/mac/chromedriver");
        } else if (System.getProperty("os.name").matches("Windows")) {
            file = new File("lib/win/chromedriver.exe");
        }

        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
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

//GIVEN
    @Given("^add article is selected$")
    public void add_article_is_selected() throws Throwable {
        selectEntrytypeToBeAdded("article");
    }

    @Given("^add inproceedings is selected$")
    public void add_inproceedings_is_selected() throws Throwable {
        selectEntrytypeToBeAdded("inproceedings");
    }

    @Given("^add book is selected$")
    public void add_book_is_selected() throws Throwable {
        selectEntrytypeToBeAdded("book");
    }

    @Given("^article is added$")
    public void article_is_added() throws Throwable {
        add_book_is_selected();
        valid_book_data_is_given();
    }

//WHEN 
    @When("^valid book data is given$")
    public void valid_book_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Handbook of Agile Software Craftsmanship", "2012", "Addison-Wesley Professional"};
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

    @When("^invalid book data is given$")
    public void invalid_book_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "", "2012", "Addison-Wesley Professional"};
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

    @When("^valid article data is given$")
    public void valid_article_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
        for (int i = 0; i < requiredList.length; i++) {
            element = driver.findElement(By.name("requiredList[" + i + "]"));
            element.sendKeys(requiredList[i]);

        }

        String optionalList[] = {"", "", "", "", ""};
        for (int i = 0; i < optionalList.length; i++) {
            element = driver.findElement(By.name("optionalList[" + i + "]"));
            element.sendKeys(optionalList[i]);
        }

        element.submit();
    }

    @When("^invalid article data is given$")
    public void invalid_article_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "", "5"};
        for (int i = 0; i < requiredList.length; i++) {
            element = driver.findElement(By.name("requiredList[" + i + "]"));
            element.sendKeys(requiredList[i]);

        }

        String optionalList[] = {"", "", "", "", ""};
        for (int i = 0; i < optionalList.length; i++) {
            element = driver.findElement(By.name("optionalList[" + i + "]"));
            element.sendKeys(optionalList[i]);
        }

        element.submit();
    }

    @When("^valid inproceedings data is given$")
    public void valid_inproceedings_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "Clean Code", "Happy Coding", "2012"};
        for (int i = 0; i < requiredList.length; i++) {
            element = driver.findElement(By.name("requiredList[" + i + "]"));
            element.sendKeys(requiredList[i]);

        }

        String optionalList[] = {"", "", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < optionalList.length; i++) {
            element = driver.findElement(By.name("optionalList[" + i + "]"));
            element.sendKeys(optionalList[i]);
        }

        element.submit();
    }

    @When("^invalid inproceedings data is given$")
    public void invalid_inproceedings_data_is_given() throws Throwable {
        WebElement element = null;

        String requiredList[] = {"Cynthia Andersson", "Clean Code", "", "2012"};
        for (int i = 0; i < requiredList.length; i++) {
            element = driver.findElement(By.name("requiredList[" + i + "]"));
            element.sendKeys(requiredList[i]);

        }

        String optionalList[] = {"", "", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < optionalList.length; i++) {
            element = driver.findElement(By.name("optionalList[" + i + "]"));
            element.sendKeys(optionalList[i]);
        }

        element.submit();
    }

    @When("^the reference is selected and remove button clicked$")
    public void the_reference_is_selected_and_remove_button_clicked() throws Throwable {
        WebElement element = driver.findElement(By.linkText("Remove"));
        element.click();
        driver.switchTo().alert().accept();
    }

//THEN
    @Then("^a list of references is showed$")
    public void a_list_of_references_is_showed() throws Throwable {
        pageDoesNotHaveContent("Required fields");
    }

    @Then("^a prompt is showed$")
    public void a_prompt_is_showed() throws Throwable {
        pageHasContent("required");
    }

    @Then("^the reference is removed$")
    public void the_reference_is_removed() throws Throwable {
        assertTrue(driver.findElements(By.linkText("1")).isEmpty());
    }

//HELPER METHODS
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void pageDoesNotHaveContent(String content) {
        assertFalse(driver.getPageSource().contains(content));
    }

    private void selectEntrytypeToBeAdded(String entrytype) {
        driver.get(baseUrl);
        Select dropdown = new Select(driver.findElement(By.id("selection")));
        dropdown.selectByValue(entrytype);
        WebElement element = driver.findElement(By.name("add"));
        element.click();
    }

}
