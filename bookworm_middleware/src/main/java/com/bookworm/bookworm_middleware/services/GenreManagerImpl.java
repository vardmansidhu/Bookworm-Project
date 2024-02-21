package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.Genre;
import com.bookworm.bookworm_middleware.repositories.IGenreRepository;

@Service
public class GenreManagerImpl implements IGenreManager {

	@Autowired
	private IGenreRepository repository;

	@Override
	public void addGenre(Genre genre) {
		repository.save(genre);

	}

	@Override
	public List<Genre> getGenres() {
		return repository.findAll();
	}

	@Override
	public void deleteGenre(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateGenre(Genre genre, Integer id) {
		repository.update(genre.getGenreDesc(), id);
	}

	@Override
	public Optional<Genre> getGenre(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Genre> getGenreByName(String name) {
		return repository.findByGenreDesc(name);
	}

	@Override
	public List<Genre> getGenreByLanguageId(int id) {
		return repository.findByLanguageId(id);
	}

}
