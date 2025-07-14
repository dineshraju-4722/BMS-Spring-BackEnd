package com.FullStack.BMS.Dto;

import java.sql.Date;
import java.sql.Time;

public class ShowsBytheatreAndLocation {
	    private int id;
	    private Date date;
	    private String name;
	    private String language;
	    private Time time;
	    private int movie;
	    private int theatre;

	    // Default constructor
	    public ShowsBytheatreAndLocation() {
	    }

	    // Parameterized constructor
	    public ShowsBytheatreAndLocation(int id, Date date, String name, String language, Time time, int movie, int theatre) {
	        this.id = id;
	        this.date = date;
	        this.name = name;
	        this.language = language;
	        this.time = time;
	        this.movie = movie;
	        this.theatre = theatre;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

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


