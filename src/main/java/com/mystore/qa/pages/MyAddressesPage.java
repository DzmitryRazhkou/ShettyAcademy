package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyAddressesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    //    VALIDATE BREADCRUMB:

    private WebElement getMyAddresses() {
        By myAddressesLocator = By.xpath("//strong[contains(text(),'Your addresses are listed below.')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAddressesLocator));
        return driver.findElement(myAddressesLocator);
    }

    public boolean getMyAddressesParagraphMessage() {
        try {
            System.out.println(" =====>" + getMyAddresses().getText() + " <===== ");
            return getMyAddresses().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyAddressesPageTitle() {
        System.out.println(" =====> My addresses page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    //    EXTRACT EXISTING DATA:
    public List<String> getExistingData() {
        By myAddressLocator = By.xpath("//ul[@class='last_item item box']/li");

        List<WebElement> myAddressList = driver.findElements(myAddressLocator);
        List<String> myAddressesTextList = new ArrayList<>();

        for (WebElement existDataRow : myAddressList) {
            if (existDataRow.isDisplayed()) {
                myAddressesTextList.add(existDataRow.getText());
            } else {
                return null;
            }
        }
        return myAddressesTextList;
    }
}
