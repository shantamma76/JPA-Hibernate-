package com.xworkz.wednseday.repository;

import java.util.List;

import com.xworkz.wednsday.entity.WedEntity;

public interface WedRepository {
	
	
	List<WedEntity> getNameById(int id);
	
	Object getEmailAndDescriptionByPhone(long phone);

}
