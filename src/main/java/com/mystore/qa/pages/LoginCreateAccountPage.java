package com.mystore.qa.pages;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginCreateAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginCreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
    }

    private WebElement authenticationBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getAuthenticationBreadcrumb() {
        try {
            System.out.println(" ===> Header authentication breadcrumb is displayed. <=== ");
            System.out.println(authenticationBreadcrumb().getText());
            return authenticationBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    YOUR PERSONAL INFORMATION:

//    1. Title:

    private WebElement getMrRadioBtn() {
        By getMrRadioBtnLocator = By.cssSelector("#id_gender1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrRadioBtnLocator));
        return driver.findElement(getMrRadioBtnLocator);
    }

    private WebElement getMrsRadioBtn() {
        By getMrsRadioBtnLocator = By.cssSelector("#id_gender2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrsRadioBtnLocator));
        return driver.findElement(getMrsRadioBtnLocator);
    }

//    First Name:

    private WebElement getFirstName() {
        By getFirstNameLocator = By.cssSelector("#customer_firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }

//    Last Name:

    private WebElement getLastName() {
        By getLastNameLocator = By.cssSelector("#customer_lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }

//    Password:

    private WebElement getPassword() {
        By getPasswordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordLocator));
        return driver.findElement(getPasswordLocator);
    }

//    Date Of Birth:

//    1. Days

    private WebElement getDays() {
        By getDaysLocator = By.cssSelector("#days");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysLocator));
        return driver.findElement(getDaysLocator);
    }

    private WebElement getDaysValues() {
        By getDaysValuesLocator = By.cssSelector("#days>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysValuesLocator));
        return driver.findElement(getDaysValuesLocator);
    }

    public void selectDays(String dayValue) {
        getDays().click();
        List<WebElement> list = driver.findElements((By) getDaysValues());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains(dayValue)) {
                list.get(i).click();
                break;
            }
        }
    }

//    2. Months

    private WebElement getMonths() {
        By getMonthsLocator = By.cssSelector("#months");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsLocator));
        return driver.findElement(getMonthsLocator);
    }

    private WebElement getMonthsValues() {
        By getMonthsValuesLocator = By.cssSelector("#months>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsValuesLocator));
        return driver.findElement(getMonthsValuesLocator);
    }

    public void selectMonths(String monthValue) {
            getMonths().click();
            List<WebElement> list = driver.findElements((By) getMonthsValues());

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getText());
                if (list.get(i).getText().contains(monthValue)) {
                    list.get(i).click();
                    break;
                }
            }
        }


//    3. Years

    private WebElement getYears() {
        By getYearsLocator = By.cssSelector("#years");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsLocator));
        return driver.findElement(getYearsLocator);
    }

    private WebElement getYearsValues() {
        By getYearsValuesLocator = By.cssSelector("#years>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsValuesLocator));
        return driver.findElement(getYearsValuesLocator);
    }

    public void selectYears(String yearsValue) {
            getYears().click();
            List<WebElement> list = driver.findElements((By) getYearsValues());

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getText());
                if (list.get(i).getText().contains(yearsValue)) {
                    list.get(i).click();
                    break;
                }
            }
        }

//    YOUR ADDRESS:

//    1. First Name:

    private WebElement getFirstNameAddress() {
        By getFirstNameAddressLocator = By.cssSelector("#firstname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameAddressLocator));
        return driver.findElement(getFirstNameAddressLocator);
    }

//    2. Last Name:

    private WebElement getLastNameAddress() {
        By getLastNameAddressLocator = By.cssSelector("#lastname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameAddressLocator));
        return driver.findElement(getLastNameAddressLocator);
    }

//    3. Company:

    private WebElement getCompany() {
        By getCompanyLocator = By.cssSelector("#company");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCompanyLocator));
        return driver.findElement(getCompanyLocator);
    }

//    4. Address:

    //    First Line
    private WebElement getAddressFirstLine() {
        By getAddressFirstLineLocator = By.cssSelector("#address1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressFirstLineLocator));
        return driver.findElement(getAddressFirstLineLocator);
    }

    //    Second Line
    private WebElement getAddressSecondLine() {
        By getAddressSecondLineLocator = By.cssSelector("#address2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressSecondLineLocator));
        return driver.findElement(getAddressSecondLineLocator);
    }

//    5. City:

    private WebElement getCity() {
        By getCityLocator = By.cssSelector("#city");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

//    6. State:

    private WebElement getStates() {
        By getStatesLocator = By.cssSelector("#id_state");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStatesLocator));
        return driver.findElement(getStatesLocator);
    }

    private WebElement getStatesValues() {
        By getStatesValuesLocator = By.cssSelector("#id_state>option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStatesValuesLocator));
        return driver.findElement(getStatesValuesLocator);
    }

    public void selectStates(String stateValue) {
        getStates().click();
        Select select = new Select(getStatesValues());
        select.selectByValue(stateValue);
    }

//    7. ZIP/POSTAL CODE

    private WebElement getZipCode() {
        By getZipCodeLocator = By.cssSelector("#postcode");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getZipCodeLocator));
        return driver.findElement(getZipCodeLocator);
    }

//    8. Additional Info

    private WebElement getAddInfo() {
        By getAddInfoLocator = By.cssSelector("#other");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddInfoLocator));
        return driver.findElement(getAddInfoLocator);
    }

//    9. Home phone:

    private WebElement getHomePhone() {
        By getHomePhoneLocator = By.cssSelector("#phone");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getHomePhoneLocator));
        return driver.findElement(getHomePhoneLocator);
    }

//    10. Mobile phone:

    private WebElement getMobilePhone() {
        By getMobilePhoneLocator = By.cssSelector("#phone_mobile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMobilePhoneLocator));
        return driver.findElement(getMobilePhoneLocator);
    }

//    11. REGISTER BUTTON

    private WebElement getRegisterBtn() {
        By getRegisterBtnLocator = By.cssSelector("#submitAccount");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getRegisterBtnLocator));
        return driver.findElement(getRegisterBtnLocator);
    }


//    FINAL METHOD


    public void fillUpPersonalInfo(String firstName, String lastName, String password,
                                   String dayDOB, String monthDOB, String yearDOB, String company, String addressFL, String addressSL,
                                   String city, String state, String zipCode, String addInfo, String phone) {

        getMrRadioBtn().click();

        getFirstName().clear();
        getFirstName().sendKeys(firstName);

        getLastName().clear();
        getLastName().sendKeys(lastName);

        getPassword().clear();
        getPassword().sendKeys(password);

        selectDays(dayDOB);
        selectMonths(monthDOB);
        selectYears(yearDOB);

        getFirstNameAddress().clear();
        getFirstNameAddress().sendKeys(firstName);

        getLastNameAddress().clear();
        getLastNameAddress().sendKeys(lastName);

        getCompany().clear();
        getCompany().sendKeys(company);

        getAddressFirstLine().clear();
        getAddressFirstLine().sendKeys(addressFL);

        getAddressSecondLine().clear();
        getAddressSecondLine().sendKeys(addressSL);

        getCity().clear();
        getCity().sendKeys(city);

        selectStates(state);

        getZipCode().clear();
        getZipCode().sendKeys(zipCode);

        getAddInfo().clear();
        getAddInfo().sendKeys(addInfo);

        getHomePhone().clear();
        getHomePhone().sendKeys(phone);

        getMobilePhone().clear();
        getMobilePhone().sendKeys(phone);

        getRegisterBtn().click();
    }


}
