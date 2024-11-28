package com.xworkz.course.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.course.dto.CourseDto;

public class CourseRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		List<CourseDto> dtos = new ArrayList<CourseDto>();
		dtos.add(new CourseDto("Shanta", "shanta@gmail.com", 987451236, 22));
		dtos.add(new CourseDto("Bhagya", "bhagya@gmail.com", 658749123, 23));
		dtos.add(new CourseDto("Sohita", "sohita@gmail.com", 664477889, 24));
		dtos.add(new CourseDto("Renuka", "renu@gmail.com", 779988466, 25));
		dtos.add(new CourseDto("Kalpana", "kalpana@gmail.com", 886699774, 26));
		dtos.add(new CourseDto("Nikil", "nikil@gmail.com", 66554789, 18));
		dtos.add(new CourseDto("Naveen", "naveen@gmail.com", 332211456, 16));

		for (CourseDto courseDto : dtos) {

			CourseDto course = new CourseDto();
			course.setName(courseDto.getName());
			course.setEmail(courseDto.getEmail());
			course.setPhone(courseDto.getPhone());
			course.setAge(courseDto.getAge());

			em.persist(course);
		}

		try {
			et.begin();
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();

		}
	}
}
