package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By successMessage= By.xpath("//h1[text()='Logged In Successfully']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeDisplayed(){
        try{
            return driver.findElement(successMessage).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }
}
