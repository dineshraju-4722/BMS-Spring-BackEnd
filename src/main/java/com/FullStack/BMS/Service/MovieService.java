package com.FullStack.BMS.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FullStack.BMS.Dto.JoinsDto;
import com.FullStack.BMS.Dto.PostMovieDto;
import com.FullStack.BMS.Entities.GenreEntity;
import com.FullStack.BMS.Entities.LanguageEntity;
import com.FullStack.BMS.Entities.MovieEntity;
import com.FullStack.BMS.Entities.TypeEntity;
import com.FullStack.BMS.Repos.GenreRepo;
import com.FullStack.BMS.Repos.LanguageRepo;
import com.FullStack.BMS.Repos.MovieRepo;
import com.FullStack.BMS.Repos.TypeRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movierepo;
	@Autowired
	private LanguageRepo languagerepo;
	@Autowired
	private TypeRepo typerepo;
	@Autowired
	private GenreRepo genrerepo;

	public void postsmovie(PostMovieDto body) {
//		System.out.println(body.getLanguages());
		MovieEntity movie = new MovieEntity();
		movie.setTitle(body.getTitle());
		movie.setCensor(body.getCensor());
		movie.setDuration(body.getDuration());
		movie.setPoster(body.getPoster());
		movie.setRating(body.getRating());
		movie.setReleasedate(body.getReleasedate());
		movie.setVotes(body.getVotes());
		Set<LanguageEntity> langset = new HashSet<LanguageEntity>(languagerepo.findAllById(body.getLanguages()));
		Set<TypeEntity> typeset = new HashSet<TypeEntity>(typerepo.findAllById(body.getTypes()));
		Set<GenreEntity> genreset=new HashSet<GenreEntity>(genrerepo.findAllById(body.getGenres()));
		movie.setMoviegenre(genreset);
		movie.setMovielang(langset);
		movie.setMovietype(typeset);

		movierepo.save(movie);
	}

	public void postslanguage(LanguageEntity body) {
		if (body.getLanguage() != null) {
			languagerepo.save(body);
		}

//		languagerepo.save(new LanguageEntity("English"));
	}

	public List<LanguageEntity> getslanguages() {
		List<LanguageEntity> all = languagerepo.findAll();
//		all.stream().map(m->m.getMovies().stream()).collect(Collectors.toList());
		return all;
				
		 
	}

	public List<MovieEntity> getsmovies() {
		return movierepo.findAll();
	}

	public List<TypeEntity> getstypes() {
		return typerepo.findAll();
	}

	public void poststype(TypeEntity body) {
		if (body.getType() != null) {
			typerepo.save(body);
		}
	}

	public void postsgenre(GenreEntity body) {
		if (body.getGenre() != null) {
			genrerepo.save(body);
		}
	}

	public List<GenreEntity> getsgenres() {
		return genrerepo.findAll();
	}

	public  List<JoinsDto> gots() {
		return movierepo.getMovieAndLanguagePairs("English");		
	}

}
