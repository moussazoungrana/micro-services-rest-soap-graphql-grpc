package net.moz.customerservice;

import net.moz.customerservice.entities.Customer;
import net.moz.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("moussa").email("moussa@gmail.com").build());
            customerRepository.save(Customer.builder().name("moussa2").email("moussa2@gmail.com").build());
            customerRepository.save(Customer.builder().name("moussa3").email("moussa3@gmail.com").build());
        };
    }



}
