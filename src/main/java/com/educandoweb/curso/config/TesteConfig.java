package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.entities.enums.OrderStatus;
import com.educandoweb.curso.repositories.CategoryRepository;
import com.educandoweb.curso.repositories.OrderRepository;
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
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order (null, Instant.parse("2024-06-20T19:53:07z"),OrderStatus.PAID,u1);
		Order o2 = new Order (null, Instant.parse("2024-07-21T03:43:10z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order (null, Instant.parse("2024-07-22T15:21:22z"),OrderStatus.WAITING_PAYMENT,u1);
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
	

}
