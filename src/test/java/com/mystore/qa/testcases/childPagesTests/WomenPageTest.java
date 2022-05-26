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

public class WomenPageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    MyStorePage myStorePage;
    WomenPage womenPage;
    ContactUsPage contactUsPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startUp() {
        driver = WebDriverManager.safaridriver().create();
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
        Assert.assertTrue(womenPage.getWomenBreadcrumb());
    }

    @Test
    public void doSortingTest() throws InterruptedException {
        womenPage = new WomenPage(driver);
        myStorePage = new MyStorePage(driver);

        womenPage = myStorePage.clickOnWomen();
        womenPage.doSorting();

        String actSortingResult = womenPage.validateFilteringText();
        String expSortingResult = "Women > Categories Dresses > Size L";
        Assert.assertNotEquals(actSortingResult, expSortingResult);
    }





}
