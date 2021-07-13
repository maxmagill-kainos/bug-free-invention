package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Models.Job;
import com.bug.free.invention.api.controllers.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GetBandLevelService {
    @Autowired
    private final BandRepository repository;

    public GetBandLevelService(BandRepository repository) {
        this.repository = repository;
    }

    public List<Band> findAll() {
        return (List<Band>) repository.findAll();
    }

//    public Optional<Integer> getLevelById(int bandId) throws SQLException {
//        return repository.findByBand__ID(bandId);
//    }

    @Bean
    CommandLineRunner populateBand() {
        try {
            List<Band> Band = new ArrayList<>();
            List<Band> savedBands = new ArrayList<>();
            Statement statement = DBConfig.getConnection().createStatement();
            //'Job_ID','Capability_ID','Band_ID','Job_Title'
            String dbQuery = "SELECT * FROM `Band` ";
            ResultSet results = statement.executeQuery(dbQuery);
            while (results.next()) {
                Band.add(new Band(results.getInt("Band_ID"), results.getString("Band_Name"), results.getInt("Band_Level"),
                        results.getString("Band_Training"), results.getString("Band_Competencies"),results.getString("Band_Responsibilites")));
            }
            Iterable<Band> itrBands = repository.saveAll(Band);
            itrBands.forEach(savedBands::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return args -> {};
    }

    public Iterable<Band> getJobs(){
        //populateJobRoles();
        return repository.findAll();
    }

    public int GetJobSpecLink(Integer BandID){
        return  repository.findById(BandID).get().getBandLevel();
    }

//    public List<Band> getLevelByName(String bandName) throws SQLException {
//        return repository.findAll()
//                .stream()
//                .filter(band -> band.getBandName().toLowerCase().contains(bandName.toLowerCase()))
//                .collect(Collectors.toList());
//    }

//    private final String conn;
//    public GetBandLevelService(String conn) {
//        this.conn = conn;
//    }

//    public Band getLevelById(int bandId) throws SQLException {
//        try (Connection connection = DriverManager.getConnection(conn)) {
//            PreparedStatement statement = connection.prepareStatement("Select * from Band where id = ?");
//            statement.setInt(1, bandId);
//            ResultSet resultSet = statement.executeQuery();
//            Collection<Band> phonesFromResultSet = getBandFromResultSet(resultSet);
//            return phonesFromResultSet.iterator().next();
//        } catch (SQLException e) {
//            throw new SQLException("Band by bandId not found");
//        }
//    }

//    public Band getLevelByName(String bandName) throws SQLException {
//        try (Connection connection = DriverManager.getConnection(conn)) {
//            PreparedStatement statement = connection.prepareStatement("Select * from Band where id = ?");
//            statement.setString(2, bandName);
//            ResultSet resultSet = statement.executeQuery();
//            Collection<Band> phonesFromResultSet = getBandFromResultSet(resultSet);
//            return phonesFromResultSet.iterator().next();
//        } catch (SQLException e) {
//            throw new SQLException("Band by bandName not found");
//        }
//    }

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
