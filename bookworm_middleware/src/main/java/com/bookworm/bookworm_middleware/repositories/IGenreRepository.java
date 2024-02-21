package com.bookworm.bookworm_middleware.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Genre;

import jakarta.transaction.Transactional;
import java.util.List;
import com.bookworm.bookworm_middleware.entities.Language;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {

	@Transactional
	@Modifying
	@Query("update Genre g set g.genreDesc = :genredesc WHERE g.genreId = :genreid")
	void update(@Param("genredesc") String genreDesc, @Param("genreid") Integer id);

	@Query("select g from Genre g where g.genreDesc = :genredesc ")
	Optional<Genre> findByGenreDesc(@Param("genredesc") String genreDesc);

	@Query("select g from Genre g where g.languageId.languageId = :languageId ")
	List<Genre> findByLanguageId(int languageId);
}
