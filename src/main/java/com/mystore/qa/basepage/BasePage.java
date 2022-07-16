package com.mystore.qa.basepage;

import com.mystore.qa.utils.TestUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.WEBDRIVERWAIT_DurationOfSeconds));
        log = Logger.getLogger(BasePage.class);
    }
}
