package com.mystore.qa.testcases.childPagesTests;

import com.mystore.qa.pages.MyStorePage;
import com.mystore.qa.pages.childpagesOfMyStorePage.DressesPage;
import com.mystore.qa.pages.childpagesOfMyStorePage.TShirtsPage;
import com.mystore.qa.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TShirtPageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    MyStorePage myStorePage;
    TShirtsPage tShirtsPage;

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
    public void validateTShirtsBreadcrumbTest() {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        Assert.assertTrue(tShirtsPage.getT_shirtBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.doSorting();

        String actSortingResult = tShirtsPage.validateFilteringText();
        String expSortingResult = "T-SHIRTS > SIZE L > COLOR ORANGE";

        String actList = tShirtsPage.extractResultString().trim();
        String expList = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actSortingResult, expSortingResult);
        Assert.assertEquals(actList, expList);
    }

    @Test
    public void moveSlidersTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.moveSlider();

        String actResult = tShirtsPage.extractResultString();
        String expResult = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actResult, expResult);

        String actOutOf = tShirtsPage.getShowingOut();
        String expOutOf = "Showing 1 - 1 of 1 item";
        Assert.assertEquals(actOutOf, expOutOf);
    }

    @Test
    public void doSelectSortTest() throws InterruptedException {
        tShirtsPage = new TShirtsPage(driver);
        myStorePage = new MyStorePage(driver);

        tShirtsPage = myStorePage.clickOnTShirts();
        tShirtsPage.selectSort();

        String actResult = tShirtsPage.extractSortString();
        String expResult = "Faded Short Sleeve T-shirts $16.51 In stock";
        Assert.assertEquals(actResult, expResult);
    }
}
