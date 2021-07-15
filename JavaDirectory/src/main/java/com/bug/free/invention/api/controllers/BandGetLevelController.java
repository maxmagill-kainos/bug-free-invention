package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.band;
import com.bug.free.invention.api.Services.BandService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/bandLevel")
public class BandGetLevelController {
    private final BandService service;

    public BandGetLevelController(BandService service) {
        this.service = service;
    }

    @GetMapping
    public List<band> findAll() {
        return service.getAllBands();
    }


    @GetMapping("/{id}")
    public Integer getBandLevelByBandID(@PathVariable int bandID) throws SQLException {
        return service.getBandLevelByBandID(bandID).get();
    }
//    @GetMapping("/id")
//    public ResponseEntity<?> getBandLevelById(@RequestParam int bandID) throws SQLException {
//        return service.
//                getLevelById(bandID)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/BandDemo")
    public List<band> getJobRoles() {
        try {
            List<band> bands = StreamSupport.stream(service.getAllBands().spliterator(),false).collect(Collectors.toList());
            return bands;

        } catch (Exception e) {
            List<band> bands = new ArrayList<band>();
            e.printStackTrace();
            return bands;
        }
    }
//    @GetMapping("/bands")
//    public Object findAll(@RequestParam Optional<Integer> bandID,
//                          @RequestParam Optional<String> bandName) throws SQLException {
//        if (bandID.isPresent()) {
//            return service.getBandLevelByBandID(bandID.get());
//        } else if (bandName.isPresent()) {
//            return service.getBandLevelByBandName(bandName.get());
//        } else {
//            return service.getAllBands();
//        }
//    }

//    @GetMapping("/name")
//    public ResponseEntity<?> getBandLevelByName(@RequestParam String bandName) throws SQLException {
//        List<Band> bands = service.getLevelByName(bandName);
//        bands.forEach(System.out::println);
//        return null;
//    }
    }
