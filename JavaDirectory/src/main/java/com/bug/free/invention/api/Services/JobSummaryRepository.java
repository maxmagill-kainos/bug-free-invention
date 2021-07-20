package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.jobSummary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSummaryRepository extends CrudRepository<jobSummary,Integer> {
}
