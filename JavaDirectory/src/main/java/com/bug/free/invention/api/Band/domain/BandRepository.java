package com.bug.free.invention.api.Band.domain;

import java.sql.SQLException;
import java.util.List;

public interface BandRepository {

    List<Band> findAll();

    Band getLevelById(int bandId) throws SQLException;

    Band getLevelByName(String bandName) throws SQLException;

    class BandByIdUseCase {
        int bandId;
        int bandLevel;
    }

    class BandByNameUseCase {
        String bandName;
        int bandLevel;
    }



}
