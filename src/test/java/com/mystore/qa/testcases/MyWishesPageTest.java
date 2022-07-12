package com.mystore.qa.testcases;

import com.github.javafaker.Faker;
import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.*;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.Old.MyWishesPage;
import com.mystore.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class MyWishesPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;
    Faker faker;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    MyWishesPage myWishesPage;

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
    public void validateMyWishesBreadcrumbTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        Assert.assertTrue(myWishesPage.getMyWishesBreadCrumb());
    }

    @Test
    public void validateIdentityTitlePage() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        String actMyWishesPageTitle = myWishesPage.getMyWishesPageTitle();
        String expMyWishesPageTitle = prop.getProperty("myWishesPageTitle");
        Assert.assertEquals(expMyWishesPageTitle, actMyWishesPageTitle);
    }

    @Test
    public void validateTopSellersCountTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();

        List<String> actTopSellersList = myWishesPage.getTopSellers();

        int actAmountOfTopSellers = actTopSellersList.size();
        System.out.println(" =====> The amount of top sellers: " + actAmountOfTopSellers + " products <=====. ");
        int expAmountOfTopSellers = Integer.parseInt(prop.getProperty("countOfTopSellers"));
        Assert.assertEquals(expAmountOfTopSellers, actAmountOfTopSellers);

        for (String s : actTopSellersList) {
            System.out.println(s);

            String result = prop.getProperty("product");
            Assert.assertTrue(myWishesPage.validateTopSellers(result));
        }
    }

    @Test
    public void createNewWishListTest(){
        faker = new Faker();

        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        String newWishListName = faker.app().name();
        String wishListID = myWishesPage.getId(newWishListName);
        Assert.assertTrue(myWishesPage.wishListExist(wishListID, newWishListName));
    }

    @Test
    public void deleteWishListTest(){
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myWishesPage.getAlert();
    }

    @Test
    public void doClickOnBackToYourAccountTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myAccountPage = myWishesPage.doClickBackToToYourAccount();
        String actMyAccountPageTitle = myAccountPage.getMyAccountPageTitle();
        String expMyAccountPageTitle = prop.getProperty("myAccountPageTitle");
        Assert.assertEquals(expMyAccountPageTitle, actMyAccountPageTitle);
    }

    @Test
    public void doClickOnHomeTest() {
        myStorePage = new RegisterShettyAcademyPage(driver);
        loginPage = myStorePage.clickSignIn();
        myAccountPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        myWishesPage = myAccountPage.clickOnMyWishes();
        myStorePage = myWishesPage.doClickHome();
        String actMyStorePageTitle = myStorePage.getMyStorePageTitle();
        String expMyStorePageTitle = prop.getProperty("myStorePageTitle");
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }
}
