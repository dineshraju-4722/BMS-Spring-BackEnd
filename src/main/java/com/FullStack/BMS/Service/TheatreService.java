package com.FullStack.BMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FullStack.BMS.Dto.PostTheatreDto;
import com.FullStack.BMS.Entities.LocationsEntity;
import com.FullStack.BMS.Entities.TheatresEntity;
import com.FullStack.BMS.Repos.LocationsRepo;
import com.FullStack.BMS.Repos.TheatresRepo;

@Service
public class TheatreService {
	@Autowired
	private LocationsRepo locationsrepo;
	@Autowired
	private TheatresRepo theatresrepo;

	public void postslocation(LocationsEntity body) {
		if (body.getLocation() != null) {
			locationsrepo.save(body);
		}
	}

	public List<LocationsEntity> getslocations() {
		return locationsrepo.findAll();
	}

	public void poststheatre(PostTheatreDto body) {
		TheatresEntity theatre=new TheatresEntity();
		theatre.setName(body.getName());
		theatre.setColumns(body.getColumns());
		theatre.setRows(body.getRows());
		theatre.setLocation(locationsrepo.findById(body.getLocation()).orElse(null));
		theatre.setTotalseats(body.getTotalseats());
		theatresrepo.save(theatre);
	}

	public List<TheatresEntity> getstheatres() {
return theatresrepo.findAll();
		}

	public List<TheatresEntity> getstheatresbylocation(String location) {
		return theatresrepo.findByLocation_LocationIgnoreCase(location);
	}

}
