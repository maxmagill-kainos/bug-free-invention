package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class BandLevelService {
    private final BandRepository repository;

    public BandLevelService(BandRepository repository) {
        this.repository = repository;
    }

    public List<Band> getAllBands() {
//        List<Band> band = new ArrayList<Band>();
//        repository.findAll().forEach(band1 -> band.add(band1));
//        return band;
        return repository.findAll();
    }

    public Optional<Integer> getBandLevelByBandID(int bandID) throws SQLException {
        return repository.findBandLevelByBandID(bandID);
    }

    public Optional<Band> getBandLevelByBandName(String bandName) throws SQLException {
        return repository.findBandLevelByBandName(bandName);
    }

}
