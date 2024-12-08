package com.xworkz.hospital.runner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.hospital.entity.HospitalEntity;

public class InsertQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			List<HospitalEntity> list = new ArrayList<HospitalEntity>();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			list.add(new HospitalEntity("jeams", "rahul@gmail.com", 25, 60.2f, 987456321l, 102,LocalDateTime.parse("12-05-2024 11:30:45", formatter), 8900, false));
			list.add(new HospitalEntity("Manipal Hospital", "mohan@gmail.com", 24, 52.2f, 879546123, 105,LocalDateTime.parse("14-07-2024 12:45:30", formatter), 8000, true));
			list.add(new HospitalEntity("RMV Hospital", "ramesh@gmail.com", 23, 50.2f, 874125963, 106,LocalDateTime.parse("12-05-2024 11:30:45", formatter), 8900, false));
			list.add(new HospitalEntity("Care Clinic", "kartik@gmail.com", 22, 42.2f, 987412563, 108,LocalDateTime.parse("15-08-2024 16:22:41", formatter), 700, true));
			list.add(new HospitalEntity("Columbia Asia", "sageeta@gmail.com", 26, 58.2f, 258741369, 201,LocalDateTime.parse("06-01-2024 18:10:10", formatter),400,true));
			list.add(new HospitalEntity("Vikram Hospital", "vinay@gmail.com", 29, 62.2f, 251478963,205,LocalDateTime.parse("11-11-2024 10:15:26", formatter), 5000, false));
			list.add(new HospitalEntity("KIMS Hospital", "ram@gmail.com", 28, 59.3f, 869574123,206,LocalDateTime.parse("13-06-2024 01:13:15", formatter), 3000, true));
			list.add(new HospitalEntity("Motherhood Hospital", "nakul@gmail.com", 27, 60.2f, 987456321l, 102,LocalDateTime.parse("20-09-2024 12:05:55", formatter), 2000, false));
			list.add(new HospitalEntity("BGS Global Hospital", "aishwarya@gmail.com", 30, 58.2f, 987456321l, 102,LocalDateTime.parse("17-10-2024 09:50:45", formatter), 4000, true));
			list.add(new HospitalEntity("Narayana Health", "pratam@gmail.com", 32, 70.2f, 987456321l, 102,LocalDateTime.parse("03-08-2024 04:15:45", formatter), 1000, false));
			list.add(new HospitalEntity("Sakra Premium Clinic", "pretham@gmail.com", 31, 70.2f, 987456321l, 102,LocalDateTime.parse("06-04-2024 05:10:15", formatter), 1200, true));
			
			for (HospitalEntity hospitalEntity : list) {
				em.persist(hospitalEntity);
			}
			et.begin();
			et.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		finally {
			if (et.isActive())
				et.rollback();
			em.close();
			emf.close();
		}

	}

}
