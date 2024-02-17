package com.bookworm.bookworm_middleware.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private int genreId;

	@Column(name = "genre_desc")
	private String genreDesc;

//	many Genere entities can be associated with one Language entity.
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
	@JoinColumn(name = "language_id")
	private Language languageId;

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreDesc() {
		return genreDesc;
	}

	public void setGenreDesc(String genreDesc) {
		this.genreDesc = genreDesc;
	}

	public Language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Language languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreDesc=" + genreDesc + ", languageId=" +  "]";
	}

}
