package com.bug.free.invention.api.controllers;

import java.sql.SQLException;

public interface BandRepository {

    Band getLevelById(int bandId) throws SQLException;

    Band getLevelByName(String bandName) throws SQLException;



}
