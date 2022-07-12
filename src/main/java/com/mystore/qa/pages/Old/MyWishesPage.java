package com.mystore.qa.pages.Old;

import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
                    System.out.println("The existing wish list contains: " + existResult);
                    return true;
                }
            }
        }
        return false;
    }


//    CREATE NEW WISH LIST:

    private WebElement getWishlistField() {
        By getWishlistFieldLocator = By.id("name");
        wait.until(ExpectedConditions.presenceOfElementLocated(getWishlistFieldLocator));
        return driver.findElement(getWishlistFieldLocator);
    }

    private WebElement getSubmitWishlistBtn() {
        By getSubmitWishlistLocator = By.id("submitWishlist");
        wait.until(ExpectedConditions.presenceOfElementLocated(getSubmitWishlistLocator));
        return driver.findElement(getSubmitWishlistLocator);
    }


    private WebElement createNewWishList(String wishListName) {
        getWishlistField().sendKeys(wishListName);
        getSubmitWishlistBtn().click();

        By wishListLocator = By.xpath("//tr");
        List<WebElement> listOfWishlist = driver.findElements(wishListLocator);
        for (WebElement wishList : listOfWishlist) {
            if (wishList.getText().contains(wishListName)) {
                WebElement selectedWishList = wishList;
                return selectedWishList;
            }
        }
        return null;
    }

    public String getId(String wishListName) {
        String wishListId = createNewWishList(wishListName).getAttribute("id").split("_")[1];
        System.out.println("The name of wish list is: " + wishListName);
        System.out.println("The wish list ID is: " + wishListId);
        return wishListId;
    }

    public boolean wishListExist(String wishListId, String wishListName) {
        By wishListLocator = By.xpath("(//*[@id='wishlist_" + wishListId + "']/td/a)[1]");
        try {
            WebElement wishList = driver.findElement(wishListLocator);
            return wishList.getText().equalsIgnoreCase(wishListName) && wishList.isDisplayed();
        } catch (NoSuchElementException error) {
            return false;
        }
    }


//    DELETE WISH LIST:

    private WebElement getDeleteBtn() {
        By deleteBtnLocator = By.xpath("(//*[@class='icon'])[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtnLocator));
        return driver.findElement(deleteBtnLocator);
    }

    public void getAlert() {
        By wishListLocator = By.xpath("//tr");
        List<WebElement> listOfWishlist = driver.findElements(wishListLocator);

        if (listOfWishlist.size() > 0) {
            getDeleteBtn().click();
            Alert okDelete = driver.switchTo().alert();
            String textAlert = okDelete.getText();
            System.out.println("JS Pop up: " + textAlert);
            okDelete.accept();
            System.out.println("Wish list has been deleted");

        } else
            System.out.println("The list of wish list is empty!!!");
    }


//    Back to your account:

    private WebElement getBackToYourAccount() {
        By getBackToYourAccountLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[6]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public MyAccountPage doClickBackToToYourAccount() {
        getBackToYourAccount().click();
        return new MyAccountPage(driver);
    }

//    Home:

    private WebElement getHome() {
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[7]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public RegisterShettyAcademyPage doClickHome() {
        getHome().click();
        return new RegisterShettyAcademyPage(driver);
    }

//    CLICK ON OUR STORES:

    private WebElement getOurStores(){
        By getOurStoresLocator = By.xpath("(//*[@title='Our stores'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getOurStoresLocator));
        return driver.findElement(getOurStoresLocator);
    }

    public StoresPage doClickOurStores() {
        getOurStores().click();
        return new StoresPage(driver);
    }

}

