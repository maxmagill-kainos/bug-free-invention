package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Services.BandLevelService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
//    @GetMapping("/id")
//    public ResponseEntity<?> getBandLevelById(@RequestParam int bandID) throws SQLException {
//        return service.
//                getLevelById(bandID)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/BandDemo")
    public List<Band> getJobRoles() {
        try {
            List<Band> Bands = StreamSupport.stream(service.getAllBands().spliterator(),false).collect(Collectors.toList());
            return  Bands;

        } catch (Exception e) {
            List<Band> Bands = new ArrayList<Band>();
            e.printStackTrace();
            return Bands;
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
