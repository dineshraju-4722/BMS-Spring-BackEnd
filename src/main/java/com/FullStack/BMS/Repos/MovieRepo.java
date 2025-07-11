package com.FullStack.BMS.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FullStack.BMS.Dto.JoinsDto;
import com.FullStack.BMS.Entities.MovieEntity;

public interface MovieRepo extends JpaRepository<MovieEntity, Integer> {
	@Query(value = """
			SELECT m.*
			FROM movies m
			JOIN movie_language ml ON m.id = ml.movieid
			JOIN languages l ON l.id = ml.languageid where language= :language
			""", nativeQuery = true)
	List<JoinsDto> getMovieAndLanguagePairs(@Param("language") String language);
	
	
	MovieEntity findByTitleIgnoreCase(@Param("movie") String movie);
//	@Query(value = """
//			SELECT m.*
//			FROM movies m
//			where
//			""", nativeQuery = true)
//	List<MovieEntity> getMovieAndLocationPairs(@Param("location") String location);
	
//	@Query(value = """
//			select m.* from movies m where m.
//			""");
}
