package com.mystore.qa.pages.Old;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getSearch() {
        By orderHistoryLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public boolean getSearchBreadCrumb() {
        try {
            System.out.println(" ===> Search breadcrumb is displayed. <=== ");
            System.out.println(getSearch().getText());
            return getSearch().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getSearchPageTitle() {
        System.out.println(" =====> Search page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    PRODUCT COUNT:

    public boolean getProductCount() {
        By productCountLocator = By.xpath("(//div[@class='product-count'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCountLocator));
        try {
            WebElement productCount = driver.findElement(productCountLocator);
            System.out.println("Text is: " + productCount.getText());
            return productCount.isDisplayed();
        } catch (TimeoutException y) {
            System.out.println("Provide an another locator");
        }
        return false;
    }

    public boolean getProduct(String productName) {
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        List<WebElement> productList = driver.findElements(getProductLocator);
        for (WebElement s : productList) {
            if (s.getText().trim().contains(productName) && s.isDisplayed()) {
                System.out.println("Product list contains: " +s.getText().trim());
                return true;
            }
        }
        return false;
    }

//    MORE BUTTON:

    private WebElement getProduct(){
        By getProductLocator = By.cssSelector("div.product-container");
        wait.until(ExpectedConditions.presenceOfElementLocated(getProductLocator));
        return driver.findElement(getProductLocator);
    }

    public FadedShortSleeveTShirtsPage_Deprecated clickOnMore(){
        getProduct().click();
        return new FadedShortSleeveTShirtsPage_Deprecated(driver);
    }

    /**
     * This element should be placed on the faded short sleeve shirts page
     * @return
     */

//    ADD TO CART (FROM FADED SHORT SLEEVE SHIRT):

    private WebElement getQuantity() {
        By quantityLocator = By.cssSelector("input#quantity_wanted");
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityLocator));
        return driver.findElement(quantityLocator);
    }

    private WebElement getPlusBtn() {
        By plusLocator = By.cssSelector("i.icon-plus");
        wait.until(ExpectedConditions.presenceOfElementLocated(plusLocator));
        return driver.findElement(plusLocator);
    }

    private WebElement getMinusBtn() {
        By minusLocator = By.cssSelector("i.icon-minus");
        wait.until(ExpectedConditions.presenceOfElementLocated(minusLocator));
        return driver.findElement(minusLocator);
    }

    private void getSize(String index) {
        By sizeLocator = By.cssSelector("select#group_1");
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeLocator));
        WebElement size = driver.findElement(sizeLocator);

        Select sel = new Select(size);
        sel.selectByIndex(Integer.parseInt(index));
    }

    private WebElement getColor() {
        By colorLocator = By.cssSelector("ul#color_to_pick_list>li:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(colorLocator));
        return driver.findElement(colorLocator);
    }

    public void getAddToCartBtn() {
        By addToCartBtnLocator = By.cssSelector("p#add_to_cart");
        WebElement addToCart = driver.findElement(addToCartBtnLocator);
        Actions act = new Actions(driver);
        act.moveToElement(addToCart).click().build().perform();

        By cartLayerLocator = By.cssSelector("div#layer_cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartLayerLocator));
    }

    public boolean getSuccessMessageSearchPage() {
        By successMessageLocator = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        WebElement successMessage = driver.findElement(successMessageLocator);
        System.out.println("Success message: " + successMessage.getText());
        return successMessage.isDisplayed();
    }

    public void doAddToCart(String quantity, String index) {
        getQuantity().clear();
        getQuantity().sendKeys(quantity);
        getPlusBtn().click();
        getMinusBtn().click();
        getSize(index);
        getColor().click();
        getAddToCartBtn();
    }
}
