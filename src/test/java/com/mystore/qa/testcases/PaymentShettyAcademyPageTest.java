package com.mystore.qa.testcases;


import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.MyCartShettyAcademyPage;
import com.mystore.qa.pages.PaymentShettyAcademyPage;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class PaymentShettyAcademyPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;

    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;
    MyCartShettyAcademyPage myCartShettyAcademyPage;
    PaymentShettyAcademyPage paymentShettyAcademyPage;


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
    public void doProceedToCheckOutTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        String firstLetter = prop.getProperty("firstLetter");
        String country = prop.getProperty("country");

        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        productShettyAcademyPage.doAddToCart();
        myCartShettyAcademyPage = productShettyAcademyPage.doClickOnCart();
        paymentShettyAcademyPage = myCartShettyAcademyPage.proceedToCheckOut(prop.getProperty("productName"));
        paymentShettyAcademyPage.doPlaceOrder(firstLetter, country);
    }

}


