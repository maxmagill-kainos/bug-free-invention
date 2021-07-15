package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public interface BandRepository extends CrudRepository<Band, Integer> {


      Optional<Integer> findBandLevelByBandID(int bandID) throws SQLException;

      Optional<Band> findBandLevelByBandName(String bandName) throws SQLException;


    

}
