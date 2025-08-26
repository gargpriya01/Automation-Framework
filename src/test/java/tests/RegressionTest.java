package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionTest extends BaseTest {
    @Test
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
}}
