package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE:

    private WebElement getMyAccount() {
        By myAccountLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLocator));
        return driver.findElement(myAccountLocator);
    }

    public boolean getMyAccountBreadCrumb() {
        try {
            System.out.println(" ===> My account breadcrumb is displayed. <=== ");
            System.out.println(getMyAccount().getText());
            return getMyAccount().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    public String getMyAccountPageTitle(){
        System.out.println(" =====> My account page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    MY ACCOUNT:

    private WebElement getOrderHistoryLink(){
        By orderHistoryLocator = By.cssSelector("[title^='Orders']");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public OrderHistoryPage clickOnOrderHistory(){
        getOrderHistoryLink().click();
        return new OrderHistoryPage(driver);
    }

}
