package com.FullStack.BMS.Entities;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shows")
public class ShowsEntity {
	public ShowsEntity(int id, String name, String language, Time time, Date date, TheatresEntity thetare,
			MovieEntity movie) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.time = time;
		this.date = date;
		this.thetare = thetare;
		this.movie = movie;
	}

	public ShowsEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String language;
	private Time time;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "theatre", nullable = false)
	private TheatresEntity thetare;

	@ManyToOne
	@JoinColumn(name = "movie", nullable = false)
	private MovieEntity movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public TheatresEntity getThetare() {
		return thetare;
	}

	public void setThetare(TheatresEntity thetare) {
		this.thetare = thetare;
	}

}
