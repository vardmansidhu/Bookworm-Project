package com.bookworm.bookworm_middleware.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.entities.Rent;
import com.bookworm.bookworm_middleware.services.IRentManager;

@RestController
@CrossOrigin
@RequestMapping("/api/rent")
public class RentController {

    @Autowired
    private IRentManager rentService;

    @GetMapping("")
    public ResponseEntity<List<Rent>> getAllRents() {
        return ResponseEntity.ok(rentService.getAllRents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable int id) {
        Rent rent = rentService.getRentById(id);
        if (rent != null) {
            return ResponseEntity.ok(rent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        rentService.addRent(rent);
        return ResponseEntity.ok(rent);
    }
}
