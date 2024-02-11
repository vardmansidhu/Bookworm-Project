package com.bookworm.bookworm_middleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookworm.bookworm_middleware.entities.MyShelf;
import com.bookworm.bookworm_middleware.services.IMyShelfManager;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/myshelf")
public class MyShelfController {

    @Autowired
    private IMyShelfManager myShelfService;

    @GetMapping
    public ResponseEntity<List<MyShelf>> getAllMyShelfItems() {
        return ResponseEntity.ok(myShelfService.getAllMyShelfItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyShelf> getMyShelfItemById(@PathVariable Integer id) {
        MyShelf myShelf = myShelfService.getMyShelfItemById(id);
        if (myShelf != null) {
            return ResponseEntity.ok(myShelf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MyShelf> createMyShelfItem(@RequestBody MyShelf myShelf) {
        return ResponseEntity.ok(myShelfService.saveMyShelfItem(myShelf));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<MyShelf> updateMyShelfItem(@PathVariable Integer id, @RequestBody MyShelf myShelf) {
    //     MyShelf existingMyShelf = myShelfService.getMyShelfItemById(id);
    //     if (existingMyShelf != null) {
    //         myShelf.setShelfId(id);
    //         return ResponseEntity.ok(myShelfService.saveMyShelfItem(myShelf));
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyShelfItem(@PathVariable Integer id) {
        MyShelf existingMyShelf = myShelfService.getMyShelfItemById(id);
        if (existingMyShelf != null) {
            myShelfService.deleteMyShelfItem(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}