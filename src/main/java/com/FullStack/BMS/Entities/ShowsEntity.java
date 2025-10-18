package com.FullStack.BMS.Entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "shows", uniqueConstraints = @UniqueConstraint(columnNames = { "date", "time", "theatre" }))
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShowsEntity {
	

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "show_seats", joinColumns = @JoinColumn(name = "show_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "seat_id", referencedColumnName = "id"))
	@JsonManagedReference
	private Set<Seats> seats;
}