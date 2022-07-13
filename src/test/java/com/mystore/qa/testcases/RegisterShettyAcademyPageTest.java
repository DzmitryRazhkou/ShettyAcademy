package com.mystore.qa.testcases;


import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class RegisterShettyAcademyPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    Faker faker;

    RegisterShettyAcademyPage registerPage;
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
    public void validateLogInFormTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        Assert.assertTrue(registerPage.getLogInForm());
    }

    @Test
    public void validateRegisterPageTitle() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String actRegisterPageTitle = registerPage.getMyStorePageTitle();
        String expRegisterPageTitle = prop.getProperty("expRegisterPageTitle");
        Assert.assertEquals(expRegisterPageTitle, actRegisterPageTitle);
    }

    @Test
    public void validateAmountOfSocialMediaLinksTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        int expAmountOfSocialMediaLinks = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfSocialMedia"));
        int actAmountOfSocialMediaLinks = registerPage.socialMedia();
        Assert.assertEquals(expAmountOfSocialMediaLinks, actAmountOfSocialMediaLinks);
    }

    @Test
    public void validateShettyAcademyEmailTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String expShettyAcademyEmailText = registerPage.shettyAcademyEmail();
        String actShettyAcademyEmailText = prop.getProperty("shettyAcademyEmail");
        Assert.assertEquals(expShettyAcademyEmailText, actShettyAcademyEmailText);
    }

    @Test
    public void doLoginTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerPage.doLogin(email, password);
        String actProductPageTitle = productShettyAcademyPage.getProductPageTitle();
        String expProductPageTitle = prop.getProperty("expProductPageTitle");
        Assert.assertEquals(expProductPageTitle, actProductPageTitle);
    }

    @Test
    public void doRegistration() throws InterruptedException {
        faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.numerify("##########");
        String occupation = prop.getProperty("occupation");
        String password = prop.getProperty("pwd");

        registerPage = new RegisterShettyAcademyPage(driver);
        registerPage.doRegistration(firstName, lastName, email, phone, occupation, password);
        Assert.assertTrue(registerPage.validateSuccessRegistration());
    }

}


