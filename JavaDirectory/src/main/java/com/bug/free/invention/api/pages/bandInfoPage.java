package com.bug.free.invention.api.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class bandInfoPage extends PageObject {

    @FindBy(id = "myTable") private WebElement table;
    @FindBy(id = "bandNameCell1") private WebElement bandNameRow1;
    @FindBy(id = "bandLevelCell1") private WebElement bandLevelRow1;
    @FindBy(id = "bandTrainingCell1") private WebElement bandTrainingRow1;
    @FindBy(id = "bandCompetenciesCell1") private WebElement bandCompetenciesRow1;
    @FindBy(id = "bandResponsibilitiesCell1") private WebElement bandResponsibilitiesRow1;

    public bandInfoPage(WebDriver driver) { super(driver); }

    public Boolean isInitialised() { return table.isDisplayed(); }

    public String getBandNameCellText() { return bandNameRow1.getText(); }

    public String getBandLevelCellText() { return bandLevelRow1.getText(); }

    public String getBandTrainingCellText() { return bandTrainingRow1.getText(); }

    public String getBandCompetenciesCellText() { return bandCompetenciesRow1.getText(); }

    public String getBandResponsibilitiesCellText() { return bandResponsibilitiesRow1.getText(); }





}
