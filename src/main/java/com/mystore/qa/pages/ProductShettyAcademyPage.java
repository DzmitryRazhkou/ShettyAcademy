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

    private WebElement getLogOutBtn() {
        By getLogOutBtnLocator = By.xpath("(//button[@class='btn btn-custom'])[4]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLogOutBtnLocator));
        return driver.findElement(getLogOutBtnLocator);
    }

//    VALIDATE LOGIN IN CONFIRMATION MESSAGE:

    private WebElement getLoginGreenConfirmationMessage() {
        By getLoginGreenConfirmationMessageLocator = By.cssSelector("div[aria-label='Login Successfully']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoginGreenConfirmationMessageLocator));
        return driver.findElement(getLoginGreenConfirmationMessageLocator);
    }

    public boolean validateGetLogInGreenConfirmationMessage() {
        try {
            System.out.println("=====> Confirmation message is: " + getLoginGreenConfirmationMessage().getText() + " <=====");
            return getLoginGreenConfirmationMessage().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    public RegisterShettyAcademyPage doLogOut(){
        getLogOutBtn().click();
        return new RegisterShettyAcademyPage(driver);
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

    public List<String> getListOfProduct() {
        By productLocator = By.cssSelector("div.card");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        List<WebElement> listProducts = driver.findElements(productLocator);
        List<String> listOfProductsText = new ArrayList<>();

        for (WebElement s : listProducts) {
            System.out.println(s.getText());
            listOfProductsText.add(s.getText());
        }
        return listOfProductsText;
    }

    public boolean validateProduct(String productName) {
        List<String> list = getListOfProduct();
        for (String set : list) {
            if (set.contains(productName)) {
                System.out.println(" =====> " + productName + " <===== ");
                return true;
            }
        }
        System.out.println("Provide another product");
        return false;
    }

//    CLICK AT THE VIEW PRODUCT:

    private WebElement getViewButton() {
        By getViewButtonLocator = By.cssSelector("div.card-body button:last-of-type");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getViewButtonLocator));
        return driver.findElement(getViewButtonLocator);
    }

    private WebElement getAddToCart() {
        By getViewButtonLocator = By.cssSelector("button[routerlink='/dashboard/cart']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getViewButtonLocator));
        return driver.findElement(getViewButtonLocator);
    }

    private WebElement getAddToCartGreenConfirmationMessage() {
        By addToCartGreenConfirmationMessageLocator = By.cssSelector("div[role='alertdialog']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartGreenConfirmationMessageLocator));
        return driver.findElement(addToCartGreenConfirmationMessageLocator);
    }

    public boolean validateAddToCartGreenConfirmationMessage() {
        try {
            System.out.println("=====> Confirmation message is: " + getAddToCartGreenConfirmationMessage().getText() + " <=====");
            return getAddToCartGreenConfirmationMessage().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    public void doAddToCart() {
        getViewButton().click();
        getAddToCart().click();
    }
}


