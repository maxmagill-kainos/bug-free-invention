package com.bug.free.invention.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "username") private WebElement usernameField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(id = "errorMessage") private WebElement errorMessage;
    @FindBy(id = "submitButton") private WebElement submitButton;

    public LoginPage(WebDriver driver) {super(driver);}

    public void enterLoginDetails(String username, String password) {
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
        this.passwordField.clear();
        this.passwordField.sendKeys(password);

    }

    public IndexPage submit() {
        submitButton.click();
        return new IndexPage(driver);
    }

    public void submitFail(){
        submitButton.click();
    }

    public boolean checkFailedLogin(){
        return errorMessage.getText().equals("Incorrect Username or Password");
    }
}
