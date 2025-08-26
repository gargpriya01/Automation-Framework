package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Given("user is on login page")
    public void user_is_on_login_page(){
        loginPage=new LoginPage(driver);
    }

    @When("user_enters_username {string} and password {string}")
    public void user_enters_credentials(String user,String pass){
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        homePage=loginPage.clickLogin();
    }

    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {
        Assert.assertTrue(homePage.isWelcomeDisplayed(), "Welcome message not found!");
    }
}


