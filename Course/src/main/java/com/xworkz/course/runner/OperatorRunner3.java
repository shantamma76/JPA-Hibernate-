package com.xworkz.course.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.course.dto.CourseDto;

public class OperatorRunner3 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			CourseDto courseDto = new CourseDto();

			List<String> dtos = em
					.createQuery(
							"select u.email from CourseDto u where u.name like : setname OR u.name like :setname1 ")
					.setParameter("setname", "s%").setParameter("setname1", "n%").getResultList();

			for (String string : dtos) {
				System.out.println(string);
			}
			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
