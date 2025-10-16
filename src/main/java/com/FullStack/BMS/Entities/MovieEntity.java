package com.FullStack.BMS.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
	public MovieEntity() {
		super();
	}

	public MovieEntity(int id, String title, String poster, LocalDate releasedate, String censor, int duration,
			int votes, double rating, Set<LanguageEntity> movielang, Set<TypeEntity> movietype,Set<GenreEntity> moviegenre,List<ShowsEntity> shows) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.releasedate = releasedate;
		this.censor = censor;
		this.duration = duration;
		this.votes = votes;
		this.rating = rating;
		this.movielang = movielang;
		this.movietype = movietype;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String poster;

	private LocalDate releasedate;

	private String censor;

	private int duration;

	private int votes;

	private double rating;

	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "languageid"))
	private Set<LanguageEntity> movielang = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "movie_type", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "typeid"))
	private Set<TypeEntity> movietype = new HashSet<TypeEntity>();
	
	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
	private Set<GenreEntity> moviegenre = new HashSet<GenreEntity>();

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShowsEntity> shows=new ArrayList<ShowsEntity>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public LocalDate getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}

	public String getCensor() {
		return censor;
	}

	public void setCensor(String censor) {
		this.censor = censor;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Set<LanguageEntity> getMovielang() {
		return movielang;
	}

	public void setMovielang(Set<LanguageEntity> movielang) {
		this.movielang = movielang;
	}

	public Set<TypeEntity> getMovietype() {
		return movietype;
	}

	public void setMovietype(Set<TypeEntity> movietype) {
		this.movietype = movietype;
	}

	public Set<GenreEntity> getMoviegenre() {
		return moviegenre;
	}

	public void setMoviegenre(Set<GenreEntity> moviegenre) {
		this.moviegenre = moviegenre;
	}

	public List<ShowsEntity> getShows() {
		return shows;
	}

	public void setShows(List<ShowsEntity> shows) {
		this.shows = shows;
	}
}
