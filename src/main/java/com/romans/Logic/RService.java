package com.romans.Logic;

import com.romans.Model.Emperor;
import com.romans.Model.Person;
import com.romans.Repository.EmperorRepository;
import com.romans.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RService {

    private final EmperorRepository emperorRepository;
    private final PersonRepository personRepository;

    @Autowired
    public RService(EmperorRepository emperorRepository, PersonRepository personRepository) {
        this.emperorRepository = emperorRepository;
        this.personRepository = personRepository;
    }

    private void dataFiller() {
//        Emperor caesar = new Emperor();
//        Emperor nero = new Emperor();
//        caesar.setName("Gaius Julius Caesar");
//        nero.setName("Nero Claudius Cæsar Augustus Germanicus");
//        caesar.setDateOfBirth(LocalDate.of(-99, 8, 12));
//        nero.setDateOfBirth(LocalDate.of(38, 1, 15));
//        caesar.setId(UUID.randomUUID().toString());
//        nero.setId(UUID.randomUUID().toString());
//        emperorRepository.save(caesar);
//        emperorRepository.save(nero);
//        Person cossutia = new Person();
//        cossutia.setName("Cossutia");
//        cossutia.setId(UUID.randomUUID().toString());
//        personRepository.save(cossutia);
//        Optional<Person> caesar = personRepository.findById("343bd04e-f586-47f8-89d4-5d33f864cfd4");
//        List<Person> listOfWives = new ArrayList<>();
//        listOfWives.add(cossutia);
//        caesar.ifPresent(emperor -> emperor.setWives(listOfWives));
//        Person caesarGet = new Person();
//        if (caesar.isPresent()) {
//            caesarGet = caesar.get();
//        }
//        Person julia = new Person();
//        julia.setName("Julia");
//        julia.setId(UUID.randomUUID().toString());
//        personRepository.save(julia);
//        Optional<Person> caesar = personRepository.findById("343bd04e-f586-47f8-89d4-5d33f864cfd4");
//        List<Person> listOfChildren = new ArrayList<>();
//        listOfChildren.add(julia);
//        caesar.ifPresent(emperor -> emperor.setChildren(listOfChildren));
//        Person caesarGet = new Person();
//        if (caesar.isPresent()) {
//            caesarGet = caesar.get();
//        }
//        personRepository.save(caesarGet);
    }

    public ResponseEntity<List<Emperor>> findAll() {
//        dataFiller();
        List<Emperor> emperorSet = emperorRepository.findAll();
        return new ResponseEntity<>(emperorSet, HttpStatus.OK);
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
            // People counting
            case "noWives" -> emperorRepository.noWives();
            case "leastWives" -> emperorRepository.leastWives();
            case "mostWives" -> emperorRepository.mostWives();
            case "noChildren" -> emperorRepository.noChildren();
            case "leastChildren" -> emperorRepository.leastChildren();
            case "mostChildren" -> emperorRepository.mostChildren();
//            case "smallestArmy" -> emperorRepository.smallestArmy();
//            case "biggestArmy" -> emperorRepository.biggestArmy();
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
