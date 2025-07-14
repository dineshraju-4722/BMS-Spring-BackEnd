package com.FullStack.BMS.Repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FullStack.BMS.Entities.ShowsEntity;

public interface ShowsRepo extends JpaRepository<ShowsEntity, Integer> {
	@Query(value = """
			select s.id, s.name, s.language, s.time, s.date, s.movie, s.theatre from shows s join theatres t on s.theatre=t.id join locations l on t.location=l.id where l.location ilike :location and s.date >= current_date;
			""", nativeQuery = true)
	List<ShowsEntity> getShowsByLocationsAndDate(@Param("location") String location);
	
	
	@Query(value = """
		    SELECT coalesce(json_object_agg(sub.name, sub.shows_array),'{}'::json)
		    FROM (
		      SELECT t.name, json_agg(row_to_json(s)) AS shows_array
		      FROM shows s
		      JOIN theatres t ON s.theatre = t.id
		      join movies m on s.movie=m.id 
		      join locations l on t.location=l.id
		      where m.title ilike :movie and l.location ilike :location and s.date=:date
		      GROUP BY t.name
		    ) sub;
		    """, nativeQuery = true)
	String getShowsWithTheatresAndLocations(@Param("location") String location,@Param("movie") String movie,@Param("date") Date date);
}
