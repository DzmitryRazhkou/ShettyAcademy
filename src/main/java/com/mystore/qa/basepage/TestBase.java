package com.mystore.qa.basepage;

import com.mystore.qa.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/dzmitryrazhkou/Documents/Automation/MyStore/src/main/java/com/mystore/qa/config/Config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method launch the browser
     */

    public static void initialization() {

        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT_DurationOfSeconds));
        driver.get(prop.getProperty("url"));
    }

    public static void finalization() {
        if (driver != null) {
            driver.quit();
        }
    }
}


