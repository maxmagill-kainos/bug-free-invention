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
    @Autowired
    private final EmployeeService employeeService;

    public BandService(BandRepository repository, EmployeeService employeeService) {
        this.repository = repository;
        this.employeeService = employeeService;
    }

    public List<Band> getAllBands() {
        return (List<Band>) repository.findAll();
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
