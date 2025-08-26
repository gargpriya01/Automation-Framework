package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("submit");
    private By errorMsg = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage clickLogin() {
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }

    public HomePage login(String user,String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        return new HomePage(driver);
    }

    public String getErrorMessage() {
        try {
            WebElement e = driver.findElement(errorMsg);
            return e.getText();
        } catch (Exception ex) {
            return null;
        }
    }
}
