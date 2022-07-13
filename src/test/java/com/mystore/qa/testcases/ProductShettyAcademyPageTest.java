package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class ProductShettyAcademyPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;

    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;

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
    public void validateProductPageTitle() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        String actProductPageTitle = productShettyAcademyPage.getProductPageTitle();
        String expProductPageTitle = prop.getProperty("expProductPageTitle");
        Assert.assertEquals(expProductPageTitle, actProductPageTitle);
    }

    @Test
    public void AmountOfProductTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        int expAmountOfProduct = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfProduct"));
        int actAmountOfProduct = productShettyAcademyPage.productAmount();
        Assert.assertEquals(expAmountOfProduct, actAmountOfProduct);
    }

    @Test
    public void doSearchTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        Assert.assertTrue(productShettyAcademyPage.validateProduct(prop.getProperty("productName")));
    }

    @Test
    public void doAddToCartTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        productShettyAcademyPage.doAddToCart();
        Assert.assertTrue(productShettyAcademyPage.validateAddToCartGreenConfirmationMessage());
    }
}
