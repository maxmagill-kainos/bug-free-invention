package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Band;
import com.bug.free.invention.api.Models.capability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Repository
public interface CapabilityRepository extends CrudRepository<capability,Integer> {

    List<capability> findAll();

    //    @Query("SELECT bandLevel from Band WHERE bandID = ?1")
   // Optional<Integer> findcapabilityID(int capabilityID) throws SQLException;

    Optional<capability> findCapabilityNameByCapabilityID(int capabilityID) throws SQLException;


}
