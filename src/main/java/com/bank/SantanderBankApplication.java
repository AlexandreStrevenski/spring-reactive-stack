package com.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class SantanderBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderBankApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(AccountRepository accountRepository) {
		return args -> {
			Stream.of("Alex", "John1", "John2", "Someone else", "Hey ho!")
					.map(name -> new Account(UUID.randomUUID().toString(), name, randomBalance()))
					.map(movie-> accountRepository.save(movie))
					.forEach(System.out::println);
		};
	}
	private Double randomBalance() {
		return Math.random();
	}
}