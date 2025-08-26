package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @DataProvider(name="loginData")
public Object[][] getLoginData(){

        ExcelUtils excel = new ExcelUtils("src/test/resources/testdata.xlsx", "Sheet1");
        int rows = excel.getRowCount();
        Object[][] data=new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            data[i][0] = excel.getCellData(i, 0);
            data[i][1] = excel.getCellData(i, 1);
        }
return data;
}

@Test(dataProvider = "loginData")
    public void testLogin(String user,String pass){
    loginPage=new LoginPage(driver);
    homePage=loginPage.login(user, pass);
   Assert.assertTrue(homePage.isWelcomeDisplayed());
}
}
