package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class IdentityPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    IdentityPage identityPage;

    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = cp.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validateIdentityBreadcrumbTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        Assert.assertTrue(identityPage.getIdentityBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        String actIdentityPageTitle = identityPage.getIdentityPageTitle();
        String expIdentityPageTitle = prop.getProperty("myIdentityPageTitle");
        Assert.assertEquals(expIdentityPageTitle, actIdentityPageTitle);
    }

}