package com.bookworm.bookworm_middleware.controllers;

import com.bookworm.bookworm_middleware.entities.MyLibrary;
import com.bookworm.bookworm_middleware.services.MyLibraryServiceImpl;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mylibrary")
public class MyLibraryController {

    private final MyLibraryServiceImpl myLibraryService;

    @Autowired
    public MyLibraryController(MyLibraryServiceImpl myLibraryService) {
        this.myLibraryService = myLibraryService;
    }

    @PostMapping("/add")
    public ResponseEntity<MyLibrary> addToMyLibrary(@RequestBody MyLibrary myLibrary) {
        MyLibrary addedLibrary = myLibraryService.addToMyLibrary(myLibrary);
        if (addedLibrary != null) {
            return new ResponseEntity<>(addedLibrary, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getByType/{transactionType}")
    public List<MyLibrary> getByType(@PathVariable int transactionType) {
        return myLibraryService.getByType(transactionType);
    }

}
