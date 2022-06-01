package com.mystore.qa.testcases.childPagesTests;

import com.mystore.qa.pages.ContactUsPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.WomenPage;
import com.mystore.qa.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

public class WomenPageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    MyStorePage myStorePage;
    WomenPage womenPage;
    ContactUsPage contactUsPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get(ConfigReader.initProp().getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validateWomenBreadcrumbTest() {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        Assert.assertTrue(womenPage.getWomenBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.doSorting();

        String actSortingResult = womenPage.validateFilteringText().toUpperCase(Locale.ROOT);
        String expSortingResult = "WOMEN > CATEGORIES DRESSES > SIZE L > COLOR ORANGE";

        String actList = womenPage.extractResultString();
        String expList = "Printed Dress $26.00 In stock";
        Assert.assertEquals(actSortingResult, expSortingResult);
        Assert.assertEquals(actList, expList);
    }

    @Test
    public void moveSlidersTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.moveSlider();

        String actResult = womenPage.extractResultString();
        String expResult = "Printed Dress $26.00 In stock";
        Assert.assertEquals(actResult, expResult);

        String actOutOf = womenPage.getShowingOut();
        String expOutOf = "Showing 1 - 1 of 1 items";
        Assert.assertEquals(actOutOf, expOutOf);
    }

    @Test
    public void doSelectSortTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.selectSort();

        String actResult = womenPage.extractSortString();
        String expResult = "Printed Chiffon Dress $16.40 $20.50 -20% In stock";
        Assert.assertEquals(actResult, expResult);
    }
}
