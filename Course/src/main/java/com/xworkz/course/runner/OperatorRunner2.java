package com.xworkz.course.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.course.dto.CourseDto;

public class OperatorRunner2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			CourseDto dtos = new CourseDto();

			List<CourseDto> dtos1 = em
					.createQuery("SELECT new CourseDto(u.name , u.phone) FROM CourseDto u WHERE u.age > 15",CourseDto.class).getResultList();
			
			for (CourseDto courseDto : dtos1) {
				System.out.println("name = " + courseDto.getName() + " phone = " + courseDto.getPhone());
			}
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