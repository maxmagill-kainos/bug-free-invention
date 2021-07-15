package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.Models.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//This file doesn't really seem to be needed but I will leave it in for now
@RestController
@RequestMapping("/api/jobs-roles")
public class US001 {

    @GetMapping("/job-roles")
    public List<Job> getJobRoles(){
        JobController newJobController = new JobController();
        return newJobController.getJobRoles();
    }
}
