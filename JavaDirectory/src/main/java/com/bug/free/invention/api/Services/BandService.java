package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BandService {
    @Autowired
    private final BandRepository repository;

    public BandService(BandRepository repository) {
        this.repository = repository;
    }

    public List<Band> getAllBands() {
        return (List<Band>) repository.findAll();
    }

    public Optional<Integer> getBandLevelByBandID(int bandID) throws SQLException {
        return repository.findBandLevelByBandID(bandID);
    }

    public Optional<Band> getBandLevelByBandName(String bandName) throws SQLException {
        return repository.findBandLevelByBandName(bandName);
    }

}
