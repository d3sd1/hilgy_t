package com.agile.agileback.controller;

import com.agile.agileback.model.Investor;
import com.agile.agileback.repository.InvestorRepository;
import com.agile.agileback.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired
    InvestorRepository repo;

    @GetMapping("")
    public ResponseEntity<List<Investor>> getAll() {
        return new ResponseEntity<>(this.repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor> getById(@PathVariable("id") long id) {
        Optional<Investor> d = repo.findById(id);
        return d.map(Investor -> new ResponseEntity<>(Investor, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Investor> create(@RequestBody Investor s) {
        try {
            Investor _tutorial = repo.save(s);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investor> updateTutorial(@PathVariable("id") long id, @RequestBody Investor t) {
        Optional<Investor> d = repo.findById(id);

        if (d.isPresent()) {
            return new ResponseEntity<>(repo.save(t), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
