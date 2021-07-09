package com.bug.free.invention.api.Band.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public interface BandRepository extends JpaRepository<Band, Integer> {

    List<Band> findAll();

    Optional<Band> getLevelById(int bandId) throws SQLException;

    List<Band> getLevelByName(String bandName) throws SQLException;

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
