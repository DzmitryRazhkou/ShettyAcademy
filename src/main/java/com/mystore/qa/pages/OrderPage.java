package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getYourShoppingCart() {
        By yourShoppingCartLocator = By.xpath("//div[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourShoppingCartLocator));
        return driver.findElement(yourShoppingCartLocator);
    }

    public boolean getYourShoppingCartBreadCrumb() {
        try {
            System.out.println(" ===> Your shopping cart breadcrumb is displayed. <=== ");
            System.out.println(getYourShoppingCart().getText());
            return getYourShoppingCart().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getOrderPageTitle() {
        System.out.println(" =====> Order page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

}
