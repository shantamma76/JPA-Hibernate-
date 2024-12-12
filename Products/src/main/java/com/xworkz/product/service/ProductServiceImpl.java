package com.xworkz.product.service;



import org.springframework.stereotype.Service;

import com.xworkz.product.dto.ProductDTO;
import com.xworkz.product.entity.ProductEntity;

import com.xworkz.product.repository.ProductRepo;
import com.xworkz.product.repository.ProductRepoImple;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public boolean save(ProductDTO dto) {
		
		System.out.println("dto in service==" +dto.toString());
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setItemName(dto.getItemName());
		productEntity.setCost(dto.getCost());
		
		ProductRepo productRepo =new ProductRepoImple();
		productRepo.save(productEntity);
		System.out.println("entity==" +productEntity.toString());
		
		return true;
	}

}


