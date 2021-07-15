package com.bug.free.invention.api.Services;
import com.bug.free.invention.api.Models.Job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Integer> {

}
