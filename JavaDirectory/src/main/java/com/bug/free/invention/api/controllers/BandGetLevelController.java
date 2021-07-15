package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Services.BandLevelService;
import com.bug.free.invention.api.misc.MyDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/getByID/{bandID}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getBandLevelByBandID(@PathVariable("bandID") Integer bandID) throws SQLException, MyDatabaseException {
        return service.getBandLevelByBandID(bandID).get();
    }

    @GetMapping("/getByName/{bandName}")
    public Integer getBandLevelByBandName(@PathVariable("bandName") String bandName) throws SQLException {
        return service.getBandLevelByBandName(bandName).get();
    }

//    @DeleteMapping("/deleteBand/{bandID}")
//    public void deleteBandByBandID(@PathVariable("bandID") Integer bandID) {
//        service.deleteBandByBandID(bandID);
//    }
}
