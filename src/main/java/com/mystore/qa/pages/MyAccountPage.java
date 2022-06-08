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

    //    VALIDATE BREADCRUMB:

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

//    VALIDATE PAGE TITLE:

    public String getMyAccountPageTitle(){
        System.out.println(" =====> My account page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }

//    MY ACCOUNT:

//    1. Order History:

    private WebElement getOrderHistoryLink(){
        By orderHistoryLocator = By.cssSelector("[title^='Orders']");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public OrderHistoryPage clickOnOrderHistory(){
        getOrderHistoryLink().click();
        return new OrderHistoryPage(driver);
    }

//    My Credit Slips:

    private WebElement getMyCreditSlipsLink(){
        By myCreditSlipsLocator = By.cssSelector("[title^='Credit slips']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myCreditSlipsLocator));
        return driver.findElement(myCreditSlipsLocator);
    }

    public MyCreditSlipsPage clickOnMyCreditSlips(){
        getMyCreditSlipsLink().click();
        return new MyCreditSlipsPage(driver);
    }

//    My Addresses:

    private WebElement getMyAddressesLink(){
        By addressesLocator = By.cssSelector("[title^='Addresses']");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressesLocator));
        return driver.findElement(addressesLocator);
    }

    public MyAddressesPage clickOnMyAddresses(){
        getMyAddressesLink().click();
        return new MyAddressesPage(driver);
    }

//    Identity:

    private WebElement getIdentityLink(){
        By identityLocator = By.cssSelector("[title^='Information']");
        wait.until(ExpectedConditions.presenceOfElementLocated(identityLocator));
        return driver.findElement(identityLocator);
    }

    public IdentityPage clickOnIdentity(){
        getIdentityLink().click();
        return new IdentityPage(driver);
    }

//    My Wishes:

    private WebElement getMyWishesLink(){
        By myWishesLocator = By.cssSelector("[title^='My wishlists']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public MyWishesPage clickOnMyWishes(){
        getMyWishesLink().click();
        return new MyWishesPage(driver);
    }

//    Home:

    private WebElement getHome(){
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome(){
        getHome().click();
        return new MyStorePage(driver);
    }





}
