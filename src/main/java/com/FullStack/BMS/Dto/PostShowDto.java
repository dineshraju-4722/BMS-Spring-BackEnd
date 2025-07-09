package com.FullStack.BMS.Dto;

import java.sql.Date;
import java.sql.Time;


public class PostShowDto {
	public PostShowDto() {
		super();
	}

	public PostShowDto(String name, String language, Time time, Date date, int theatre, int movie) {
		super();
		this.name = name;
		this.language = language;
		this.time = time;
		this.date = date;
		this.theatre = theatre;
		this.movie = movie;
	}

	private String name;
	private String language;
	private Time time;
	private Date date;

	private int theatre;

	private int movie;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public int getMovie() {
		return movie;
	}

	public void setMovie(int movie) {
		this.movie = movie;
	}

	public int getTheatre() {
		return theatre;
	}

	public void setTheatre(int theatre) {
		this.theatre = theatre;
	}

}
