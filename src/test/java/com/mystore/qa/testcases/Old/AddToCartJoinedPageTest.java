package com.mystore.qa.testcases.Old;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.*;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class AddToCartJoinedPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;
    SearchPage searchPage;
    AddToCartJoinedPage addToCartJoinedPage;

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
    public void validateSearchBreadcrumbTest() {
        String productType = prop.getProperty("productType");

        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        Assert.assertTrue(searchPage.getSearchBreadCrumb());
    }

    @Test
    public void validateSearchTitlePage() {
        String productType = prop.getProperty("productType");

        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);

        String actSearchPageTitle = searchPage.getSearchPageTitle();
        String expSearchPageTitle = prop.getProperty("searchPageTitle");
        Assert.assertEquals(expSearchPageTitle, actSearchPageTitle);
    }

    @Test
    public void validateSearchProduct() {
        String productType = prop.getProperty("productType");
        String product = prop.getProperty("searchedProduct");

        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
        Assert.assertTrue(searchPage.getProductCount());
        Assert.assertTrue(searchPage.getProduct(product));
    }

    @Test
    public void doAddToCartSearchTest() {
        String productType = prop.getProperty("productType");
        String quantity = prop.getProperty("quantity");
        String size = prop.getProperty("size");

        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        searchPage = myAccountPage.doSearch(productType);
//        searchPage.clickOnMore();
        searchPage.doAddToCart(quantity, size);
        Assert.assertTrue(searchPage.getSuccessMessageSearchPage());
    }

}
