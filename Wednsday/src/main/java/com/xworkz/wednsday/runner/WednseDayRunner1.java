package com.xworkz.wednsday.runner;

import com.xworkz.wednseday.service.WedService;
import com.xworkz.wednseday.service.WedServiceImpl;

public class WednseDayRunner1 {

	public static void main(String[] args) {

		WedService wedService = new WedServiceImpl();
		
	    System.out.println(wedService.getNameById(3));
	        
		Object[] obj = (Object[]) wedService.getEmailAndDescriptionByPhone(874596321);
		System.out.println("Name: " + obj[0] + " " + "Email: " + obj[1]); 

	}

}
