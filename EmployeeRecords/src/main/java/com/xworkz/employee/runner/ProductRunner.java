package com.xworkz.employee.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.employee.dto.Productdto;

public class ProductRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<Productdto> dtos = new ArrayList<Productdto>();
		dtos.add(new Productdto("Apple iPhone 13", "Electronics", 799, 50, "Apple Inc", 10, "2024-11-01",
				"Latest model128GB storage", "2026-11-01"));

		dtos.add(new Productdto("Samsung Galaxy S23", "Electronics", 899, 40, "Samsung", 10, "2024-09-10",
				"5G, 256GB storage, 8GB RAM", "2026-09-10"));

		dtos.add(new Productdto("Dell XPS 13", "Laptops", 1200, 30, "Dell", 5, "2024-07-15",
				"13.3-inch,Intel i7 processor", "2026-07-15"));

		dtos.add(new Productdto("Sony WH-1000XM5", "Audio", 350, 100, "Sony", 20, "2024-10-05",
				"Noise-canceling headphones", "2025-10-05"));

		dtos.add(new Productdto("Nike Air Max 90", "Footwear", 120, 200, "Nike", 50, "2024-08-20",
				"Classic design, comfortable", "2025-08-20"));

		dtos.add(new Productdto("HP DeskJet 2755", "Printers", 69, 150, "HP", 30, "2024-11-10",
				"Wireless inkjet printer", "2026-11-10"));

		dtos.add(new Productdto("LG 4K OLED TV", "Electronics", 1500, 25, "LG Electronics", 5, "2024-04-22",
				"Ultra HD, OLED display", "2027-04-22"));

		dtos.add(new Productdto("Microsoft Surface Pro 9", "Tablets", 1100, 60, "Microsoft", 10, "2024-06-15",
				"12.3-inch, Windows 11", "2026-06-15"));

		dtos.add(new Productdto("Samsung 50/QLED", "Electronics", 1200, 35, "Samsung", 10, "2024-05-25",
				"4K QLED smart TV", "2027-05-25"));

		dtos.add(new Productdto("Fitbit Charge 5", "Wearables", 150, 500, "Fitbit", 10, "2024-09-30",
				"Fitness tracker, heart rate monitor", "2026-09-30"));

		for (Productdto productdto : dtos) {

			Productdto product = new Productdto();

			product.setProduct_name(productdto.getProduct_name());
			product.setCategory(productdto.getCategory());
			product.setPrice(productdto.getPrice());
			product.setQuantity(productdto.getQuantity());
			product.setSupplier(productdto.getSupplier());
			product.setReorder_level(productdto.getReorder_level());
			product.setDate_added(productdto.getDate_added());
			product.setDescription(productdto.getDescription());
			product.setExpiry_date(productdto.getExpiry_date());

			em.persist(product);
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
