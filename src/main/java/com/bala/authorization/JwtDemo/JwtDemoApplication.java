package com.bala.authorization.JwtDemo;

import com.bala.authorization.JwtDemo.model.Account;
import com.bala.authorization.JwtDemo.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtDemoApplication {

	@Autowired
	private UserAccountRepository repository;

	@PostConstruct
	public void initUsers() {
		List<Account> users = Stream.of(
				new Account( 101,"admin", "admin", "admin@gmail.com"),
				new Account( 102,"bala", "password", "bala@gmail.com"),
				new Account( 103,"user1", "pwd1", "user1@gmail.com"),
				new Account( 104,"user2", "pwd2", "user2@gmail.com"),
				new Account( 105,"user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}




}
