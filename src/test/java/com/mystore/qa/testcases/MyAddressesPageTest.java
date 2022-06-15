package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MyAddressesPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyAddressesPage myAddressesPage;

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
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }

    @Test
    public void validateMyAddressesTitlePage() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        String actMyAddressesPageTitle = myAddressesPage.getMyAddressesPageTitle();
        String expMyAddressesPageTitle = prop.getProperty("myAddressesPageTitle");
        Assert.assertEquals(expMyAddressesPageTitle, actMyAddressesPageTitle);
    }

    @Test
    public void validateExistingDataTest() {
        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myAddressesPage = myAccountPage.clickOnMyAddresses();
        List<String> actualExistingDataList = myAddressesPage.getExistingData();
        System.out.println(" =====> Actual existing my address list: " +"\n" +actualExistingDataList+ "\n <===== ");

        List<String> expExistingDataList = new ArrayList<>(Arrays.asList(prop.getProperty("myAddress"), prop.getProperty("name"),
                prop.getProperty("nick"), prop.getProperty("address_Fl"), prop.getProperty("address_Sl"), prop.getProperty("existingState"),
                prop.getProperty("existPhone"), prop.getProperty("existPhone"), prop.getProperty("updateDelete")));

        System.out.println(" =====> Expected existing my address list: " +"\n" +expExistingDataList+ "\n <===== ");

                Assert.assertEquals(expExistingDataList, actualExistingDataList);
        }

    }

