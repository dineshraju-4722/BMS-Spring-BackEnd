package com.FullStack.BMS.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FullStack.BMS.Entities.LanguageEntity;
import com.FullStack.BMS.Entities.TypeEntity;

public interface TypeRepo  extends JpaRepository<TypeEntity, Integer>{

}
