package com.xworkz.employee.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.employee.dto.Employeedto;

public class EmployeeRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<Employeedto> edtos = new ArrayList<Employeedto>();

		edtos.add(new Employeedto("shilpa", "Shetty", 26, "HR", "Manager", 50000, "2020-01-15", "megha@gmail.com",
				2013456789));
		edtos.add(new Employeedto("John", "Doe", 28, "HR", "Manager", 50000, "2020-01-15", "john@gmail.com",
				123 - 456 - 7890));
		edtos.add(new Employeedto("Katrina", "Kaif", 28, "HR", "Manager", 50000, "2020-01-15", "kaif@gmail.com",
				123 - 456 - 7890));
		edtos.add(new Employeedto("Hrithik", "Roshan", 35, "IT", "Developer", 75000, "2019-03-22", "roshan@gmail.com",
				234 - 567 - 8901));
		edtos.add(new Employeedto("Akshay", "Kumar", 42, "Marketing", "Director", 95000, "2018-07-11",
				"akshay@gmail.com", 345 - 678 - 9012));
		edtos.add(new Employeedto("Ajay", "Devgn", 28, "HR", "Manager", 50000, "2020-01-15", "ajay@gmail.com",
				123 - 456 - 7890));
		edtos.add(new Employeedto("Kartik", "Aaryan", 30, "Sales", "Sales Rep", 45000, "2021-11-05", "kartik@gmail.com",
				789654123));
		edtos.add(new Employeedto("Rajkummar", "Rao", 25, "IT", "Intern", 30000, "2022-05-10", "raj@gmail.com",
				897456321));
		edtos.add(new Employeedto("Amitabh", "Bachchan", 38, "HR", "Recruiter", 55000, "2020-06-20", "amit@gmail.com",
				789541263));
		edtos.add(new Employeedto("Radhika", "Pandit", 29, "IT", "Network Admin", 80000, "2017-04-01",
				"radhi@gmail.com", 879654123));
		edtos.add(new Employeedto("Yash", "Rocking", 30, "IT", "Network Admin", 82000, "2016-01-08", "rocky@gmail.com",
				958764123));

		for (Employeedto employeedto : edtos) {

			Employeedto employ = new Employeedto();

			employ.setFirstName(employeedto.getFirstName());
			employ.setLast_name(employeedto.getLast_name());
			employ.setAge(employeedto.getAge());
			employ.setDepartment(employeedto.getDepartment());
			employ.setPosition(employeedto.getPosition());
			employ.setSalary(employeedto.getSalary());
			employ.setDoj(employeedto.getDoj());
			employ.setEmail(employeedto.getEmail());
			employ.setPhone(employeedto.getPhone());

			em.persist(employ);
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
