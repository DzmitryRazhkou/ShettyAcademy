package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCreditSlipsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyCreditSlipsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getMyCreditSlips() {
        By myCreditSlipsLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myCreditSlipsLocator));
        return driver.findElement(myCreditSlipsLocator);
    }

    public boolean getMyCreditSlipsBreadCrumb() {
        try {
            System.out.println(" ===> My credit slips breadcrumb is displayed. <=== ");
            System.out.println(getMyCreditSlips().getText());
            return getMyCreditSlips().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyCreditSlipsPageTitle(){
        System.out.println(" =====> My credit slips page title is: " +driver.getTitle()+ " <===== ");
        return driver.getTitle();
    }


}
