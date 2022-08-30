package com.mystore.qa.basetest;

import com.mystore.qa.driverfactory.DriverFactory;
import com.mystore.qa.pages.ProductShettyAcademyPage;
import com.mystore.qa.utils.ConfigReader;
import com.mystore.qa.utils.Screenshot;
import com.mystore.qa.utils.Token;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.Properties;

@Listeners(com.mystore.qa.listeners.Listeners.class)
public class BaseTest {
    protected ConfigReader cp;
    protected DriverFactory df;
    protected Properties prop;
    protected static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void startUp(String browser) throws MalformedURLException {
        cp = new ConfigReader();
        df = new DriverFactory();
        prop = ConfigReader.initProp();
        driver = df.initDriver(browser, prop);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.FAILURE == result.getStatus()) {
            Screenshot.takeScreenshot(driver, result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public ProductShettyAcademyPage loginToApp(String username, String password) throws InterruptedException {
        String key = "jwt-token";
        String value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MmNiOTkxMGUyNmI3ZTFhMTBmMTBkNDEiLCJ1c2VyRW1haWwiOiJkaW1hZ2FkamlsbGFAZ21haWwuY29tIiwidXNlck1vYmlsZSI6MzIzNDk2MjUxOSwidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTY2MDg4MDY3MywiZXhwIjoxNjkyNDM4MjczfQ.4hrSIb5xsReZ228Ktrugeb8n7IxaHv-AwKpbv7ohXWg";
        driver.get("https://rahulshettyacademy.com/client/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])", key, "\"" + value + "\"");
        driver.navigate().refresh();
        return new ProductShettyAcademyPage(driver);
    }
}
