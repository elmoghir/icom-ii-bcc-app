package net.abdessamad.customerservice;

import net.abdessamad.customerservice.entities.Customer;
import net.abdessamad.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
							.name("Abdessamad").email("abdessamad@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
							.name("Ahmed").email("ahmed@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
							.name("Youssef").email("youssef@gmail.com")
					.build());
			customerRepository.findAll().forEach(customer -> {
				System.out.println("--------------------------------");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
			});
		};
	}
}
