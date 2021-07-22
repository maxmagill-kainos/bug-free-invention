package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.controllers.BandGetLevelController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class BandLevelServiceTest {
    @MockBean
    BandGetLevelController bandController;

    @Autowired
    BandLevelService service;

    @Test
    @DisplayName("Should get list with all bands")
    void shouldGetListWithAllBands() {
        List<Band> band = service.getAllBands();
        assertEquals(8, band.size());
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Apprentice")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Trainee")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Associate")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Senior")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Consultant")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Manager")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Principal")));
        assertTrue(band.stream().anyMatch(b -> b.getBandName().equals("Leadership Community")));
    }

    @Test
    @DisplayName("Should find bandLevel by bandID")
    void shouldFindBandLevelByBandID() throws SQLException {
        assertEquals(Optional.of(1), service.getBandLevelByBandID(1));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when passed null value")
    void testNullChecksBandID() {
        assertThrows(IllegalArgumentException.class, () -> service.getBandLevelByBandID(null));
    }


    @Test
    @DisplayName("Should find bandLevel by bandName")
    void shouldFindBandLevelByBandName() throws SQLException {
        assertEquals(Optional.of(1), service.getBandLevelByBandName("Apprentice"));
        assertEquals(Optional.of(2), service.getBandLevelByBandName("Trainee"));
        assertEquals(Optional.of(3), service.getBandLevelByBandName("Associate"));
        assertEquals(Optional.of(4), service.getBandLevelByBandName("Senior"));
        assertEquals(Optional.of(5), service.getBandLevelByBandName("Consultant"));
        assertEquals(Optional.of(6), service.getBandLevelByBandName("Manager"));
        assertEquals(Optional.of(7), service.getBandLevelByBandName("Principal"));
        assertEquals(Optional.of(8), service.getBandLevelByBandName("Leadership Community"));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when passed null value")
    void testNullChecksBandName() {
        assertThrows(IllegalArgumentException.class, () -> service.getBandLevelByBandName(null));
    }

    @Test
    @DisplayName("Should throw an exception if band was not deleted")
    void shouldThrowAnExceptionIfBandWasNotDeleted() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteBandByBandID(56));
    }

    @Test
    @DisplayName("Should throw an exception if band was not found")
    void shouldThrowAnExceptionIfBandWasNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteBandByBandID(678));
    }

    @Test
    @DisplayName("Should add a band")
    void  shouldAddABand() {
        Band band = new Band(9, "Whatever", 45, "Whatever", "Whatever", "Whatever");
       service.addBand(band);
       service.deleteBandByBandID(9);
    }

    @Test
    @DisplayName("Should delete a band")
    void shouldDeleteABand() {
        Integer bandID = 10;
        Band band = new Band(bandID, "Whatever", 25, "Whatever", "Whatever", "Whatever");
        service.addBand(band);
        service.deleteBandByBandID(bandID);
        Optional<Band> deletedBand = this.service.getBandByBandID(bandID);
        assertEquals(deletedBand.isEmpty(), true);
    }

    @Test
    @DisplayName("Should throw an exception if band was not updated")
    void shouldThrowAnExceptionIfBandWasNotUpdated() {
        Band band = new Band(2, "Whateva", 33, "Whateva",
                "Whateva","Whateva");
        assertThrows(IllegalArgumentException.class, () -> service.updateBandByBandID(band));
    }

    @Test
    @DisplayName("Should update a band by bandID")
    void shouldUpdateABandByBandID() {
        Integer bandID = 2;
        Band band = new Band(bandID, "Whateva", 33, "Whateva",
                "Whateva","Whateva");
        service.updateBandByBandID(band);
    }
}