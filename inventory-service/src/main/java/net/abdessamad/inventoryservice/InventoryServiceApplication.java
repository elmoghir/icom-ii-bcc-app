package net.abdessamad.inventoryservice;

import net.abdessamad.inventoryservice.entities.Product;
import net.abdessamad.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("MacBook M1 Pro")
							.price(20000)
							.quantity(20)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("MacBook M2 Pro")
					.price(25000)
					.quantity(20)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("MacBook M3 Pro")
					.price(30000)
					.quantity(20)
					.build());
			productRepository.findAll().forEach(
					product -> {
						System.out.println("++++++++++++++++++++++++");
						System.out.println(product.toString());
					}
			);
		};
	}
}
