package com.mystore.qa.pages.Old;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    RETURN HOME:

    private WebElement getReturnHomeButton(){
        By returnHomeButtonLocator = By.cssSelector(".home");
        wait.until(ExpectedConditions.visibilityOfElementLocated(returnHomeButtonLocator));
        return driver.findElement(returnHomeButtonLocator);
    }

//    CONTACT

    private WebElement getContact(){
        By contactLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactLocator));
        return driver.findElement(contactLocator);
    }

    public boolean getContactBreadCrumb() {
        try {
            System.out.println(" ===> Contact breadcrumb is displayed. <=== ");
            return getContact().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }
}
