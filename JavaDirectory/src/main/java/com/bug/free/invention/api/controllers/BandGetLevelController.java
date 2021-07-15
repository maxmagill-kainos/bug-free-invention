package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Services.BandLevelService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
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

//    @GetMapping("/id")
//    public ResponseEntity<?> getBandLevelById(@RequestParam int bandID) throws SQLException {
//        return service.
//                getBandLevelByBandID(bandID)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
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


