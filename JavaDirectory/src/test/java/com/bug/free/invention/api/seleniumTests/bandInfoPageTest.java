package com.bug.free.invention.api.seleniumTests;

import com.bug.free.invention.api.framework.FunctionalTest;
import com.bug.free.invention.api.pages.bandInfoPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class bandInfoPageTest extends FunctionalTest {

    @Test
    public void getBandInfoPageTableTest() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertTrue(bandInfoPage.isInitialised());
    }

    @Test
    public void bandInfoBandNameCellIsNotNull() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertNotNull(bandInfoPage.getBandNameCellText(),"The band name cell is null");

    }

    @Test
    public void bandInfoBandLevelCellIsNotNull() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertNotNull(bandInfoPage.getBandLevelCellText(), "The band level cell is null");

    }

    @Test
    public void bandInfoBandTrainingCellIsNotNull() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertNotNull(bandInfoPage.getBandTrainingCellText(), "The band training cell is null");

    }

    @Test
    public void bandInfoBandCompetenciesCellIsNotNull() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertNotNull(bandInfoPage.getBandCompetenciesCellText(),"The expected competencies cell is null");

    }

    @Test
    public void bandInfoBandResponsibilitiesCellIsNotNull() {
        driver.get("http://localhost:6555/bandLevel");

        bandInfoPage bandInfoPage = new bandInfoPage(driver);

        Assertions.assertNotNull(bandInfoPage.getBandResponsibilitiesCellText(), "The expected responsibilities cell is null");

    }



}
