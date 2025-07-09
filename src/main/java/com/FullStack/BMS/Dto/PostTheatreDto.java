package com.FullStack.BMS.Dto;

import com.FullStack.BMS.Entities.LocationsEntity;


public class PostTheatreDto {
	
	public PostTheatreDto() {
		super();
	}
	public PostTheatreDto(String name, int rows, int columns, int totalseats, int location) {
		super();
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.totalseats = totalseats;
		this.location = location;
	}
	private String name;
	private int rows;
	private int columns;
	private int totalseats;
	private int location;
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
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
}
