package com.api.sportsmanager.controller;

import com.api.sportsmanager.entities.Time;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Time> post() {
        // just example (not working)
        // Post Time here

        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Time> put() {
        // just example (not working)
        // Att Time here
        Time t = new Time();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        // just example (not working)
        // Delete Time here
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
