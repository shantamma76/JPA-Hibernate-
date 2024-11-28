package com.xworkz.course.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.course.dto.CourseDto;

public class UpdateRunner1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		//get all
		List<CourseDto> dtos = em.createQuery("select cd from CourseDto cd", CourseDto.class).getResultList();

		for (CourseDto dto : dtos) {
			System.out.println("Course List = " + dto.getName() + ", " + dto.getEmail() + ", " + dto.getAge() + " ,"
					+ dto.getPhone());
		}

		try {

			et.begin();

			//update by name  and email where ph =""
			
			int value = em
					.createQuery(
							"UPDATE CourseDto c SET c.name = :myname, c.email = :myemail WHERE " + "c.phone = :phone")
					.setParameter("myname", "Radhika").setParameter("myemail", "radha@gmail.com")
					.setParameter("phone", Long.valueOf("886699774")).executeUpdate();

			if (value > 0) {
				System.out.println("Update Succesfully");
			} else {
				System.err.println("Not Update");
			}

			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
