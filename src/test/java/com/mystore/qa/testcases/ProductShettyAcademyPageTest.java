package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.Old.LoginCreateAccountPage;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class ProductShettyAcademyPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginCreateAccountPage loginCreateAccountPage;

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
    public void validateMyLoginPageTitle(){
        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        String actMyLoginPageTitle = loginPage.getMyLoginPageTitle();
        String expMyLoginPageTitle = prop.getProperty("myLoginPageTitle");
        Assert.assertEquals(expMyLoginPageTitle, actMyLoginPageTitle);
    }

//    @Test
//    public void doClickSignInTest(){
//        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
//        Assert.assertTrue(loginPage.getAuthenticationBreadCrumb());
//    }
//
//    @Test
//    public void validateForgotPasswordLinkTest(){
//        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
//        Assert.assertTrue(loginPage.validateForgotPasswordLink());
//    }



//    @Test
//    public void doLoginIncorrectCredentialsTest(){
//        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
//        loginPage.doLogin(prop.getProperty("wrong_email"), prop.getProperty("wrong_password"));
//        Assert.assertTrue(loginPage.getErrorForm());
//    }




}
