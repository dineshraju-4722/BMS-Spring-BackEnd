package com.FullStack.BMS.Dto;

import java.time.LocalDate;
import java.util.List;

public class PostMovieDto {
	public PostMovieDto() {
		super();
	}

	public PostMovieDto(String title, String poster, LocalDate releasedate, String censor, int duration, int votes,
			double rating, List<Integer> languages,List<Integer> types,List<Integer> genres) {
		super();
		this.title = title;
		this.poster = poster;
		this.releasedate = releasedate;
		this.censor = censor;
		this.duration = duration;
		this.votes = votes;
		this.rating = rating;
		this.languages = languages;
		this.types=types;
		this.genres=genres;
	}

	private String title;

	private String poster;

	private LocalDate releasedate;

	private String censor;

	private int duration;

	private int votes;

	private double rating;

	private List<Integer> languages;

	private List<Integer> types;
	
	private List<Integer> genres;

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

	public List<Integer> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Integer> languages) {
		this.languages = languages;
	}

	public List<Integer> getTypes() {
		return types;
	}

	public void setTypes(List<Integer> types) {
		this.types = types;
	}

	public List<Integer> getGenres() {
		return genres;
	}

	public void setGenres(List<Integer> genres) {
		this.genres = genres;
	}
}
