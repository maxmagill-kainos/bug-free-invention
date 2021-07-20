package com.bug.free.invention.api.framework;

import com.bug.free.invention.api.ApiApplication;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

@TestInstance(Lifecycle.PER_CLASS)
public class FunctionalTest {

    protected static WebDriver driver;
    protected final static String browserVersion = System.getProperty(BROWSER_VERSION);

    @BeforeAll
    public void setUp() {
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
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
