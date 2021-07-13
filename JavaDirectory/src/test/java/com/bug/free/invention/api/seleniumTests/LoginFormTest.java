package com.bug.free.invention.api.seleniumTests;

import com.bug.free.invention.framework.FunctionalTest;
import com.bug.free.invention.pages.IndexPage;
import com.bug.free.invention.pages.LoginPage;
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
        assertTrue("Signin was successful:  " + indexPage.checkValidation(), indexPage.checkValidation());
    }

    @Test
    public void checkLoginInvalid() {
        driver.get("http://localhost:6555");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterLoginDetails("john.smith","password123");
        loginPage.submitFail();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue("Signin was successful:  " + loginPage.checkFailedLogin(), loginPage.checkFailedLogin());
    }
}
