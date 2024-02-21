package com.bookworm.bookworm_middleware.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookworm.bookworm_middleware.entities.Language;
import com.bookworm.bookworm_middleware.services.ILanguageManager;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@CrossOrigin("*")
public class LanguageController {

    @Autowired
    private ILanguageManager languageService;

    @GetMapping("/get")
    public ResponseEntity<List<Language>> getAllLanguages() {
        return new ResponseEntity<>(languageService.getAllLanguages(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int id) {
        Language language = languageService.getLanguageById(id);
        if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByTypeId/{typeId}")
    public ResponseEntity<List<Language>> getLanguageByTypeId(@PathVariable int typeId) {
        List<Language> languages = languageService.getLanguageDescByTypeId(typeId);
        if (languages != null) {
            return new ResponseEntity<>(languages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Language> saveLanguage(@RequestBody Language language) {
        return new ResponseEntity<>(languageService.saveLanguage(language), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable int id) {
        languageService.deleteLanguage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}