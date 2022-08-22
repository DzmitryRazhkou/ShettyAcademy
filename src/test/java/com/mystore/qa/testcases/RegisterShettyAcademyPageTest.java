package com.mystore.qa.testcases;
import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterShettyAcademyPageTest extends BaseTest {
    Faker faker;
    RegisterShettyAcademyPage registerPage;
    ProductShettyAcademyPage productShettyAcademyPage;

    @Test(priority = 6)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Verify Login Form")
    @Story("Story Name: To Check Login Form")
    public void validateLogInFormTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        Assert.assertTrue(registerPage.getLogInForm());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Register Page Title")
    @Story("Story Name: To Check Register Page Title")
    public void validateRegisterPageTitle() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String actRegisterPageTitle = registerPage.getMyStorePageTitle();
        String expRegisterPageTitle = prop.getProperty("expRegisterPageTitle");
        Assert.assertEquals(expRegisterPageTitle, actRegisterPageTitle);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Verify Amount Of Social Media Links")
    @Story("Story Name: To Check Amount Of Social Media Links")
    public void validateAmountOfSocialMediaLinksTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        int expAmountOfSocialMediaLinks = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfSocialMedia"));
        int actAmountOfSocialMediaLinks = registerPage.socialMedia();
        Assert.assertEquals(expAmountOfSocialMediaLinks, actAmountOfSocialMediaLinks);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Case Description: Verify Shetty Academy Email")
    @Story("Story Name: To Check Shetty Academy Email")
    public void validateShettyAcademyEmailTest() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String expShettyAcademyEmailText = registerPage.shettyAcademyEmail();
        String actShettyAcademyEmailText = prop.getProperty("shettyAcademyEmail");
        Assert.assertEquals(expShettyAcademyEmailText, actShettyAcademyEmailText);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Login With Correct Credentials")
    @Story("Story Name: To Check Login With Correct Credentials")
    public void doLoginTestCorrectCredentials() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        productShettyAcademyPage = registerPage.doLogin(email, password);
        Assert.assertTrue(productShettyAcademyPage.validateGetLogInGreenConfirmationMessage());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Login With Incorrect Credentials")
    @Story("Story Name: To Check Login With Incorrect Credentials")
    public void doLoginTestIncorrectCredentials() {
        registerPage = new RegisterShettyAcademyPage(driver);
        String email = prop.getProperty("wrong_email");
        String password = prop.getProperty("wrong_password");
        productShettyAcademyPage = registerPage.doLogin(email, password);
        Assert.assertTrue(registerPage.validateIncorrectCredentialsRedConfirmation());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Registration New User")
    @Story("Story Name: To Check Registration New User")
    public void doRegistration() {
        faker = new Faker();
        registerPage = new RegisterShettyAcademyPage(driver);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.numerify("1#########");
        String occupation = prop.getProperty("occupation");
        String password = registerPage.generatePassword();

        registerPage.doRegistration(firstName, lastName, email, phone, occupation, password);
        Assert.assertTrue(registerPage.validateSuccessRegistration());
    }
}


