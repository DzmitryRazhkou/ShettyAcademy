package com.mystore.qa.testcases;
import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyCartShettyAcademyPage;
import com.mystore.qa.pages.PaymentShettyAcademyPage;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductShettyAcademyPageTest extends BaseTest{
    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;
    MyCartShettyAcademyPage myCartShettyAcademyPage;
    PaymentShettyAcademyPage paymentShettyAcademyPage;

    @Test
    public void doLogOutTest() {
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        registerShettyAcademyPage = new RegisterShettyAcademyPage(driver);
        productShettyAcademyPage = registerShettyAcademyPage.doLogin(email, password);
        registerShettyAcademyPage = productShettyAcademyPage.doLogOut();
        Assert.assertTrue(registerShettyAcademyPage.validateGetLogOutGreenConfirmationMessage());
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

    @Test
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

    @Test
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
