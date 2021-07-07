package com.bug.free.invention.api.db;

import com.bug.free.invention.api.models.Capabilities;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Mapper {

    @Select("SELECT * FROM Capability")
    List<Capabilities> getCapabilities();

}
