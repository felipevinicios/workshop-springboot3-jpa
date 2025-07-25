package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.entities.enums.OrderStatus;
import com.educandoweb.curso.repositories.CategoryRepository;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.ProductRepository;
import com.educandoweb.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	 private ProductRepository productRepository;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1= new Product (null, " The Lord od the Rings", "Lorem ipsum dolor sit amet, consectetur.",90.5,"");
		Product p2= new Product (null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.",2190.0,"");
		Product p3= new Product (null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis",1250.0,"" );
		Product p4= new Product (null, "PC gamer","Donec aliquet odio ac rhocus cursus.",1200.0,"");
		Product p5= new Product (null, "Rails for dummies", "Cras fringilla convallis sem vel faucibus.",100.99,"");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order (null, Instant.parse("2024-06-20T19:53:07z"),OrderStatus.PAID,u1);
		Order o2 = new Order (null, Instant.parse("2024-07-21T03:43:10z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order (null, Instant.parse("2024-07-22T15:21:22z"),OrderStatus.WAITING_PAYMENT,u1);
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
	

}
