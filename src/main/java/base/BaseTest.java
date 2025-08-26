package base;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        String browser=ConfigReader.get("browser");
        driver= DriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait", 10)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getInt("page.load.timeout", 30)));
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
       DriverFactory.quitDriver();
    }
}
