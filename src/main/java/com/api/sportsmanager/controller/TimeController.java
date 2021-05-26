package com.api.sportsmanager.controller;

import com.api.sportsmanager.entities.Time;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping
    public ResponseEntity<Time> get() {
        // just example (not working)
        // Get time here
        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Time> post(@RequestBody Time time) {
        // just example (not working)
        // Post Time here

        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> put(@PathVariable long id, @RequestBody Time time) {
        // just example (not working)
        // Att Time here
        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        // just example (not working)
        // Delete Time here
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
