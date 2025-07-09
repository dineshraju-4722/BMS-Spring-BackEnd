package com.FullStack.BMS.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Theatres")
public class TheatresEntity {
	public TheatresEntity() {
		super();
	}

	public TheatresEntity(int id, String name, int rows, int columns, int totalseats, LocationsEntity location) {
		super();
		this.id = id;
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.totalseats = totalseats;
		this.location = location;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int rows;
	private int columns; 
	private int totalseats;
	@ManyToOne
	@JoinColumn(name="location")
	private LocationsEntity location;

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

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public LocationsEntity getLocation() {
		return location;
	}

	public void setLocation(LocationsEntity location) {
		this.location = location;
	}
}
