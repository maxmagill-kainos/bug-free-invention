package com.bug.free.invention.api.Services;
import com.bug.free.invention.api.Models.job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<job,Integer> {

}
