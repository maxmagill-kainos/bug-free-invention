package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public interface BandRepository extends JpaRepository<Band, Integer> {

    List<Band> findAll();



//    @Query("Select Band_Level from Band WHERE Band_ID = ?1")
//    Optional<Integer> findByBand__ID(int bandId) throws SQLException;

//    List<Band> getLevelByName(String bandName) throws SQLException;

//    class BandByIdUseCase {
//        int bandId;
//        int bandLevel;
//    }
//
//    class BandByNameUseCase {
//        String bandName;
//        int bandLevel;
//    }



}
