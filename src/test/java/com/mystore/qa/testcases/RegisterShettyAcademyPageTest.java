package com.mystore.qa.testcases;
import com.github.javafaker.Faker;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterShettyAcademyPageTest extends BaseTest {
    Faker faker;
    RegisterShettyAcademyPage registerPage;
    ProductShettyAcademyPage productShettyAcademyPage;

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
        Assert.assertTrue(productShettyAcademyPage.validateGetLogInGreenConfirmationMessage());
    }

    @Test
    public void doRegistration() {
        faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.numerify("1#########");
        String occupation = prop.getProperty("occupation");
        String password = prop.getProperty("pwd");

        registerPage = new RegisterShettyAcademyPage(driver);
        registerPage.doRegistration(firstName, lastName, email, phone, occupation, password);
        Assert.assertTrue(registerPage.validateSuccessRegistration());
    }
}


