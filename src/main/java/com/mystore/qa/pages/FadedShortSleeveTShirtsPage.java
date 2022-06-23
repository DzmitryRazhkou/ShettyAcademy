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

    private WebElement getSendBtn() {
        By sendBtnLocator = By.cssSelector("button#submitNewMessage");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendBtnLocator));
        return driver.findElement(sendBtnLocator);
    }

    public boolean newComment() {
        By newCommentLocator = By.cssSelector("div.fancybox-inner");
        wait.until(ExpectedConditions.presenceOfElementLocated(newCommentLocator));
        try {
            WebElement newComment = driver.findElement(newCommentLocator);
            newComment.isDisplayed();
            System.out.println("New comment text is: " + newComment);
            return true;
        } catch (TimeoutException y) {
            System.out.println("Provide another locator");
            return false;
        }
    }


}
