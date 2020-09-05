package com.romans.Logic;

import com.romans.Models.Emperor;
import com.romans.Repositories.RRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RService {

    private final RRepository rRepository;

    public RService(RRepository rRepository) {
        this.rRepository = rRepository;
    }

    public ResponseEntity<List<Emperor>> findAll() {
        List<Emperor> emperorSet = rRepository.findAll();
        return new ResponseEntity<>(emperorSet, HttpStatus.OK);
    }

    public ResponseEntity<Emperor> findEmperorById(String id) {
        Optional<Emperor> optionalEmperor = rRepository.findBy_id(id);
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
}
