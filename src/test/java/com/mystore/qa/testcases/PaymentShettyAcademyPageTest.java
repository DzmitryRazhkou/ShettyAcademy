package com.mystore.qa.testcases;

import com.mystore.qa.basetest.BaseTest;
import com.mystore.qa.listeners.RetryAnalyzer;
import com.mystore.qa.pages.MyCartShettyAcademyPage;
import com.mystore.qa.pages.PaymentShettyAcademyPage;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PaymentShettyAcademyPageTest extends BaseTest {

    RegisterShettyAcademyPage registerShettyAcademyPage;
    ProductShettyAcademyPage productShettyAcademyPage;
    MyCartShettyAcademyPage myCartShettyAcademyPage;
    PaymentShettyAcademyPage paymentShettyAcademyPage;

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Proceed To Check Out")
    @Story("Story Name: To Check Proceed To Check Out")
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


