package com.bug.free.invention.api.seleniumTests;
import com.bug.free.invention.api.framework.FunctionalTest;
import com.bug.free.invention.api.pages.jobRolesPage;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class jobRolesPageTest extends FunctionalTest {

    @Test
    public void getJobRolesTableTest() {
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertTrue(jobRolesPage.isInitialised());
    }

    @Test
    public void jobRolesJobTitleCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertNotNull("This is job title cell is null",jobRolesPage.getJobTitleCellText());
    }

    @Test
    public void jobRolesJobCapabilityCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertNotNull("This is job Capability cell is null",jobRolesPage.getJobCapabilityCellText());
    }
    @Test
    public void jobRolesJobBandNameCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertNotNull("This is job Band name cell is null",jobRolesPage.getJobBandNameCellText());
    }
    @Test
    public void jobRolesJobBandLevelCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertNotNull("This is job Band Level cell is null",jobRolesPage.getJobBandLevelCellText());
    }
    @Test
    public void jobRolesJobFamilyNameCellIsNotNull(){
        driver.get("http://localhost:6555/JobsTable");

        jobRolesPage jobRolesPage = new jobRolesPage(driver);

        assertNotNull("This is job Family name cell is null",jobRolesPage.getJobFamilyCellText());
    }

}