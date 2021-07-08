package com.bug.free.invention.api.Band.bandController;

import com.bug.free.invention.api.Band.domain.Band;
import com.bug.free.invention.api.Band.domain.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/bandLevel")
public class BandGetLevelController {

    @Autowired
    private final BandRepository repository;

    public BandGetLevelController(BandRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Band> findAll() {
        return repository.findAll();
    }

    @GetMapping("/id")
    public Band getBandLevelById(@RequestParam int bandId) throws SQLException {
        return repository.getLevelById(bandId);
    }

    @GetMapping("/name")
    public Band getBandLevelById(@RequestParam String bandName) throws SQLException {
        return repository.getLevelByName(bandName);
    }
}
