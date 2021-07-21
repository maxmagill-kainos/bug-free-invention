package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.jobFamily;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobFamilyRepository extends CrudRepository<jobFamily,Integer> {
}
