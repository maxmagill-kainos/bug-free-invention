package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(value = BandGetLevelController.class)
@ActiveProfiles("test")
class BandGetLevelControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BandGetLevelController bandController;

    @Test
    @DisplayName("Should call service to find all bands")
    void shouldFindAllBands() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bandLevel"));
        verify(bandController, times(1)).findAll();
    }

    @Test
    @DisplayName("Should call service to get bandLevel by bandID")
    void shouldGetBandLevelByBandID() throws Exception {
        Integer bandID = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/bandLevel/getByID/" + bandID));
        verify(bandController, times(1)).getBandLevelByBandID(bandID);
    }

    @Test
    @DisplayName("Should call service to get bandLevel by bandName")
    void shouldGetBandLevelByBandName() throws Exception {
        String bandName = "Apprentice";
        mockMvc.perform(MockMvcRequestBuilders.get("/bandLevel/getByName/" + bandName));
        verify(bandController, times(1)).getBandLevelByBandName(bandName);
    }

    @Test
    @DisplayName("Should call service to add a band")
    void shouldCallServiceToAddABand() throws Exception {
        Integer bandID = 9;
        Band band = new Band(bandID, "Whatever", 45, "Whatever", "Whatever", "Whatever");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(band);
            mockMvc.perform(MockMvcRequestBuilders.post("/bandLevel/addBand").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .content(json)).andReturn();
            verify(bandController, times(1)).addBand(band);
        }

    @Test
    @DisplayName("Should call service to delete band by bandID")
    void shouldCallServiceToDeleteBandByBandID() throws Exception {
        Integer bandID = 9;
        mockMvc.perform(MockMvcRequestBuilders.delete("/bandLevel/deleteBand/" + bandID));
        verify(bandController, times(1)).deleteByBandID(bandID);
    }
    }