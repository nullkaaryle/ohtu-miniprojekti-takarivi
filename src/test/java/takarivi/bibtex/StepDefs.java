//package takarivi.bibtex;
//
//import java.io.File;
//import cucumber.api.java.After;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import takarivi.bibtex.services.EntryService;
//
//@SpringBootTest
//public class StepDefs {
//
//    WebDriver driver;
//    String baseUrl = "http://localhost:8080/list";
//    String addBookUrl = "http://localhost:8080/add/book/";
//    String addArticleUrl = "http://localhost:8080/add/article/";
//    String addInproceedingsUrl = "http://localhost:8080/add/inproceedings/";
//
//    @Autowired(required = true)
//    public EntryService entryService;
//
//    public StepDefs() {
//        File file;
//        if (System.getProperty("os.name").matches("Mac OS X")) {
//            file = new File("lib/macgeckodriver");
//        } else {
//            file = new File("lib/geckodriver");
//        }
//        String absolutePath = file.getAbsolutePath();
//        System.setProperty("webdriver.gecko.driver", absolutePath);
//
////        this.driver = new FirefoxDriver();
//        this.driver = new ChromeDriver();
//    }
//
////BEFORE    
//    @Before
//    public void setUp() {
//    }
//
////AFTER
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//
////GIVEN
//    @Given("^add book is selected$")
//    public void add_book_is_selected() throws Throwable {
//        driver.get(addBookUrl);
//    }
//
//    @Given("^add article is selected$")
//    public void add_article_is_selected() throws Throwable {
//        driver.get(addArticleUrl);
//    }
//
//    @Given("^add inproceedings is selected$")
//    public void add_inproceedings_is_selected() throws Throwable {
//        driver.get(addInproceedingsUrl);
//    }
//    
//    @Given("^article is added$")
//    public void article_is_added() throws Throwable {
//        add_book_is_selected();
//        valid_book_data_is_given();
//    }
//
////WHEN 
//    @When("^valid book data is given$")
//    public void valid_book_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "Clean Code: A Handbook of Agile Software Craftsmanship", "2012", "Addison-Wesley Professional"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//
//    @When("^invalid book data is given$")
//    public void invalid_book_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "", "2012", "Addison-Wesley Professional"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//
//    @When("^valid article data is given$")
//    public void valid_article_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "The Code Magazine", "5"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//
//    @When("^invalid article data is given$")
//    public void invalid_article_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "Clean Code: A Survey of Agile Software Craftsmanship", "2012", "", "5"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//
//    @When("^valid inproceedings data is given$")
//    public void valid_inproceedings_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "Clean Code", "Happy Coding", "2012"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", "", "", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//
//    @When("^invalid inproceedings data is given$")
//    public void invalid_inproceedings_data_is_given() throws Throwable {
//        WebElement element = null;
//
//        String requiredList[] = {"Cynthia Andres", "Clean Code", "", "2012"};
//        for (int i = 0; i < requiredList.length; i++) {
//            element = driver.findElement(By.name("requiredList[" + i + "]"));
//            element.sendKeys(requiredList[i]);
//
//        }
//
//        String optionalList[] = {"", "", "", "", "", "", "", "", "", ""};
//        for (int i = 0; i < optionalList.length; i++) {
//            element = driver.findElement(By.name("optionalList[" + i + "]"));
//            element.sendKeys(optionalList[i]);
//        }
//
//        element.submit();
//    }
//    
//    @When("^the reference is selected and remove button clicked$")
//    public void the_reference_is_selected_and_remove_button_clicked() throws Throwable {
//    }
//
////THEN
//    @Then("^a list of references is showed$")
//    public void a_list_of_references_is_showed() throws Throwable {
//        pageHasContent("Cynthia Andres");
//    }
//
//    @Then("^a prompt is showed$")
//    public void a_prompt_is_showed() throws Throwable {
//        pageHasContent("required");
//    }
//    
//    @Then("^the reference is removed$")
//    public void the_reference_is_removed() throws Throwable {
//        pageHasContent("");
//    }
//
////HELPER METHODS
//    private void pageHasContent(String content) {
//        assertTrue(driver.getPageSource().contains(content));
//    }
//
//    private void pageHasText(String text) {
//        //     assertTrue(driver.findElement(By.xpath("//select[@id='category']/option[@id='cat2']")));
//    }
//
//}
//
////    @Then("^entry is added$")
////    public void entry_is_added() throws Throwable {
////        List<Entry> entries = entryService.findall();
////        assertTrue(!entries.isEmpty());
////    }
//        //Select dropdown = new Select(driver.findElement(By.cssSelector("book")));
//
//    
//
//    
//
//    