package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue={"stepdefs"},features="src/test/resources/features",plugin={"pretty","html:target/cucumber-report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {


}
