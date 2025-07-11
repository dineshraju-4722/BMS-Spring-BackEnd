package com.FullStack.BMS.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FullStack.BMS.Entities.TheatresEntity;

public interface TheatresRepo extends JpaRepository<TheatresEntity, Integer>{
	List<TheatresEntity> findByLocation_LocationIgnoreCase(String locationName);

}
