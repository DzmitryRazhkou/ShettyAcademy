package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    RETURN HOME:

    private WebElement getReturnHomeButton() {
        By returnHomeButtonLocator = By.cssSelector(".icon-home");
        wait.until(ExpectedConditions.visibilityOfElementLocated(returnHomeButtonLocator));
        return driver.findElement(returnHomeButtonLocator);
    }

//    AUTHENTICATION:

    private WebElement getAuthentication() {
        By authenticationLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(authenticationLocator));
        return driver.findElement(authenticationLocator);
    }

    public boolean getAuthenticationBreadCrumb() {
        try {
            System.out.println(" ===> Authentication breadcrumb is displayed. <=== ");
            return getAuthentication().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    ALREADY REGISTERED?

    private WebElement getEmail() {
        By emailLocator = By.cssSelector("#email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        return driver.findElement(emailLocator);
    }

    private WebElement getPassword() {
        By passwordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordLocator));
        return driver.findElement(passwordLocator);
    }

    private WebElement getSignIn() {
        By signInBtnLocator = By.cssSelector("#SubmitLogin");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInBtnLocator));
        return driver.findElement(signInBtnLocator);
    }

    public MyAccountPage doLogin(String email, String password){
        getEmail().clear();
        getEmail().sendKeys(email);
        getPassword().clear();
        getPassword().sendKeys(password);
        getSignIn().click();
        return new MyAccountPage(driver);
    }

//    CREATE AN ACCOUNT:

    private WebElement getEmailCreateAccount() {
        By emailCreateAccountLocator = By.cssSelector("#email_create");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailCreateAccountLocator));
        return driver.findElement(emailCreateAccountLocator);
    }

    private WebElement getCreateAccountBtn() {
        By signInBtnLocator = By.cssSelector("#SubmitCreate");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInBtnLocator));
        return driver.findElement(signInBtnLocator);
    }

    public LoginCreateAccountPage doCreateAccount(String emailCreateAccount){
        getEmailCreateAccount().clear();
        getEmailCreateAccount().sendKeys(emailCreateAccount);
        getCreateAccountBtn().click();
        return new LoginCreateAccountPage(driver);
    }




}

