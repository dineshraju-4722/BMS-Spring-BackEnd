package com.FullStack.BMS.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FullStack.BMS.Dto.PostShowDto;
import com.FullStack.BMS.Entities.MovieEntity;
import com.FullStack.BMS.Entities.ShowsEntity;
import com.FullStack.BMS.Entities.TheatresEntity;
import com.FullStack.BMS.Repos.MovieRepo;
import com.FullStack.BMS.Repos.ShowsRepo;
import com.FullStack.BMS.Repos.TheatresRepo;

@Service
public class ShowsService {

	@Autowired
	private ShowsRepo showsrepo;
	@Autowired
	private MovieRepo movierepo;
	@Autowired
	private TheatresRepo theatresrepo;

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

	public List<ShowsEntity> getsshowsbylocationanddate(String location,Date date) {
		List<ShowsEntity> showsByLocationsAndDate = showsrepo.getShowsByLocationsAndDate(location, date);
		HashMap<Integer, ShowsEntity> uniqueshows=new HashMap<Integer, ShowsEntity>();
		for(ShowsEntity show:showsByLocationsAndDate) {
			int id=show.getMovie().getId();
			uniqueshows.putIfAbsent(id, show);
		}
		return new ArrayList<>(uniqueshows.values()); 
	}

}
