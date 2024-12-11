package com.xworkz.wednseday.service;

import java.util.List;

import com.xworkz.wednsday.entity.WedEntity;

public interface WedService {
	
	List<WedEntity> getNameById(int id);
	
	Object getEmailAndDescriptionByPhone(long phone);
	

}
