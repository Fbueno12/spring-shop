package com.felipebueno.springshop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipebueno.springshop.domain.Address;
import com.felipebueno.springshop.domain.Category;
import com.felipebueno.springshop.domain.City;
import com.felipebueno.springshop.domain.Client;
import com.felipebueno.springshop.domain.Product;
import com.felipebueno.springshop.domain.State;
import com.felipebueno.springshop.domain.enums.ClientType;
import com.felipebueno.springshop.repositories.AddressRepository;
import com.felipebueno.springshop.repositories.CategoryRepository;
import com.felipebueno.springshop.repositories.CityRepository;
import com.felipebueno.springshop.repositories.ClientRepository;
import com.felipebueno.springshop.repositories.ProductRepository;
import com.felipebueno.springshop.repositories.StateRepository;

@SpringBootApplication
public class SpringShopApplication implements CommandLineRunner{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1, cat2));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlândia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "Maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
		cli1.getTelephones().addAll(Arrays.asList("27363323", "93838398"));
		
		Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardins", "382208384", cli1, c1);
		Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}
