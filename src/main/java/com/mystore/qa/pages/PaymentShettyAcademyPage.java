package com.mystore.qa.pages;

import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class PaymentShettyAcademyPage extends BasePage {

    public PaymentShettyAcademyPage(WebDriver driver) {
        super(driver);
    }

//    VALIDATE PAYMENT PAGE:

    private WebElement getPaymentHeader() {
        By getPaymentHeaderLocator = By.xpath("//*[contains(text(),'Payment Method')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPaymentHeaderLocator));
        return driver.findElement(getPaymentHeaderLocator);
    }

    public boolean validatePaymentHeader() {
        try {
            System.out.println("=====> Payment header text is: " + getPaymentHeader().getText() + " <=====");
            return getPaymentHeader().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    private WebElement getSelectCountry() {
        By getSelectCountryLocator = By.cssSelector("input[placeholder='Select Country']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getSelectCountryLocator));
        return driver.findElement(getSelectCountryLocator);
    }

    private void getCountryList(String country) {
        By countryListLocator = By.cssSelector("section[class='ta-results list-group ng-star-inserted'] button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryListLocator));

        List<WebElement> list = driver.findElements(countryListLocator);

        for (WebElement webElement : list) {
            if (webElement.getText().equals(country)) {
                webElement.click();
                break;
            }
        }
    }

    private WebElement getPlaceOrderBtn() {
        By getPlaceOrderBtnLocator = By.cssSelector("a[class='btnn action__submit ng-star-inserted']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPlaceOrderBtnLocator));
        return driver.findElement(getPlaceOrderBtnLocator);
    }

    private void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000)", "");
        System.out.println("Page has bee scrolled down");
    }

    public void doPlaceOrder(String firstLetter, String country){

        getSelectCountry().clear();
        getSelectCountry().sendKeys(firstLetter);
        scrollPage();
        getCountryList(country);
        getPlaceOrderBtn().click();
    }

//    CONFIRMATION ORDER MESSAGE:

    private WebElement getConfirmationOrder() {
        By getConfirmationOrderLocator = By.cssSelector("h1.hero-primary");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getConfirmationOrderLocator));
        return driver.findElement(getConfirmationOrderLocator);
    }

    public boolean validateConfirmationOrder() {
        try {
            System.out.println("=====> Confirmation order text is: " + getConfirmationOrder().getText() + " <=====");
            return getConfirmationOrder().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }
}
