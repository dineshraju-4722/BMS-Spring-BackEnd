package com.FullStack.BMS.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack.BMS.Dto.PostSeatDto;
import com.FullStack.BMS.Dto.PostShowDto;
import com.FullStack.BMS.Dto.ShowsBytheatreAndLocation;
import com.FullStack.BMS.Entities.ShowsEntity;
import com.FullStack.BMS.Service.ShowsService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*")
@RestController
public class ShowsController {
	@Autowired
	private ShowsService showsserv;

	@PostMapping("/postshow")
	public void postingshow(@RequestBody PostShowDto body) {
		showsserv.postsshow(body);
	}
	
	@GetMapping("/getshow/{id}")
	public ShowsEntity gettingshow(@PathVariable("id") int id) {
		return showsserv.getsshow(id);
	}

	@GetMapping("/getshows/home/{location}/{date}")
	public List<ShowsEntity> gettingshowsbylocation(@PathVariable("location") String location,
			@PathVariable("date") Date date) {
		return showsserv.getsshowsbylocationanddate(location, date);
	}

	@GetMapping("/getshows")
	public List<ShowsEntity> gettingshows() {
		return showsserv.getsshows();
	}

	@GetMapping("/getshows/theatresview/{location}/{movie}/{date}")
	public Map<String, List<ShowsBytheatreAndLocation>> gettingshowsbythestres(
			@PathVariable("location") String location, @PathVariable("movie") String movie,
			@PathVariable("date") Date date) {
		try {
			return showsserv.getshowsbythestres(location, movie, date);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/getshows/searchbygenre/{location}/{genre}")
	public List<ShowsEntity> gettingshowsbyGenreAndLocation(@PathVariable("location") String location,
			@PathVariable("genre") String genre) {
		return showsserv.getsshowsbygenre(location, genre);
	}

	@GetMapping("/getshows/searchbylanguage/{location}/{language}")
	public List<ShowsEntity> gettingshowsbyLanguageAndLocation(@PathVariable("location") String location,
			@PathVariable("language") String language) {
		return showsserv.getsshowsbylanguage(location, language);
	}

	@GetMapping("/getshows/searchbytype/{location}/{type}")
	public List<ShowsEntity> gettingshowsbyTypeAndLocation(@PathVariable("location") String location,
			@PathVariable("type") String type) {
		return showsserv.getsshowsbytype(location, type);
	}

	@PostMapping("/postseats")
	public void postingseat(@RequestBody PostSeatDto body) {
		showsserv.postsseat(body);
	}
	
	@GetMapping("/getseats/{showid}")
	public List<Integer> gettingseats(@PathVariable("showid") int showid) {
		return showsserv.getsseats(showid);
	}
	
}
