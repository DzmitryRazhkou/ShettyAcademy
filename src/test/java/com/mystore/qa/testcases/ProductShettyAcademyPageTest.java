package com.mystore.qa.testcases;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyCartShettyAcademyPage;
import com.mystore.qa.pages.PaymentShettyAcademyPage;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductShettyAcademyPageTest extends BaseTest{
    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;
    MyCartShettyAcademyPage myCartShettyAcademyPage;
    PaymentShettyAcademyPage paymentShettyAcademyPage;

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Log Out")
    @Story("Story Name: To Check Log Out")
    public void doLogOutTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        registerShettyAcademyPage = productShettyAcademyPage.doLogOut();
        Assert.assertTrue(registerShettyAcademyPage.validateGetLogOutGreenConfirmationMessage());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Product Page Title")
    @Story("Story Name: To Check Product Page Title")
    public void validateProductPageTitle() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        String actProductPageTitle = productShettyAcademyPage.getProductPageTitle();
        String expProductPageTitle = prop.getProperty("expProductPageTitle");
        Assert.assertEquals(expProductPageTitle, actProductPageTitle);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Amount Of Products")
    @Story("Story Name: To Check Amount Of Products")
    public void AmountOfProductTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        int expAmountOfProduct = Integer.parseInt(ConfigReader.initProp().getProperty("amountOfProduct"));
        int actAmountOfProduct = productShettyAcademyPage.productAmount();
        Assert.assertEquals(expAmountOfProduct, actAmountOfProduct);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Do Search Product")
    @Story("Story Name: To Check Do Search Product")
    public void doSearchTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        Assert.assertTrue(productShettyAcademyPage.validateProduct(prop.getProperty("productName")));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Do Add To Cart Product")
    @Story("Story Name: To Check Do Add To Cart Product")
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

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Click On Cart Button")
    @Story("Story Name: To Check Click On Cart Button")
    public void doClickOnCartBtnTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        productShettyAcademyPage.doAddToCart();
        myCartShettyAcademyPage = productShettyAcademyPage.doClickOnCart();
        Assert.assertTrue(myCartShettyAcademyPage.validateMyCartHeader());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Proceed To Check Out")
    @Story("Story Name: To Check Proceed To Check Out")
    public void doProceedToCheckOutTest() throws InterruptedException {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        productShettyAcademyPage.doSearch(prop.getProperty("product"));
        Thread.sleep(1500);
        productShettyAcademyPage.doAddToCart();
        myCartShettyAcademyPage = productShettyAcademyPage.doClickOnCart();
        paymentShettyAcademyPage = myCartShettyAcademyPage.proceedToCheckOut(prop.getProperty("productName"));
        Assert.assertTrue(paymentShettyAcademyPage.validatePaymentHeader());
    }
}
