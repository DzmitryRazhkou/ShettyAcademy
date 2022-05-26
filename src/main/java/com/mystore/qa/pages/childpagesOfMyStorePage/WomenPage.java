package com.mystore.qa.pages.childpagesOfMyStorePage;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WomenPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    private WebElement womenBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getWomenBreadcrumb() {
        try {
            System.out.println(" ===> Header women breadcrumb is displayed. <=== ");
            System.out.println(womenBreadcrumb().getText());
            return womenBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    //    FILTERING:

    private WebElement getDressesCategoryCheckbox(){
        By dressCategoryCheckboxLocator = By.cssSelector("#uniform-layered_category_8");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressCategoryCheckboxLocator));
        return driver.findElement(dressCategoryCheckboxLocator);
    }

    private WebElement getSizeCheckbox(){
        By sizeCheckboxLocator = By.cssSelector("#uniform-layered_id_attribute_group_3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeCheckboxLocator));
        return driver.findElement(sizeCheckboxLocator);
    }

    private WebElement getColorCheckbox(){
        By colorCheckboxLocator = By.cssSelector("#ul_layered_id_attribute_group_3>li:nth-of-type(4)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorCheckboxLocator));
        return driver.findElement(colorCheckboxLocator);
    }

    public void getSortBy(){
//        #selectProductSort>option
    }

    private WebElement getViewList(){
        By viewListLocator = By.cssSelector(".icon-th-list");
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewListLocator));
        return driver.findElement(viewListLocator);
    }

//    METHOD:
    public void doSorting() throws InterruptedException {
        getDressesCategoryCheckbox().click();
        getSizeCheckbox().click();
        Thread.sleep(2000);
        getColorCheckbox().click();
        Thread.sleep(2000);
    }

//    Validate Text:

    public String validateFilteringText(){
        By validateTextLocator = By.cssSelector("span.cat-name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(validateTextLocator));
        String validateSortingText = driver.findElement(validateTextLocator).getText();
        return validateSortingText;
    }

    private String getShowingOut(){
        By showingOutLocator = By.xpath("(//*[@class='product-count'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(showingOutLocator));
        String showingOutResult = driver.findElement(showingOutLocator).getText();
        return showingOutResult;
    }



}
