package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features="src/main/java/Features", glue="", monochrome = true, publish = true,
     plugin = {"pretty","json:target/JSONReport/report.json", "junit:target/report.xml"})
    public class TestRunner {
    }


