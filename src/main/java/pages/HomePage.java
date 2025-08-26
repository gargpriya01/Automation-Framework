package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By successMessage= By.xpath("//h1[text()='Logged In Successfully']");

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeDisplayed(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return driver.findElement(successMessage).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
