package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FadedShortSleeveTShirtsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FadedShortSleeveTShirtsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getFadedShortSleeveTShirt() {
        By fadedShortSleeveTShirtLocator = By.xpath("//div[@class='breadcrumb clearfix']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fadedShortSleeveTShirtLocator));
        return driver.findElement(fadedShortSleeveTShirtLocator);
    }

    public boolean getFadedShortSleeveTShirtBreadCrumb() {
        try {
            System.out.println(" ===> Faded short sleeve t-shirts breadcrumb is displayed. <=== ");
            System.out.println(getFadedShortSleeveTShirt().getText());
            return getFadedShortSleeveTShirt().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getFadedShortSleeveTShirtPageTitle() {
        System.out.println(" =====> Faded short sleeve t-shirts page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    WRITE A REVIEW:

    private WebElement getWriteReview() {
        By writeReviewLocator = By.cssSelector("a[class='open-comment-form']");
        wait.until(ExpectedConditions.presenceOfElementLocated(writeReviewLocator));
        return driver.findElement(writeReviewLocator);
    }

    private WebElement getStarContent() {
        By starContentLocator = By.cssSelector("div.star_content>div:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(starContentLocator));
        return driver.findElement(starContentLocator);
    }

    private WebElement getTitle() {
        By titleLocator = By.cssSelector("input#comment_title");
        wait.until(ExpectedConditions.presenceOfElementLocated(titleLocator));
        return driver.findElement(titleLocator);
    }

    private WebElement getContent() {
        By contentLocator = By.cssSelector("#content");
        wait.until(ExpectedConditions.presenceOfElementLocated(contentLocator));
        return driver.findElement(contentLocator);
    }

    private WebElement getSendReviewBtn() {
        By sendReviewBtnLocator = By.cssSelector("button#submitNewMessage");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendReviewBtnLocator));
        return driver.findElement(sendReviewBtnLocator);
    }

    public boolean newReviewComment() {
        By newCommentLocator = By.cssSelector("div.fancybox-inner > p:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(newCommentLocator));
        try {
            WebElement newComment = driver.findElement(newCommentLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }

    public void doWriteReview(String title, String comment){
        getWriteReview().click();
        getStarContent().click();
        getTitle().clear();
        getTitle().sendKeys(title);
        getContent().clear();
        getContent().sendKeys(comment);
        getSendReviewBtn().click();
    }

//    SEND TO FRIEND:

    private WebElement getSendToFriendBtn() {
        By sendToFriendBtnLocator = By.cssSelector("a#send_friend_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendToFriendBtnLocator));
        return driver.findElement(sendToFriendBtnLocator);
    }

    private WebElement getFriendNameField() {
        By friendNameFieldLocator = By.cssSelector("input#friend_name");
        wait.until(ExpectedConditions.presenceOfElementLocated(friendNameFieldLocator));
        return driver.findElement(friendNameFieldLocator);
    }

    private WebElement getFriendEmailField() {
        By friendEmailFieldLocator = By.cssSelector("input#friend_email");
        wait.until(ExpectedConditions.presenceOfElementLocated(friendEmailFieldLocator));
        return driver.findElement(friendEmailFieldLocator);
    }

    private WebElement getSendEmailBtn() {
        By sendEmailBtnLocator = By.cssSelector("button#sendEmail");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendEmailBtnLocator));
        return driver.findElement(sendEmailBtnLocator);
    }

    public boolean newEmailComment() {
        By newCommentLocator = By.cssSelector("div.fancybox-inner > p:nth-of-type(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(newCommentLocator));
        try {
            WebElement newComment = driver.findElement(newCommentLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }

    public void doSendEmailFriend(String friendName, String friendEmail){
        getSendToFriendBtn().click();
        getFriendNameField().clear();
        getFriendNameField().sendKeys(friendName);
        getFriendEmailField().clear();
        getFriendEmailField().sendKeys(friendEmail);
        getSendEmailBtn().click();
    }

//    ADD TO WISH LIST:

    public void getAddToWishBtn() {
        By addToWishBtnLocator = By.cssSelector("a#wishlist_button");
        wait.until(ExpectedConditions.presenceOfElementLocated(addToWishBtnLocator));
        driver.findElement(addToWishBtnLocator).click();
    }

    public boolean newAddToWish() {
        By newAddWishLocator = By.cssSelector("p.fancybox-error");
        wait.until(ExpectedConditions.presenceOfElementLocated(newAddWishLocator));
        try {
            WebElement newComment = driver.findElement(newAddWishLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment.getText());
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }



}
