package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.controllers.DBConfig;
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

    public Optional<Band> getBandByBandID(Integer bandID) {
        return repository.findById(bandID);
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

    public void deleteBandByBandID(Integer bandID) {
        try (Connection connect = DBConfig.getConnection()) {
            PreparedStatement statement = connect.prepareStatement("DELETE from band where bandID = ?");
            statement.setInt(1, bandID);

            int howManyObjAffected = statement.executeUpdate();
            if (howManyObjAffected == 0) {
                throw new IllegalArgumentException("Obj with this bandID doesn't exist");
            }
            } catch (SQLException e) {
                throw new IllegalArgumentException("Obj wasn't deleted from db");
            }
    }

    public void addBand(Band band) {
        try (Connection connect = DBConfig.getConnection()) {
            PreparedStatement statement = connect.prepareStatement(
                    "INSERT into band (bandID, bandName, bandLevel, bandTraining, bandCompetencies, bandResponsibilites) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, band.getBandID());
            statement.setString(2, band.getBandName());
            statement.setInt(3, band.getBandLevel());
            statement.setString(4, band.getBandTraining());
            statement.setString(5, band.getBandCompetencies());
            statement.setString(6, band.getBandResponsibilites());
            int howManyObjAffected = statement.executeUpdate();
            if (howManyObjAffected == 0) {
                throw new IllegalArgumentException("Band wasn't inserted into db");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Unable to connect to database", e);
        }
    }
}