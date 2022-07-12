package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.Old.OrderHistoryPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class OrderHistoryPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;

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
    public void validateOrderHistoryBreadcrumbTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        Assert.assertTrue(orderHistoryPage.getOrderHistoryBreadCrumb());
    }

    @Test
    public void validateOrderHistoryTitlePage() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String actOrderHistoryPageTitle = orderHistoryPage.getOrderHistoryPageTitle();
        String expOrderHistoryPageTitle = prop.getProperty("orderHistoryPageTitle");
        Assert.assertEquals(expOrderHistoryPageTitle, actOrderHistoryPageTitle);
    }

    @Test
    public void getOrderReferenceTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String orderReference = prop.getProperty("orderReference");
        Assert.assertTrue(orderHistoryPage.getOrderReference(orderReference));
    }

    @Test
    public void getDateTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String date = prop.getProperty("date");
        Assert.assertTrue(orderHistoryPage.getDate(date));
    }

    @Test
    public void getTotalPriceTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        String totalPrice = prop.getProperty("totalPrice");
        Assert.assertTrue(orderHistoryPage.getTotalPrice(totalPrice));
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        myAccountPage = orderHistoryPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        orderHistoryPage = myAccountPage.clickOnOrderHistory();
        myStorePage = orderHistoryPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}
