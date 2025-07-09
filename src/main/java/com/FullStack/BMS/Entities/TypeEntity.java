package com.FullStack.BMS.Entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class TypeEntity {

	public TypeEntity() {
		super();
	}

	public TypeEntity(int id, String type, Set<MovieEntity> movies) {
		super();
		this.id = id;
		this.type = type;
		this.movies = movies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@ManyToMany(mappedBy = "movietype")
	@JsonIgnore
	private Set<MovieEntity> movies=new HashSet<MovieEntity>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(Set<MovieEntity> movies) {
		this.movies = movies;
	}
	
}
