package com.FullStack.BMS.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FullStack.BMS.Dto.PostTheatreDto;
import com.FullStack.BMS.Entities.LocationsEntity;
import com.FullStack.BMS.Entities.TheatresEntity;
import com.FullStack.BMS.Service.TheatreService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TheatreController {

	@Autowired
	private TheatreService theatreserv;

	@PostMapping("/postlocation")
	public void postinglocation(@RequestBody LocationsEntity body) {
		theatreserv.postslocation(body);
	}

	@GetMapping("/getlocations")
	public List<LocationsEntity> gettinglocations() {
		return theatreserv.getslocations();
	}

	@PostMapping("/posttheatre")
	public void postingtheatre(@RequestBody PostTheatreDto body) {
		theatreserv.poststheatre(body);
	}
	
	@GetMapping("/gettheatres")
	public List<TheatresEntity> gettingtheatres() {
		return theatreserv.getstheatres();
	}

}
