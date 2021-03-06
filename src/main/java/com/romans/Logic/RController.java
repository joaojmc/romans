package com.romans.Logic;

import com.romans.Model.Emperor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RController {

    private final RService rService;

    @Autowired
    public RController(RService rService) {
        this.rService = rService;
    }

    @GetMapping("/emperors/")
    public ResponseEntity<List<Emperor>> getEmperors() {
        return rService.findAll();
    }

    @GetMapping("/emperor/{id}")
    public ResponseEntity<Emperor> getEmperorById(@PathVariable String id) {
        return rService.findEmperorById(id);
    }

    @GetMapping("/emperor/")
    public ResponseEntity<Emperor> getEmperorByName(@RequestParam String name) {
        return rService.findEmperorByName(name);
    }

    @GetMapping("/emperor/operation/{operation}")
    public ResponseEntity<List<Emperor>> getEmperorAttribute(@PathVariable String operation) {
        return rService.getEmperorAttribute(operation);
    }
}
