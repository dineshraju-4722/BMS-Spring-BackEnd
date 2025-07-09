package com.FullStack.BMS.Controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack.BMS.Dto.PostShowDto;
import com.FullStack.BMS.Entities.ShowsEntity;
import com.FullStack.BMS.Service.ShowsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShowsController {
	@Autowired
	private ShowsService showsserv;

	@PostMapping("/postshow")
	public void postingshow(@RequestBody PostShowDto body) {
        showsserv.postsshow(body);
	}
	
	@GetMapping("/getshows/home/{location}/{date}")
	public List<ShowsEntity> gettingshowsbylocation(@PathVariable("location") String location,@PathVariable("date") Date date){
		return showsserv.getsshowsbylocationanddate(location,date);
	}
	
	@GetMapping("/getshows")
  public List<ShowsEntity> gettingshows(){
		return showsserv.getsshows();
	}
}
