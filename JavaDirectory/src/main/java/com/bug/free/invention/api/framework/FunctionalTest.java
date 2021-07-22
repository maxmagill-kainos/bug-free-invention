package com.bug.free.invention.api.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();driver.close();
    }

}
