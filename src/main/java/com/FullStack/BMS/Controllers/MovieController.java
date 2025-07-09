package com.FullStack.BMS.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack.BMS.Dto.JoinsDto;
import com.FullStack.BMS.Dto.PostMovieDto;
import com.FullStack.BMS.Entities.GenreEntity;
import com.FullStack.BMS.Entities.LanguageEntity;
import com.FullStack.BMS.Entities.MovieEntity;
import com.FullStack.BMS.Entities.TypeEntity;
import com.FullStack.BMS.Service.MovieService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {
	@Autowired
	private MovieService movieserv;

	@GetMapping("/getmovies")
	public List<MovieEntity> gettingmovies() {
		return movieserv.getsmovies();
	}

	@PostMapping("/postmovie")
	public void postingmovie(@RequestBody PostMovieDto body) {
		movieserv.postsmovie(body);
	}

	@GetMapping("/getlanguages")
	public List<LanguageEntity> gettinglanguage() {
		return movieserv.getslanguages();
	}

	@PostMapping("/postlanguage")
	public void postinglanguage(@RequestBody LanguageEntity body) {
		movieserv.postslanguage(body);
	}

	@GetMapping("/gettypes")
	public List<TypeEntity> gettingtype() {
		return movieserv.getstypes();
	}

	@PostMapping("/posttype")
	public void postingtype(@RequestBody TypeEntity body) {
		movieserv.poststype(body);
	}

	@PostMapping("/postgenre")
	public void postinggenre(@RequestBody GenreEntity body) {
		movieserv.postsgenre(body);
	}

	@GetMapping("/getgenres")
	public List<GenreEntity> gettinggenres() {
		return movieserv.getsgenres();
	}

	@GetMapping("/getall")
	public List<JoinsDto> gets() {
      return movieserv.gots();
	}
}
