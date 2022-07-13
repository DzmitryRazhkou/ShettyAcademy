package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductShettyAcademyPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductShettyAcademyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE HOME BUTTON:

    private WebElement getHomeButton() {
        By getHomeButtonLocator = By.cssSelector("button[routerlink='/dashboard/']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getHomeButtonLocator));
        return driver.findElement(getHomeButtonLocator);
    }

    public boolean homeButtonValidate() {
        try {
            System.out.println("=====> Home button is displayed. <=====");
            System.out.println("=====> Home button text is: " + getHomeButton().getText() + " <=====");
            return getHomeButton().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getProductPageTitle() {
        System.out.println(" =====> My product page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    VALIDATE AMOUNT OF PRODUCT:

    public int productAmount() {
        By productLocator = By.cssSelector("div.card");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        List<WebElement> list = driver.findElements(productLocator);
        int productAmount = list.size();
        System.out.println(" =====> Amount of products: " + list.size() + " <=====");
        return productAmount;
    }

    private WebElement searchField() {
        By searchFieldLocator = By.xpath("(//input[@name='search'])[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        return driver.findElement(searchFieldLocator);
    }

    public void doSearch(String searchProduct) {
        searchField().clear();
        searchField().sendKeys(searchProduct);
        searchField().sendKeys(Keys.RETURN);
    }

    public List<String> getListOfProduct(String productName) {
        By productLocator = By.cssSelector("div.card");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        List<WebElement> listProducts = driver.findElements(productLocator);
        List<String> listOfProductsText = new ArrayList<>();

        for (WebElement s : listProducts) {
            System.out.println(s.getText());
            listOfProductsText.add(s.getText());
            if (listOfProductsText.contains(productName)) {
            }
        }
        return listOfProductsText;
    }

    public boolean validateProduct(String productName) {
        List<String> list = getListOfProduct(productName);
        for (String set : list) {
            if (set.contains(productName)) {
                System.out.println(" =====> " + productName + " <===== ");
                return true;
            }
        }
        System.out.println("Provide another product");
        return false;
    }
}


