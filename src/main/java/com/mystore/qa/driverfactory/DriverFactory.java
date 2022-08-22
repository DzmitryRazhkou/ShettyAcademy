package com.mystore.qa.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;

    public WebDriver initDriver(String browserName, Properties prop) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                System.out.println(" =====> Selenium Chrome <===== ");
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1470, 790");
                driver = new ChromeDriver(options);
                System.out.println(" =====> Selenium Chrome Headless <===== ");
                break;

            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                System.out.println(" =====> Selenium FireFox <===== ");
                break;

            case "firefox-headless":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--window-size=1470, 790");
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println(" =====> Selenium FireFox Headless <===== ");
                break;

            case "safari":
                driver = WebDriverManager.safaridriver().create();
                System.out.println(" =====> Selenium Safari <===== ");
                break;

            default:
                System.out.println("Pass the right browser name ..... ");
                break;
        }

        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}
