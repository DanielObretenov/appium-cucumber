package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.DriverUtil;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\features",
        glue = "stepDefinitions",
        tags = ("@DragTests"),
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.xml"}
)
public class TestRunner {
    @BeforeClass
    public static void setUpClass(){
        DriverUtil.getDefaultWebDriver();
    }
}
