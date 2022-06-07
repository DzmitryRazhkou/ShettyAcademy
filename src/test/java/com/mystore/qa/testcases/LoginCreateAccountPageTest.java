package com.mystore.qa.testcases;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.LoginCreateAccountPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.MyStorePage;
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

    MyStorePage myStorePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginCreateAccountPage loginCreateAccountPage;

    @BeforeMethod
    public void startUp() {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = cp.initProp();
        driver = df.initDriver("chrome", prop);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public Iterator<Object[]> getFillUpPersonalData() {
        ArrayList<Object[]> testData = TestUtil.fillUpPersonalData();
        return testData.iterator();
    }

    @Test(dataProvider = "getFillUpPersonalData")
    public void fillUpPersonalInfoTest(String emailCreateAccount, String firstName, String lastName, String passwd,
        String days, String months, String years, String company, String addressFl, String addressSl, String city,
        String state, String zip, String addInfo, String phone){

        myStorePage = new MyStorePage(driver);
        loginPage = myStorePage.clickSignIn();
        loginCreateAccountPage = loginPage.doCreateAccount(emailCreateAccount);
        myAccountPage = loginCreateAccountPage.fillUpPersonalInfo(firstName, lastName, passwd, days, months, years,
                company, addressFl, addressSl, city, state, zip, addInfo, phone);
        Assert.assertTrue(myAccountPage.getMyAccountBreadCrumb());

    }




}
