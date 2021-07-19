package com.bug.free.invention.api.Services;

import com.bug.free.invention.api.Models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}

