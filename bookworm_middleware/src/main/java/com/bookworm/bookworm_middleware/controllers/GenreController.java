package com.bookworm.bookworm_middleware.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.bookworm_middleware.entities.Genre;
import com.bookworm.bookworm_middleware.entities.Language;
import com.bookworm.bookworm_middleware.services.IGenreManager;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/genre")
public class GenreController {

	@Autowired
	private IGenreManager genreServices;

	@PostMapping("/add")
	public void addGenre(@RequestBody Genre g) {
		System.out.println("inside the mtd");
		genreServices.addGenre(g);
	}

	@GetMapping("/get")
	public List<Genre> getGenres() {
		return genreServices.getGenres();
	}

	@GetMapping("/getById/{id}")
	public Optional<Genre> getGenreById(@PathVariable Integer id) {
		return genreServices.getGenre(id);
	}

	@GetMapping("/getByName/{name}")
	public Optional<Genre> getGenreByName(@PathVariable String name) {
		return genreServices.getGenreByName(name);
	}

	@GetMapping("/getByLanguageId/{id}")
	public List<Genre> getGenreByName(@PathVariable int id) {
		return genreServices.getGenreByLanguageId(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteGenre(@PathVariable Integer id) {
		genreServices.deleteGenre(id);
	}

	@PutMapping("/update/{id}")
	public void updateGenre(@RequestBody Genre genre, @PathVariable Integer id) {
		System.out.println("in the update mtd");
		genreServices.updateGenre(genre, id);
	}

}
