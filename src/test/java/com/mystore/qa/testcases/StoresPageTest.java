package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.Old.MyWishesPage;
import com.mystore.qa.pages.Old.StoresPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class StoresPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;
    Faker faker;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyWishesPage myWishesPage;
    StoresPage storesPage;

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
    public void validateMyWishesBreadcrumbTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        Assert.assertTrue(storesPage.getStoresBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        String actMyWishesPageTitle = storesPage.getStorePageTitle();
        String expMyWishesPageTitle = prop.getProperty("storesPageTitle");
        Assert.assertEquals(expMyWishesPageTitle, actMyWishesPageTitle);
    }

    @Test
    public void doGoogleClicksTest() throws InterruptedException {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        Assert.assertTrue(!storesPage.doGetStoreGoogleMaps(prop.getProperty("store")));
    }

    @Test
    public void doZoomInZoomOutTest() throws InterruptedException {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();
        storesPage.zoomInZoomOutTest();
    }

    @Test
    public void selectLocationStoreTest() throws InterruptedException {
        faker = new Faker();
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        storesPage = myWishesPage.doClickOurStores();

        String city = faker.address().city();
        String value = prop.getProperty("radius");
        storesPage.doSelectLocation(city, value);
        Assert.assertTrue(storesPage.fancyError());
    }

}
