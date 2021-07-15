package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.*;
import java.util.*;

@Component
public class BandService {
    @Autowired
    private final BandRepository repository;

    public BandService(BandRepository repository) {
        this.repository = repository;
    }

    public List<band> getAllBands() {
//        List<Band> band = new ArrayList<Band>();
//        repository.findAll().forEach(band1 -> band.add(band1));
//        return band;
        return repository.findAll();
    }

    public Optional<Integer> getBandLevelByBandID(int bandID) throws SQLException {
        return repository.findBandLevelByBandID(bandID);
    }

    public Optional<band> getBandLevelByBandName(String bandName) throws SQLException {
        return repository.findBandLevelByBandName(bandName);
    }

}
