package com.bug.free.invention.api.controllers;
import com.bug.free.invention.api.Models.Band;
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



    @GetMapping("/hello-fromc")
    public ResponseEntity<String> getFromC(){
        return ResponseEntity.ok("Hello from c");
    }

    @GetMapping("/bands")
    public ArrayList<Band> getBandResp(){
            ArrayList<Band> returnList = new ArrayList<>();
            returnList.add(new Band(1, "Trainee", 1, "training", "skills etc.","entry level things"));
            return returnList;
    }
}
