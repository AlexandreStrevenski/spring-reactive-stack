package com.bank.application;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;
import com.bank.util.RandomUtil;
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
		return args -> Stream.of("Alex", "John1", "John2", "Someone else", "Hey ho!")
                .map(name -> new Account(UUID.randomUUID().toString(), name, RandomUtil.randomBalance()))
                .map(account -> accountRepository.save(account))
                .forEach(System.out::println);
	}

}