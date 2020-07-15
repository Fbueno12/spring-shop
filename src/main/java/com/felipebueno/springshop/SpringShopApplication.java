package com.felipebueno.springshop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipebueno.springshop.domain.Category;
import com.felipebueno.springshop.repositories.CategoryRepository;

@SpringBootApplication
public class SpringShopApplication implements CommandLineRunner{

	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
