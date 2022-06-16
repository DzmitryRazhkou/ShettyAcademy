package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyWishesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyWishesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getMyWishes() {
        By myWishesLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public boolean getMyWishesBreadCrumb() {
        try {
            System.out.println(" ===> My wishes breadcrumb is displayed. <=== ");
            System.out.println(getMyWishes().getText());
            return getMyWishes().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyWishesPageTitle() {
        System.out.println(" =====> My wishes page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    public List<String> getTopSellers() {
        By topSellersLocator = By.cssSelector("#best-sellers_block_right>div>ul>li");
        wait.until(ExpectedConditions.presenceOfElementLocated(topSellersLocator));

        List<WebElement> topSellersList = driver.findElements(topSellersLocator);
        List<String> topSellersListText = new ArrayList<>();

        for (WebElement topSellersRows : topSellersList) {
            if (topSellersRows.isDisplayed()) {
                topSellersListText.add(topSellersRows.getText().replaceAll("\\s+", " "));
            } else {
                return null;
            }
        }
        return topSellersListText;
    }

    public boolean validateTopSellers(String result) {
        By topSellersLocator = By.cssSelector("#best-sellers_block_right>div>ul>li");
        wait.until(ExpectedConditions.presenceOfElementLocated(topSellersLocator));

        List<WebElement> topSellersList = driver.findElements(topSellersLocator);
        List<String> topSellersListText = new ArrayList<>();

        for (WebElement topSellersRows : topSellersList) {
            if (topSellersRows.isDisplayed()) {
                topSellersListText.add(topSellersRows.getText().replaceAll("\\s+", " "));
                if (topSellersListText.contains(result)) {
                    return true;
                }
            }
        }
        return false;
    }

//    WISH LISTS:

    public boolean validateExistingWishList(String existResult) {
        By existingWishListLocator = By.cssSelector("#wishlist_45435>td");
        wait.until(ExpectedConditions.presenceOfElementLocated(existingWishListLocator));

        List<WebElement> existingWishList = driver.findElements(existingWishListLocator);
        List<String> existingWishText = new ArrayList<>();

        for (WebElement row : existingWishList) {
            if (row.isDisplayed()) {
                existingWishText.add(row.getText().trim());
                if (existingWishText.contains(existResult)) {
                    System.out.println("The existing wish list contains: " +existResult);
                    return true;
                }
            }
        }
        return false;
    }


//    CREATE NEW WISH LIST:

    private WebElement getWishlistField(){
        By getWishlistFieldLocator = By.id("name");
        wait.until(ExpectedConditions.presenceOfElementLocated(getWishlistFieldLocator));
        return driver.findElement(getWishlistFieldLocator);
    }

    private WebElement getSubmitWishlistBtn(){
        By getSubmitWishlistLocator = By.id("submitWishlist");
        wait.until(ExpectedConditions.presenceOfElementLocated(getSubmitWishlistLocator));
        return driver.findElement(getSubmitWishlistLocator);
    }








//    DELETE WISH LIST:

    private WebElement getDeleteBtn() {
        By deleteBtnLocator = By.xpath("(//*[@title='Delete'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtnLocator));
        return driver.findElement(deleteBtnLocator);
    }

    public void getAlert() {
        getDeleteBtn().click();
        Alert okDelete = driver.switchTo().alert();
        String textAlert = okDelete.getText();
        System.out.println("JS Pop up: " + textAlert);
        okDelete.accept();
    }

//    Back to your account:

    private WebElement getBackToYourAccount() {
        By getBackToYourAccountLocator = By.xpath("//*[contains(text(),' Back to your account')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public MyAccountPage doClickBackToToYourAccount() {
        getBackToYourAccount().click();
        return new MyAccountPage(driver);
    }

//    Home:

    private WebElement getHome() {
        By getHomeLocator = By.xpath("//*[contains(text(),' Home')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome() {
        getHome().click();
        return new MyStorePage(driver);
    }

}

