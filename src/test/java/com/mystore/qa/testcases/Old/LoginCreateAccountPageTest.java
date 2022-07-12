package com.mystore.qa.testcases.Old;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.Old.LoginCreateAccountPage;
import com.mystore.qa.pages.Old.LoginPage;
import com.mystore.qa.pages.Old.MyAccountPage;
import com.mystore.qa.pages.RegisterShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class LoginCreateAccountPageTest {

    ConfigReader cp;
    DriverFactory df;
    Properties prop;

    private static WebDriver driver;
    private static WebDriverWait wait;

    RegisterShettyAcademyPage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginCreateAccountPage loginCreateAccountPage;

    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = ConfigReader.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validateMyLoginCreateAccountPageTitle(){
        String emailCreate = prop.getProperty("loginCreateAccountPage");
        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreate);
        String actMyLoginPageTitle = loginPage.getMyLoginPageTitle();
        String expMyLoginPageTitle = prop.getProperty("myLoginCreateAccountPageTitle");
        Assert.assertEquals(expMyLoginPageTitle, actMyLoginPageTitle);
    }

    @DataProvider
    public Iterator<Object[]> getFillUpPersonalData() {
        ArrayList<Object[]> testData = TestUtil.fillUpPersonalData();
        return testData.iterator();
    }

    @Test(dataProvider = "getFillUpPersonalData")
    public void fillUpPersonalInfoTest(String emailCreateAccount, String firstName, String lastName, String password,
        String days, String months, String years, String company, String addressFl, String addressSl, String city,
        String state, long zip, String addInfo, long phone){

        myStorePage = new RegisterShettyAcademyPage(driver);
//        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreateAccount);
        myAccountPage = loginCreateAccountPage.fillUpPersonalInfo(firstName, lastName, password, days, months, years,
                company, addressFl, addressSl, city, state, zip, addInfo, phone);
        Assert.assertTrue(myAccountPage.getMyAccountBreadCrumb());
    }
}
