package com.bug.free.invention.api.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/demo")
public class PostRoutesDemo {

    @PostMapping(value = "/createEmployee", consumes = "application/json", produces = "application/json")
    public void createEmployee(@RequestBody Employee Employee) {
        System.out.println(Employee);
    }


}
