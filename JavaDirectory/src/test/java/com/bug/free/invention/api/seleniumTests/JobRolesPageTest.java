package com.bug.free.invention.api.seleniumTests;
import com.bug.free.invention.api.controllers.DBConfig;
import com.bug.free.invention.api.framework.FunctionalTest;
import com.bug.free.invention.api.pages.jobRolesPage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class JobRolesPageTest extends FunctionalTest {
    @BeforeEach
    public void setup(){
        DBConfig.TestMode();
    }
    @Test
    public void getJobRolesTableTest() {
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertTrue(jobRolesPage.isInitialised());
    }

    @Test
    public void jobRolesJobTitleCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertNotNull(jobRolesPage.getJobTitleCellText(),"This is job title cell is null");
    }

    @Test
    public void jobRolesJobCapabilityCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertNotNull(jobRolesPage.getJobCapabilityCellText(),"This is job Capability cell is null");
    }
    @Test
    public void jobRolesJobBandNameCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertNotNull(jobRolesPage.getJobBandNameCellText(),"This is job Band name cell is null");
    }
    @Test
    public void jobRolesJobBandLevelCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertNotNull(jobRolesPage.getJobBandLevelCellText(),"This is job Band Level cell is null");
    }
    @Test
    public void jobRolesJobFamilyNameCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        Assertions.assertNotNull(jobRolesPage.getJobFamilyCellText(),"This is job Family name cell is null");
    }

}