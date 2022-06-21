package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FadedShortSleeveTShirtsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FadedShortSleeveTShirtsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getFadedShortSleeveTShirt() {
        By fadedShortSleeveTShirtLocator = By.cssSelector("breadcrumb clearfix");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fadedShortSleeveTShirtLocator));
        return driver.findElement(fadedShortSleeveTShirtLocator);
    }

    public boolean getFadedShortSleeveTShirtBreadCrumb() {
        try {
            System.out.println(" ===> Faded short sleeve t-shirts breadcrumb is displayed. <=== ");
            System.out.println(getFadedShortSleeveTShirt().getText());
            return getFadedShortSleeveTShirt().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getFadedShortSleeveTShirtPageTitle() {
        System.out.println(" =====> Faded short sleeve t-shirts page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

}
