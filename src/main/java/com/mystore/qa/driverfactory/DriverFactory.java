package com.mystore.qa.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initDriver(String browserName, Properties prop) throws MalformedURLException {

        switch (browserName.toLowerCase()) {

//            Google Chrome:

            case "chrome" -> {
                driver = WebDriverManager.chromedriver().create();
                System.out.println(" =====> Selenium Chrome <===== ");
            }
            case "chrome-headless" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1470, 790");
                driver = new ChromeDriver(options);
                System.out.println(" =====> Selenium Chrome Headless <===== ");
            }
            case "chrome-grid" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver((new URL("")), chromeOptions);
                System.out.println(" =====> Selenium Chrome Grid <===== ");
            }

//            Firefox Mozilla:

            case "firefox" -> {
                driver = WebDriverManager.firefoxdriver().create();
                System.out.println(" =====> Selenium FireFox <===== ");
            }
            case "firefox-headless" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--window-size=1470, 790");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println(" =====> Selenium FireFox Headless <===== ");
            }
            case "firefox-grid" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffGridOptions = new FirefoxOptions();
                driver = new RemoteWebDriver((new URL("")), ffGridOptions);
                System.out.println(" =====> Selenium FireFox Grid <===== ");
            }
            default -> System.out.println("Pass the right browser name ..... ");
        }

        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}
