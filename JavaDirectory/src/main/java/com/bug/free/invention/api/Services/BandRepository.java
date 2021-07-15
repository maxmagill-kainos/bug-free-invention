package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.band;
import org.springframework.data.repository.CrudRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface BandRepository extends CrudRepository<band, Integer> {

    List<band> findAll();

//    @Query("SELECT bandLevel from Band WHERE bandID = ?1")
    Optional<Integer> findBandLevelByBandID(int bandID) throws SQLException;

    Optional<band> findBandLevelByBandName(String bandName) throws SQLException;

}
