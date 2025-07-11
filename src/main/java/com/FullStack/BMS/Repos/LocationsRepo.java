package com.FullStack.BMS.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FullStack.BMS.Entities.LocationsEntity;

public interface LocationsRepo extends JpaRepository<LocationsEntity, Integer> {

	@Query(value = """
						select  l.language,array_agg(m.title)    from languages l join movie_language ml on l.id=ml.languageid join movies m on m.id=ml.movieid group by l.language ;
			""",nativeQuery = true)
	List<Object[]> getMoviesByLanguages();
}
