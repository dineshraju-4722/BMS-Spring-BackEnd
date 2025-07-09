package com.FullStack.BMS.Dto;

import java.sql.Date;

public class JoinsDto {

	private int id;


	public JoinsDto(int id,String title, String poster, double rating, Date releasedate, int votes, int duration,
			String censor) {
		super();
		this.id=id;
		this.title = title;
		this.poster = poster;
		this.releasedate = releasedate;
		this.censor = censor;
		this.duration = duration;
		this.votes = votes;
		this.rating = rating;
	}
	private String title;

	private String poster;

	private Date releasedate;

	private String censor;

	private int duration;

	private int votes;

	private double rating;


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

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}


