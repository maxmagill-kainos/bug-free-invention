package com.bug.free.invention.pages;

import com.bug.free.invention.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobRolesPage extends PageObject {

    @FindBy(id = "myTable") private WebElement table;
    @FindBy(id = "jobTitleCell1") private WebElement jobTitleRow1;
    @FindBy(id = "jobCapabilityCell1") private WebElement jobCapabilityRow1;
    @FindBy(id = "jobBandNameCell1") private WebElement jobBandNameRow1;
    @FindBy(id = "jobBandLevelCell1") private WebElement jobBandLevelRow1;
    @FindBy(id = "jobFamilyNameCell1") private WebElement jobFamilyNameRow1;
    @FindBy(id = "edit1") private  WebElement editButton;

    public JobRolesPage(WebDriver driver) {
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

    public void updateJobTitle(String jobTitle){
        editButton.click();
        WebElement jobTitleField = driver.findElement(By.id("jobTitleEdit1"));
        jobTitleField.clear();
        jobTitleField.sendKeys(jobTitle);
        WebElement checkButton = driver.findElement(By.id("checkButton1"));
        checkButton.click();
    }

    public boolean checkJobTitle(String jobTitle) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return driver.findElement(By.id("jobTitleCell1")).getText().equals(jobTitle);
    }

    public List<String> updateCapabilityNameAndFamilyName(int capabilityIndex, int familyNameIndex) throws InterruptedException {
        List<String> choices = new ArrayList<String>();
        editButton.click();
        WebElement capabilityName = driver.findElement(By.id("capabilityEdit1"));
        TimeUnit.SECONDS.sleep(2);
        capabilityName.click();
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> listOptionsCapability = capabilityName.findElements(By.tagName("li"));
        choices.add(listOptionsCapability.get(capabilityIndex).getText());
        listOptionsCapability.get(capabilityIndex).click();
        TimeUnit.SECONDS.sleep(2);
        WebElement familyName = driver.findElement(By.id("familyNameEdit1"));
        familyName.click();
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> listOptionsFamilyName = familyName.findElements(By.tagName("li"));
        choices.add(listOptionsFamilyName.get(familyNameIndex).getText());
        listOptionsFamilyName.get(familyNameIndex).click();
        TimeUnit.SECONDS.sleep(2);
        WebElement checkButton = driver.findElement(By.id("checkButton1"));
        checkButton.click();
        return choices;
    }

    public List<String> updateBandName() throws InterruptedException {
        List<String> choices = new ArrayList<String>();
        editButton.click();

        TimeUnit.SECONDS.sleep(2);
        WebElement bandName = driver.findElement(By.id("bandNameEdit1"));
        bandName.click();
        TimeUnit.SECONDS.sleep(2);

        List<WebElement> listOptionsBandName = bandName.findElements(By.tagName("li"));
        choices.add(listOptionsBandName.get(3).getText());
        listOptionsBandName.get(3).click();
        TimeUnit.SECONDS.sleep(2);

        choices.add(driver.findElement(By.id("jobBandLevelCell1")).getText());
        WebElement checkButton = driver.findElement(By.id("checkButton1"));
        TimeUnit.SECONDS.sleep(2);
        checkButton.click();
        return choices;
    }

    public boolean checkBandNameAndBandLevel(List<String> choices) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return choices.get(0).equals(driver.findElement(By.id("jobBandNameCell1")).getText()) &&
                choices.get(1).equals(driver.findElement(By.id("jobBandLevelCell1")).getText());
    }
    public boolean checkCapabilityAndFamilyName(List<String> choices) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return choices.get(0).equals(driver.findElement(By.id("jobCapabilityCell1")).getText()) &&
                choices.get(1).equals(driver.findElement(By.id("jobFamilyNameCell1")).getText());
    }


}