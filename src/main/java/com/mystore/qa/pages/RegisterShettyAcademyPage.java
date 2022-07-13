package com.mystore.qa.pages;
import com.mystore.qa.basepage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class RegisterShettyAcademyPage extends BasePage{

    public RegisterShettyAcademyPage(WebDriver driver) {
        super(driver);
    }

//    LOG IN FORM:

    private WebElement logInForm() {
        By logInFormLocator = By.cssSelector("div.login-section-wrapper");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInFormLocator));
        return driver.findElement(logInFormLocator);
    }

    public boolean getLogInForm() {
        try {
            System.out.println(" ===> Log in form is displayed. <=== ");
            return logInForm().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyStorePageTitle() {
        System.out.println(" =====> Register page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    SOCIAL MEDIA LINKS:

    public int socialMedia() {
        By socialMediaLocator = By.cssSelector("span:nth-of-type(2) a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(socialMediaLocator));

        List<WebElement> list = driver.findElements(socialMediaLocator);
        int amountOfSocialMediaLinks = list.size();
        System.out.println("Amount of social media links are: " + list.size());
        return amountOfSocialMediaLinks;
    }

//    SHETTY ACADEMY EMAIL:

    public String shettyAcademyEmail() {
        By academyEmailLocator = By.cssSelector("span:nth-of-type(1) a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(academyEmailLocator));
        String academyEmailText = driver.findElement(academyEmailLocator).getText();
        System.out.println(" =====> Shetty academy email is: " + academyEmailText + " <===== ");
        return academyEmailText;
    }

//    LOG IN:

    private WebElement emailField() {
        By emailFieldLocator = By.id("userEmail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        return driver.findElement(emailFieldLocator);
    }

    private WebElement passwordField() {
        By passwordFieldLocator = By.id("userPassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        return driver.findElement(passwordFieldLocator);
    }

    private WebElement loginField() {
        By loginFieldLocator = By.id("login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFieldLocator));
        return driver.findElement(loginFieldLocator);
    }

    public ProductShettyAcademyPage doLogin(String email, String password) {
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginField().click();
        return new ProductShettyAcademyPage(driver);
    }

//    VALIDATE LOGIN OUT CONFIRMATION MESSAGE:

    private WebElement getLogOutGreenConfirmationMessage() {
        By getLogOutGreenConfirmationMessageLocator = By.cssSelector("div[role='alertdialog']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLogOutGreenConfirmationMessageLocator));
        return driver.findElement(getLogOutGreenConfirmationMessageLocator);
    }

    public boolean validateGetLogOutGreenConfirmationMessage() {
        try {
            System.out.println("=====> Confirmation message is: " + getLogOutGreenConfirmationMessage().getText() + " <=====");
            return getLogOutGreenConfirmationMessage().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    REGISTER:

    private WebElement getRegisterBtn() {
        By registerBtnLocator = By.cssSelector("a.btn1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtnLocator));
        return driver.findElement(registerBtnLocator);
    }

    private WebElement firstNameField() {
        By firstnameFieldLocator = By.id("firstName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameFieldLocator));
        return driver.findElement(firstnameFieldLocator);
    }

    private WebElement lastNameField() {
        By lastNameFieldLocator = By.id("lastName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFieldLocator));
        return driver.findElement(lastNameFieldLocator);
    }

    private WebElement emailUserField() {
        By emailUserLocator = By.id("userEmail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailUserLocator));
        return driver.findElement(emailUserLocator);
    }

    private WebElement getUserMobileField() {
        By userMobileLocator = By.id("userMobile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMobileLocator));
        return driver.findElement(userMobileLocator);
    }

    private void getOccupation(String occupation) {
        By occupationLocator = By.cssSelector("select[formcontrolname='occupation'] option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(occupationLocator));

        List<WebElement> list = driver.findElements(occupationLocator);

        for (WebElement webElement : list) {
            if (webElement.getText().equals(occupation)) {
                webElement.click();
                break;
            }
        }
    }

    private WebElement getGender(){
        By getGenderLocator = By.cssSelector("input[value='Male']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getGenderLocator));
        return driver.findElement(getGenderLocator);
    }

    private WebElement getUserPassword() {
        By userPasswordLocator = By.id("userPassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userPasswordLocator));
        return driver.findElement(userPasswordLocator);
    }

    private WebElement getConfirmUserPassword() {
        By confirmedUserPasswordLocator = By.id("confirmPassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmedUserPasswordLocator));
        return driver.findElement(confirmedUserPasswordLocator);
    }

    private WebElement getCheckBox() {
        By getCheckBoxLocator = By.cssSelector("input[type='checkbox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckBoxLocator));
        return driver.findElement(getCheckBoxLocator);
    }

    private WebElement getLoginBtn() {
        By loginBtnLocator = By.id("login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        return driver.findElement(loginBtnLocator);
    }




    public void doRegistration(String firstName, String lastName, String email, String phoneNumber, String occupation, String password) {
        getRegisterBtn().click();

        firstNameField().clear();
        firstNameField().sendKeys(firstName);

        lastNameField().clear();
        lastNameField().sendKeys(lastName);

        emailUserField().clear();
        emailUserField().sendKeys(email);

        getUserMobileField().clear();
        getUserMobileField().sendKeys(phoneNumber);

        getOccupation(occupation);

        getGender().click();

        getUserPassword().clear();
        getUserPassword().sendKeys(password);

        getConfirmUserPassword().clear();
        getConfirmUserPassword().sendKeys(password);

        getCheckBox().click();

        getLoginBtn().click();
    }

//    PROVE OF THE SUCCESSFUL REGISTRATION:

    private WebElement successMessage() {
        By successMessageLocator = By.cssSelector("h1.headcolor");
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return driver.findElement(successMessageLocator);
    }

    public boolean validateSuccessRegistration() {
        try {
            System.out.println(" ====> "+ successMessage().getText()+ " <==== ");
            return successMessage().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" =====> Please provide the correct locator. <=====");
            return false;
        }
    }

}

















