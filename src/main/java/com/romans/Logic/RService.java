package com.romans.Logic;

import com.romans.Model.Emperor;
import com.romans.Repository.EmperorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RService {

    private final EmperorRepository emperorRepository;

    @Autowired
    public RService(EmperorRepository emperorRepository) {
        this.emperorRepository = emperorRepository;
    }

    public ResponseEntity<List<Emperor>> findAll() {
        List<Emperor> emperorList = emperorRepository.findAll();
        return new ResponseEntity<>(emperorList, HttpStatus.OK);
    }

    public ResponseEntity<Emperor> findEmperorById(String id) {
        Optional<Emperor> optionalEmperor = emperorRepository.findById(id);
        return optionalEmperor
                .map(emperor -> new ResponseEntity<>(emperor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Emperor> findEmperorByName(String name) {
        Optional<Emperor> optionalEmperor = emperorRepository.findByName(name);
        return optionalEmperor
                .map(emperor -> new ResponseEntity<>(emperor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<Emperor>> getEmperorAttribute(String operation) {
        List<Emperor> emperorList = switch (operation) {
            // Date comparisons
            case "earliestDateOfBirth" -> emperorRepository.earliestDateOfBirth();
            case "latestDateOfBirth" -> emperorRepository.latestDateOfBirth();
            case "shortestLife" -> emperorRepository.shortestLife();
            case "longestLife" -> emperorRepository.longestLife();
            case "shortestReign" -> emperorRepository.shortestReign();
            case "longestReign" -> emperorRepository.longestReign();
            // Person counting
            case "noWives" -> emperorRepository.noWives();
            case "leastWives" -> emperorRepository.leastWives();
            case "mostWives" -> emperorRepository.mostWives();
            case "noChildren" -> emperorRepository.noChildren();
            case "leastChildren" -> emperorRepository.leastChildren();
            case "mostChildren" -> emperorRepository.mostChildren();
            // Amount counting
            case "noQuotes" -> emperorRepository.noQuotes();
            case "leastQuotes" -> emperorRepository.leastQuotes();
            case "mostQuotes" -> emperorRepository.mostQuotes();
            case "smallestArmy" -> emperorRepository.smallestArmy();
            case "biggestArmy" -> emperorRepository.biggestArmy();
            default -> null;
        };

        if (emperorList != null) {
            return new ResponseEntity<>(emperorList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
