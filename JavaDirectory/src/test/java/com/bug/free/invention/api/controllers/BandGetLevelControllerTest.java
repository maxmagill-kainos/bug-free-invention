package com.bug.free.invention.api.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

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
        String bandName = "Appreciate";
        mockMvc.perform(MockMvcRequestBuilders.get("/bandLevel/getByName/" + bandName));
        verify(bandController, times(1)).getBandLevelByBandName(bandName);
    }
}