package com.bug.free.invention.api.seleniumTests;

import com.bug.free.invention.pages.JobRolesPage;
import com.bug.free.invention.framework.FunctionalTest;
import com.bug.free.invention.pages.IndexPage;
import com.bug.free.invention.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JobRolesTest extends FunctionalTest {

        public JobRolesPage login(String username, String password){
            driver.get("http://localhost:6555");

            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterLoginDetails("john.smith","password");
            IndexPage indexPage = loginPage.submit();
            return indexPage.clickJobTableButton();
        }

        @Test
        public void getJobRolesTableTest() {

            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertTrue(jobRolesPage.isInitialised());
        }

        @Test
        public void jobRolesJobTitleCellIsNotNull(){


            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertNotNull(jobRolesPage.getJobTitleCellText(),"This is job title cell is null");
        }

        @Test
        public void jobRolesJobCapabilityCellIsNotNull(){
;

            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertNotNull(jobRolesPage.getJobCapabilityCellText(),"This is job Capability cell is null");
        }
        @Test
        public void jobRolesJobBandNameCellIsNotNull(){


            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertNotNull(jobRolesPage.getJobBandNameCellText(),"This is job Band name cell is null");
        }
        @Test
        public void jobRolesJobBandLevelCellIsNotNull(){


            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertNotNull(jobRolesPage.getJobBandLevelCellText(),"This is job Band Level cell is null");
        }
        @Test
        public void jobRolesJobFamilyNameCellIsNotNull(){

            JobRolesPage jobRolesPage = login("john.smith","password");

            Assertions.assertNotNull(jobRolesPage.getJobFamilyCellText(),"This is job Family name cell is null");
        }

        @Test
        public void checkValidChangeToJobTitle() throws InterruptedException {
            JobRolesPage jobRolesPage = login("john.smith","password");
            jobRolesPage.updateJobTitle("Ai Consultant test");
            Assertions.assertTrue(jobRolesPage.checkJobTitle("Ai Consultant test"), "Job title not updated");
        }

        @Test
        public void checkValidChangeToCapabilityNameAndFamilyName() throws InterruptedException {
            JobRolesPage jobRolesPage = login("john.smith","password");
            boolean check = jobRolesPage.checkCapabilityAndFamilyName(jobRolesPage.updateCapabilityNameAndFamilyName(2, 3));
            Assertions.assertTrue(check);
        }

        @Test
        public void checkValidChangeToBandNameAndBandLevel() throws InterruptedException {
            JobRolesPage jobRolesPage = login("john.smith","password");
            boolean check = jobRolesPage.checkBandNameAndBandLevel(jobRolesPage.updateBandName());
            Assertions.assertTrue(check);
        }

        @Test
        public void checkInvalidChangeToJobTitle() throws InterruptedException {
            JobRolesPage jobRolesPage = login("john.smith","password");
            jobRolesPage.updateJobTitle("Ai");
            Assertions.assertFalse(jobRolesPage.checkJobTitle("Ai"), "Job title updated");
        }

        @Test
        public void checkInValidChangeToCapabilityNameAndFamilyName() throws InterruptedException {
            JobRolesPage jobRolesPage = login("john.smith","password");
            boolean check = jobRolesPage.checkCapabilityAndFamilyName(jobRolesPage.updateCapabilityNameAndFamilyName(3, 0));
            Assertions.assertFalse(check);
        }
    }

