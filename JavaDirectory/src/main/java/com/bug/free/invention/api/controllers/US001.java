package com.bug.free.invention.api.controllers;

import com.bug.free.invention.api.classes.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs-roles")
public class US001 {

    @GetMapping("/job-roles")
    public List<Job> getJobRoles(){
        US002 newUs002 = new US002();
        return newUs002.getJobRoles();
    }
}
