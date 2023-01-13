package com.rodtaylor02.full_stack_tdd.controllers;

import com.rodtaylor02.full_stack_tdd.data.Destination;
import com.rodtaylor02.full_stack_tdd.data.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    DestinationRepository destinationRepository;

    @GetMapping(produces = {"application/xml", "application/json"})
    public ResponseEntity<Iterable<Destination>> getAll() {
        return ResponseEntity.ok().body(destinationRepository.findAll());
    }
}
