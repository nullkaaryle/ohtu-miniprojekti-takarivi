package takarivi.bibtex;

import cucumber.api.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class RunCukesTest {

    @ClassRule
    public static ServerRule svr = new ServerRule(8080);
}
