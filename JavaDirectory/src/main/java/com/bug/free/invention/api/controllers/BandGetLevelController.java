package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Services.BandLevelService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/bandLevel")
public class BandGetLevelController {

    private final BandLevelService service;

    public BandGetLevelController(BandLevelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Band> findAll() {
        return service.getAllBands();
    }

    @GetMapping("/{id}")
    public Integer getBandLevelByBandID(@PathVariable int bandID) throws SQLException {
        return service.getBandLevelByBandID(bandID).get();
    }

    }


