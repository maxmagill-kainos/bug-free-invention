package com.bug.free.invention.api.framework;

import com.bug.free.invention.api.ApiApplication;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeAll
    public static void setUp() {
        try {
            SpringApplication.run(ApiApplication.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
    }
    public static void tearDown() {
        driver.close();
    }
}
