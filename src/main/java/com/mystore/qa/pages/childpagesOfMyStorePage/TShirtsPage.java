package com.mystore.qa.pages.childpagesOfMyStorePage;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    //    FILTERING:

    private WebElement getSizeCheckbox() {
        By sizeCheckboxLocator = By.cssSelector("#uniform-layered_id_attribute_group_3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeCheckboxLocator));
        return driver.findElement(sizeCheckboxLocator);
    }

    private WebElement getColorCheckbox() {
        By colorCheckboxLocator = By.cssSelector("#layered_id_attribute_group_13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorCheckboxLocator));
        System.out.println("Color has been selected");
        return driver.findElement(colorCheckboxLocator);
    }

    private WebElement getCompositionsCheckbox() {
        By compositionsCheckboxLocator = By.cssSelector("#layered_id_feature_5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(compositionsCheckboxLocator));
        return driver.findElement(compositionsCheckboxLocator);
    }

    //    METHOD:

    public void doSorting() throws InterruptedException {
        getSizeCheckbox().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#layered_id_attribute_group_13")));
        getColorCheckbox().click();
        Thread.sleep(5000);
    }

    public String validateFilteringText() {
        By validateTextLocator = By.cssSelector("span.cat-name");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cat-name")));
        String validateSortingText = driver.findElement(validateTextLocator).getText();
        System.out.println(validateSortingText);
        return validateSortingText;
    }

    public String extractResultString() {
        List<WebElement> list = driver.findElements(By.cssSelector("div.product-container"));
        for (int i = 0; i < list.size(); i++) {
            String extTemp = list.get(i).getText().replaceAll("\n", " ");
            System.out.println("Initial: " + extTemp);
            return extTemp;
        }
        return null;
    }

}
