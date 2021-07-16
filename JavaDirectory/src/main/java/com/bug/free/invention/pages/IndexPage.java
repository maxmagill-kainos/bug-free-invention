package com.bug.free.invention.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends PageObject {

    @FindBy(id = "Jobs") private WebElement loginValidation;

    public JobRolesPage clickJobTableButton(){
        loginValidation.click();
        return new JobRolesPage(driver);
    }

    public IndexPage(WebDriver driver) {super(driver);}

    public boolean checkValidation() {
        return this.loginValidation.getText().equals("Jobs");
    }

}
