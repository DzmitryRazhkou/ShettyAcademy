package com.mystore.qa.pages.childpagesOfMyStorePage;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TShirtsPage {


    private final WebDriver driver;
    private final WebDriverWait wait;

    public TShirtsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    private WebElement t_shirtBreadcrumb() {
        By dressesBreadcrumbLocator = By.xpath("//*[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesBreadcrumbLocator));
        return driver.findElement(dressesBreadcrumbLocator);
    }

    public boolean getT_shirtBreadcrumb() {
        try {
            System.out.println(" ===> Header dresses breadcrumb is displayed. <=== ");
            System.out.println(t_shirtBreadcrumb().getText());
            return t_shirtBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

}
