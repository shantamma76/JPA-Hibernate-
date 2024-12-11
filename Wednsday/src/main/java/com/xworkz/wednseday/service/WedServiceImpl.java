package com.xworkz.wednseday.service;

import java.util.List;

import com.xworkz.wednsday.entity.WedEntity;
import com.xworkz.wednseday.repository.WedRepository;
import com.xworkz.wednseday.repository.WedRepositoryImpl;

public class WedServiceImpl implements WedService {

	WedRepository repo = new WedRepositoryImpl();

	@Override
	public List<WedEntity> getNameById(int id) {

		return repo.getNameById(id);
	}

	@Override
	public Object getEmailAndDescriptionByPhone(long phone) {

		return (Object[]) repo.getEmailAndDescriptionByPhone(phone);
	}

}
