package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.*;
import java.util.*;

@Component
public class BandService {
    @Autowired
    private final BandRepository repository;
    @Autowired
    private final EmployeeService employeeService;

    public BandService(BandRepository repository, EmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
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

}
