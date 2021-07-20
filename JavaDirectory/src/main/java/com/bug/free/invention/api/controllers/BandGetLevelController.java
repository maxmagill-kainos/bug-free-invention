package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Services.BandLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/ID/{bandID}")
    public Optional<Band> getBandByBandID(@PathVariable("bandID") Integer bandID) {
        return service.getBandByBandID(bandID);
    }

    @GetMapping("/getByID/{bandID}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getBandLevelByBandID(@PathVariable("bandID") Integer bandID) throws SQLException {
        return service.getBandLevelByBandID(bandID).get();
    }

    @GetMapping("/getByName/{bandName}")
    public Integer getBandLevelByBandName(@PathVariable("bandName") String bandName) throws SQLException {
        return service.getBandLevelByBandName(bandName).get();
    }

    @DeleteMapping("/deleteBand/{bandID}")
    public void deleteByBandID(@PathVariable("bandID") Integer bandID) {
        service.deleteBandByBandID(bandID);
    }

    @PostMapping(value = "/addBand", consumes = "application/json", produces = "application/json")
    public void addBand(@RequestBody Band band) {
        service.addBand(band);
    }
}


