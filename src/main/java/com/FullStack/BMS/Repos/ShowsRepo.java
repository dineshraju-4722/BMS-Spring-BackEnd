package com.FullStack.BMS.Repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FullStack.BMS.Entities.ShowsEntity;

public interface ShowsRepo extends JpaRepository<ShowsEntity, Integer>{
@Query(value = """
		select s.id, s.name, s.language, s.time, s.date, s.movie, s.theatre from shows s join theatres t on s.theatre=t.id join locations l on t.location=l.id where l.location ilike :location and s.date >= :date;
		""",nativeQuery = true)
	List<ShowsEntity> getShowsByLocationsAndDate(@Param("location") String location,@Param("date") Date date);
	
}
