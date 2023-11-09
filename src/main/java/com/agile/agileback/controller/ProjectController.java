package com.agile.agileback.controller;

import com.agile.agileback.model.Project;
import com.agile.agileback.repository.ProjectRepository;
import com.agile.agileback.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository repo;

    @GetMapping("")
    public ResponseEntity<List<Project>> getAll() {
        return new ResponseEntity<>(this.repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") long id) {
        Optional<Project> d = repo.findById(id);
        return d.map(Project -> new ResponseEntity<>(Project, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Project> create(@RequestBody Project s) {
        try {
            Project _tutorial = repo.save(s);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateTutorial(@PathVariable("id") long id, @RequestBody Project t) {
        Optional<Project> d = repo.findById(id);

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
