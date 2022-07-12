package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.IdentityPage;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class IdentityPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
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
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        Assert.assertTrue(identityPage.getIdentityBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        String actIdentityPageTitle = identityPage.getIdentityPageTitle();
        String expIdentityPageTitle = prop.getProperty("myIdentityPageTitle");
        Assert.assertEquals(expIdentityPageTitle, actIdentityPageTitle);
    }

    @Test
    public void getPersonalInfoTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        List<String> actPersonalInfoList = identityPage.getPersonalInfo();

        List<String> expPersonalInfoList = new ArrayList<>(Arrays.asList(prop.getProperty("firstname"),
                prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("dob")));

        Assert.assertEquals(expPersonalInfoList, actPersonalInfoList);
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        myAccountPage = identityPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        identityPage = myAccountPage.clickOnIdentity();
        myStorePage = identityPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }

}
