package com.bug.free.invention.api.seleniumTests;

import com.bug.free.invention.framework.FunctionalTest;
import com.bug.free.invention.pages.IndexPage;
import com.bug.free.invention.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LoginFormTest extends FunctionalTest {

    @Test
    public void checkLoginValid() {
        driver.get("http://localhost:6555");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLoginDetails("john.smith","password");
        IndexPage indexPage = loginPage.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(indexPage.checkValidation(), "Signin was successful:  " + indexPage.checkValidation());
    }

    @Test
    public void checkLoginInvalid() {
        driver.get("http://localhost:6555");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLoginDetails("john.smith","password123");
        loginPage.submitFail();
        boolean result = loginPage.checkFailedLogin();
        Assertions.assertTrue(result, "Signin was successful");
    }
}
