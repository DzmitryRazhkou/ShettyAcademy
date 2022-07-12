package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.Old.MyAddressesPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class MyAddressesPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAddressesPage myAddressesPage;
    Faker faker;

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
    public void validateMyAddressesMessageTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test
    public void validateMyAddressesTitlePage() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        String actMyAddressesPageTitle = myAddressesPage.getMyAddressesPageTitle();
        String expMyAddressesPageTitle = prop.getProperty("myAddressesPageTitle");
        Assert.assertEquals(expMyAddressesPageTitle, actMyAddressesPageTitle);
    }


    @Test
    public void doUpdateTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();

        faker = new Faker();
        String addressFl = faker.address().fullAddress();
        String addressSl = faker.address().secondaryAddress();
        String phone = faker.phoneNumber().cellPhone();
        String data = faker.beer().name();
        String alias = faker.name().title();

        myAddressesPage.doUpdate(addressFl, addressSl, phone, data, alias);
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test(priority = 1)
    public void doAddNewAddressTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();

        faker = new Faker();
        String addressFl = faker.address().fullAddress();
        String addressSl = faker.address().secondaryAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zip = faker.address().zipCode();
        String phone = faker.phoneNumber().cellPhone();
        String data = faker.beer().name();
        String alias = faker.name().title();

        myAddressesPage.doAddNewAddress(addressFl, addressSl, city, state, zip, phone, data, alias);
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test(priority = 2)
    public void doDelete() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myAddressesPage.getAlert();

        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myAccountPage = myAddressesPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        myStorePage = myAddressesPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}

