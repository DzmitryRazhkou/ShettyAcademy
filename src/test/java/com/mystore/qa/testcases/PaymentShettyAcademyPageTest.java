package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.pages.MyCartShettyAcademyPage;
import com.mystore.qa.pages.PaymentShettyAcademyPage;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PaymentShettyAcademyPageTest extends BaseTest {

    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;
    MyCartShettyAcademyPage myCartShettyAcademyPage;
    PaymentShettyAcademyPage paymentShettyAcademyPage;

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
        Assert.assertTrue(paymentShettyAcademyPage.validateConfirmationOrder());
    }
}


