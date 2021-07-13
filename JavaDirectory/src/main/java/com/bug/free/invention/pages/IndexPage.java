package com.bug.free.invention.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class IndexPage extends PageObject {

    @FindBy(id = "Jobs") private WebElement loginValidation;

    public IndexPage(WebDriver driver) {super(driver);}

    public boolean checkValidation() {
        return this.loginValidation.getText().equals("Jobs");
    }

}
