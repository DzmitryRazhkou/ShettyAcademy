package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IdentityPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public IdentityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getIdentity() {
        By identityLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(identityLocator));
        return driver.findElement(identityLocator);
    }

    public boolean getIdentityBreadCrumb() {
        try {
            System.out.println(" ===> Identity breadcrumb is displayed. <=== ");
            System.out.println(getIdentity().getText());
            return getIdentity().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getIdentityPageTitle(){
        System.out.println(" =====> Identity page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

}
