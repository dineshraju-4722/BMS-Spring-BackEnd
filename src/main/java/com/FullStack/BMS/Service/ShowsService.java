package com.FullStack.BMS.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FullStack.BMS.Dto.PostShowDto;
import com.FullStack.BMS.Dto.ShowsBytheatreAndLocation;
import com.FullStack.BMS.Entities.MovieEntity;
import com.FullStack.BMS.Entities.ShowsEntity;
import com.FullStack.BMS.Entities.TheatresEntity;
import com.FullStack.BMS.Repos.MovieRepo;
import com.FullStack.BMS.Repos.ShowsRepo;
import com.FullStack.BMS.Repos.TheatresRepo;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShowsService {

	@Autowired
	private ShowsRepo showsrepo;
	@Autowired
	private MovieRepo movierepo;
	@Autowired
	private TheatresRepo theatresrepo;
	@Autowired
	private ObjectMapper objectMapper;

	private List<ShowsEntity> uniqueshowsWithLocation(String location) {
		List<ShowsEntity> showsByLocationsAndDate = showsrepo.getShowsByLocationsAndDate(location);
		HashMap<Integer, ShowsEntity> uniqueshows = new HashMap<Integer, ShowsEntity>();
		for (ShowsEntity show : showsByLocationsAndDate) {
			int id = show.getMovie().getId();
			uniqueshows.putIfAbsent(id, show);
		}
		return new ArrayList<>(uniqueshows.values());
	}

	public void postsshow(PostShowDto body) {
		ShowsEntity show = new ShowsEntity();
		MovieEntity movie = movierepo.findById(body.getMovie()).orElse(null);
		TheatresEntity theatre = theatresrepo.findById(body.getTheatre()).orElse(null);

		show.setMovie(movie);
		show.setName(body.getName());
		show.setTime(body.getTime());
		movie.getShows().add(show);
		show.setThetare(theatre);
		show.setDate(body.getDate());
		show.setLanguage(body.getLanguage());

		showsrepo.save(show);
	}

	public List<ShowsEntity> getsshows() {
		return showsrepo.findAll();
	}

	public List<ShowsEntity> getsshowsbylocationanddate(String location, Date date) {
		return uniqueshowsWithLocation(location);
	}
	
	public Map<String, List<ShowsBytheatreAndLocation>> getshowsbythestres(String location, String movie, Date date)
			throws JsonProcessingException {
		// TODO Auto-generated method stub

		String showsWithTheatresAndLocations = showsrepo.getShowsWithTheatresAndLocations(location, movie, date);
		TypeReference<Map<String, List<ShowsBytheatreAndLocation>>> typeRef = new TypeReference<>() {
		};
		return objectMapper.readValue(showsWithTheatresAndLocations, typeRef);
	}
	
	public List<ShowsEntity> getsshowsbygenre(String location, String genre){
		List<ShowsEntity> uniqueshowsbyLocation = uniqueshowsWithLocation(location);
		List<ShowsEntity> aa=uniqueshowsbyLocation.stream().filter(e->e.getMovie().getMoviegenre().stream().anyMatch(w->w.getGenre().equalsIgnoreCase(genre))).collect(Collectors.toList());
		return aa;
	}

	
	public List<ShowsEntity> getsshowsbylanguage(String location, String language) {
		List<ShowsEntity> uniqueshowsbyLanguage = uniqueshowsWithLocation(location);
		List<ShowsEntity> aa=uniqueshowsbyLanguage.stream().filter(e->e.getMovie().getMovielang().stream().anyMatch(w->w.getLanguage().equalsIgnoreCase(language))).collect(Collectors.toList());
		return aa;
	}

	public List<ShowsEntity> getsshowsbytype(String location, String type) {
		List<ShowsEntity> uniqueshowsbyType = uniqueshowsWithLocation(location);
		List<ShowsEntity> aa=uniqueshowsbyType.stream().filter(e->e.getMovie().getMovietype().stream().anyMatch(w->w.getType().equalsIgnoreCase(type))).collect(Collectors.toList());
		return aa;
	}

}
