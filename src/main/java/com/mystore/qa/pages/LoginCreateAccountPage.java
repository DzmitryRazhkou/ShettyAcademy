package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginCreateAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginCreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

//    YOUR PERSONAL INFORMATION:

//    1. Title:

    private WebElement getMrRadioBtn(){
        By getMrRadioBtnLocator = By.cssSelector("#id_gender1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrRadioBtnLocator));
        return driver.findElement(getMrRadioBtnLocator);
    }

    private WebElement getMrsRadioBtn(){
        By getMrsRadioBtnLocator = By.cssSelector("#id_gender2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrsRadioBtnLocator));
        return driver.findElement(getMrsRadioBtnLocator);
    }

//    First Name:

    private WebElement getFirstName(){
        By getFirstNameLocator = By.cssSelector("#customer_firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }

//    Last Name:

    private WebElement getLastName(){
        By getLastNameLocator = By.cssSelector("#customer_lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }

//    Password:

    private WebElement getPassword(){
        By getPasswordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordLocator));
        return driver.findElement(getPasswordLocator);
    }

//    Date Of Birth:

//    1. Days

    private WebElement getDays(){
        By getDaysLocator = By.cssSelector("#days");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysLocator));
        return driver.findElement(getDaysLocator);
    }

    private WebElement getDaysValues(){
        By getDaysValuesLocator = By.cssSelector("#days>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysValuesLocator));
        return driver.findElement(getDaysValuesLocator);
    }

//    2. Months

    private WebElement getMonths(){
        By getMonthsLocator = By.cssSelector("#months");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsLocator));
        return driver.findElement(getMonthsLocator);
    }

    private WebElement getMonthsValues(){
        By getMonthsValuesLocator = By.cssSelector("#months>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsValuesLocator));
        return driver.findElement(getMonthsValuesLocator);
    }

//    3. Years

    private WebElement getYears(){
        By getYearsLocator = By.cssSelector("#years");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsLocator));
        return driver.findElement(getYearsLocator);
    }

    private WebElement getYearsValues(){
        By getYearsValuesLocator = By.cssSelector("#years>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsValuesLocator));
        return driver.findElement(getYearsValuesLocator);
    }







}
