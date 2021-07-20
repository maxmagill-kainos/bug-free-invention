package com.bug.free.invention.api.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class jobRolesPage extends PageObject{

    @FindBy(id = "myTable") private WebElement table;
    @FindBy(id = "jobTitleCell1") private WebElement jobTitleRow1;
    @FindBy(id = "jobCapabilityCell1") private WebElement jobCapabilityRow1;
    @FindBy(id = "jobBandNameCell1") private WebElement jobBandNameRow1;
    @FindBy(id = "jobBandLevelCell1") private WebElement jobBandLevelRow1;
    @FindBy(id = "jobFamilyNameCell1") private WebElement jobFamilyNameRow1;

    public jobRolesPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isInitialised() {
        return table.isDisplayed();
    }

    public String getJobTitleCellText(){
        return jobTitleRow1.getText();
    }

    public String getJobCapabilityCellText(){
        return jobCapabilityRow1.getText();
    }

    public String getJobBandNameCellText(){
        return jobBandNameRow1.getText();
    }

    public String getJobBandLevelCellText(){
        return jobBandLevelRow1.getText();
    }

    public String getJobFamilyCellText(){
        return jobFamilyNameRow1.getText();
    }


}
