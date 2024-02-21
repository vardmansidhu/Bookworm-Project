package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Genre;

public interface IGenreManager {
	void addGenre(Genre genre);

	List<Genre> getGenres();

	void deleteGenre(Integer id);

	void updateGenre(Genre genre, Integer id);

	Optional<Genre> getGenre(Integer id);

	Optional<Genre> getGenreByName(String name);

	List<Genre> getGenreByLanguageId(int id);

}
