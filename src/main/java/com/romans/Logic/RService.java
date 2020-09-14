package com.romans.Logic;

import com.romans.Model.Emperor;
import com.romans.Repository.RRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RService {

    private final RRepository rRepository;

    @Autowired
    public RService(RRepository rRepository) {
        this.rRepository = rRepository;
    }

    private void dataFiller() {
        Emperor caesar = new Emperor();
        Emperor nero = new Emperor();
        caesar.setName("Gaius Julius Caesar");
        nero.setName("Nero Claudius Cæsar Augustus Germanicus");
        caesar.setDateOfBirth(LocalDate.of(-99, 8, 12));
        nero.setDateOfBirth(LocalDate.of(38, 1, 15));
        caesar.setId(UUID.randomUUID().toString());
        nero.setId(UUID.randomUUID().toString());
        rRepository.save(caesar);
        rRepository.save(nero);

        Emperor caesar2 = new Emperor();
        Emperor nero2 = new Emperor();
        caesar2.setName("Gaius Julius Caesar 2");
        nero2.setName("Nero Claudius Cæsar Augustus Germanicus 2");
        caesar2.setDateOfBirth(LocalDate.of(-99, 8, 12));
        nero2.setDateOfBirth(LocalDate.of(38, 1, 15));
        caesar2.setId(UUID.randomUUID().toString());
        nero2.setId(UUID.randomUUID().toString());
        rRepository.save(caesar2);
        rRepository.save(nero2);
    }

    public ResponseEntity<List<Emperor>> findAll() {
        // dataFiller();
        List<Emperor> emperorSet = rRepository.findAll();
        return new ResponseEntity<>(emperorSet, HttpStatus.OK);
    }

    public ResponseEntity<Emperor> findEmperorById(String id) {
        Optional<Emperor> optionalEmperor = rRepository.findById(id);
        return optionalEmperor
                .map(emperor -> new ResponseEntity<>(emperor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Emperor> findEmperorByName(String name) {
        Optional<Emperor> optionalEmperor = rRepository.findByName(name);
        return optionalEmperor
                .map(emperor -> new ResponseEntity<>(emperor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<Emperor>> getEmperorAttribute(String operation) {
        List<Emperor> emperorList = switch (operation) {
            // Date comparisons
            case "earliestDateOfBirth" -> rRepository.earliestDateOfBirth();
            case "latestDateOfBirth" -> rRepository.latestDateOfBirth();
            case "shortestLife" -> rRepository.shortestLife();
            case "longestLife" -> rRepository.longestLife();
            case "shortestReign" -> rRepository.shortestReign();
            case "longestReign" -> rRepository.longestReign();
//            // People counting
//            case "leastWives" -> rRepository.leastWives();
//            case "mostWives" -> rRepository.mostWives();
//            case "leastChildren" -> rRepository.leastChildren();
//            case "mostChildren" -> rRepository.mostChildren();
//            case "smallestArmy" -> rRepository.smallestArmy();
//            case "biggestArmy" -> rRepository.biggestArmy();
//            // Other
//            case "quotes" -> rRepository.quoteNumber();
//            case "territoryTaken" -> rRepository.territoryTaken();
//            case "territoryLost" -> rRepository.territoryLost();
            default -> null;
        };

        if (emperorList != null) {
            return new ResponseEntity<>(emperorList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
