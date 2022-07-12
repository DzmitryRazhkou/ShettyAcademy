package com.mystore.qa.pages;


import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterShettyAcademyPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterShettyAcademyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    LOG IN FORM:

    private WebElement logInForm() {
        By logInFormLocator = By.cssSelector("div.login-section-wrapper");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInFormLocator));
        return driver.findElement(logInFormLocator);
    }

    public boolean getLogInForm() {
        try {
            System.out.println(" ===> Log in form is displayed. <=== ");
            return logInForm().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyStorePageTitle() {
        System.out.println(" =====> Register page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    SOCIAL MEDIA LINKS:

    public int socialMedia() {
        By socialMediaLocator = By.cssSelector("span:nth-of-type(2) a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(socialMediaLocator));

        List<WebElement> list = driver.findElements(socialMediaLocator);
        int amountOfSocialMediaLinks = list.size();
        System.out.println("Amount of social media links are: " + list.size());
        return amountOfSocialMediaLinks;
    }

//    SHETTY ACADEMY EMAIL:

    public String shettyAcademyEmail() {
        By academyEmailLocator = By.cssSelector("span:nth-of-type(1) a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(academyEmailLocator));
        String academyEmailText = driver.findElement(academyEmailLocator).getText();
        System.out.println(" =====> Shetty academy email is: " + academyEmailText + " <===== ");
        return academyEmailText;
    }

    private WebElement emailField() {
        By emailFieldLocator = By.id("userEmail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        return driver.findElement(emailFieldLocator);
    }

    private WebElement passwordField() {
        By passwordFieldLocator = By.id("userPassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        return driver.findElement(passwordFieldLocator);
    }

    private WebElement loginField() {
        By loginFieldLocator = By.id("login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFieldLocator));
        return driver.findElement(loginFieldLocator);
    }

    public ProductShettyAcademyPage doLogin(String email, String password) {
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginField().click();
        return new ProductShettyAcademyPage(driver);
    }
}

















