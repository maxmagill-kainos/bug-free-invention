package com.bug.free.invention.api.controllers;
import com.bug.free.invention.api.Models.Employee;
import com.bug.free.invention.api.Models.BandD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/demo")
public class apiRoutesDemo {

        @GetMapping("/hello-world")
        public ResponseEntity<String> get(){
            return ResponseEntity.ok("Hello World");
        }

        @GetMapping("/JSONDemo")
        public ArrayList<Employee> demoJson(){
            ArrayList<Employee> returnList = new ArrayList<>();
            returnList.add(new Employee(1,"name","difjidsfj"));
            returnList.add(new Employee(2,"ijisdfjdsif","dsuifjhduisfhui"));
            return returnList;
        }

    @GetMapping("/hello-fromc")
    public ResponseEntity<String> getFromC(){
        return ResponseEntity.ok("Hello from c");
    }

    @GetMapping("/bands")
    public ArrayList<BandD> getBandResp(){
            ArrayList<BandD> returnList = new ArrayList<>();
            returnList.add(new BandD(1, "Trainee", 1, "training", "skills etc.","entry level things"));
            return returnList;
    }
}
