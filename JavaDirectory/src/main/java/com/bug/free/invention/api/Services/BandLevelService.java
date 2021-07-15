package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Band> band = new ArrayList<Band>();
        repository.findAll().forEach(band1 -> band.add(band1));
        return band;
    }

    public Optional<Integer> getBandLevelByBandID(Integer bandID) throws SQLException {
        if (bandID == null) {
            throw new IllegalArgumentException("bandID can not be null");
        } else
            return repository.findBandLevelByBandID(bandID)
                    .map(band -> band.getBandLevel());
    }

    public Optional<Integer> getBandLevelByBandName(String bandName) throws SQLException {
        if (bandName == null) {
            throw new IllegalArgumentException("bandName can not be null");
        } else
        return repository.findBandLevelByBandName(bandName)
                .map(band -> band.getBandLevel());
    }


//    public void deleteBandByBandID(int bandID) {
//            repository.deleteBandByBandID(bandID);
//    }
}