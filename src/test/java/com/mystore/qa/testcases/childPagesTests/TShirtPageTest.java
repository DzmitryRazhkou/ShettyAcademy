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
}
