package com.bug.free.invention.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class US004 implements BandRepository {

    private final String conn;

    public US004(String conn) {
        this.conn = conn;
    }

    @GetMapping("/bandLevel/id")
    public Band getLevelById(int bandId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(conn)) {
            PreparedStatement statement = connection.prepareStatement("Select * from Band where id = ?");
            statement.setInt(1, bandId);
            ResultSet resultSet = statement.executeQuery();
            Collection<Band> phonesFromResultSet = getBandFromResultSet(resultSet);
            return phonesFromResultSet.iterator().next();
        } catch (SQLException e) {
            throw new SQLException("Band by bandId not found");
        }
    }

    @GetMapping("/bandLevel/name")
    public Band getLevelByName(String bandName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(conn)) {
            PreparedStatement statement = connection.prepareStatement("Select * from Band where id = ?");
            statement.setString(2, bandName);
            ResultSet resultSet = statement.executeQuery();
            Collection<Band> phonesFromResultSet = getBandFromResultSet(resultSet);
            return phonesFromResultSet.iterator().next();
        } catch (SQLException e) {
            throw new SQLException("Band by bandName not found");
        }
    }

    private static Collection<Band> getBandFromResultSet(ResultSet resultSet) throws SQLException {
        List<Band> result = new LinkedList<>();
        while(resultSet.next()) {
            int id = resultSet.getInt("Band_ID");
            String bandName = resultSet.getString("Band_Name");
            int bandLevel = resultSet.getInt("Band_Level");
            String bandTraining  = resultSet.getString("Band_Training");
            String bandCompetencies = resultSet.getString("Band_Competencies");
            String bandResponsibilities = resultSet.getString("Band_Responsibilites");
            result.add(new Band(id, bandName, bandLevel, bandTraining, bandCompetencies, bandResponsibilities));
        }
        return result;
    }
}
