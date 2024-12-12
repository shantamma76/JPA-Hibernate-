package com.xworkz.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.product.dto.ProductDTO;
import com.xworkz.product.service.ProductService;
import com.xworkz.product.service.ProductServiceImpl;

@Controller
@RequestMapping("/")

public class ProductConroller {

	public ProductConroller() {
		System.out.println("no-arg const in ProductConroller");
	}

	@GetMapping("/save")
	public String onSave() {
		System.out.println("this is get");
		return "index.jsp";
	}

	@PostMapping("/save")
	public String onSave(ProductDTO productDTO) {
		System.out.println(productDTO.toString());

		ProductService productService = new ProductServiceImpl();
		boolean saved = productService.save(productDTO);
		
		System.out.println(saved);
		

		return "index.jsp";

	}

}
