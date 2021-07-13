package com.bug.free.invention.api.Band.bandController;

import com.bug.free.invention.api.Band.bandService.GetBandLevelService;
import com.bug.free.invention.api.Band.domain.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bandLevel")
public class BandGetLevelController {
    @Autowired
    private final GetBandLevelService service;

    public BandGetLevelController(GetBandLevelService service) {
        this.service = service;
    }


    @GetMapping
    public Object findAll(@RequestParam Optional<Integer> bandId,
                          @RequestParam Optional<String> bandName) throws SQLException {
        if (bandId.isPresent()) {
            return service.getLevelById(bandId.get());
        } else if (bandName.isPresent()) {
            return service.getLevelByName(bandName.get());
        } else {
            return service.findAll();
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getBandLevelById(@RequestParam int bandId) throws SQLException {
        return service.
                getLevelById(bandId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name")
    public ResponseEntity<?> getBandLevelByName(@RequestParam String bandName) throws SQLException {
        List<Band> bands = service.getLevelByName(bandName);
        bands.forEach(System.out::println);
        return null;
    }
}
