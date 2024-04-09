package com.lucas.techchallenge;

import com.lucas.techchallenge.model.User;
import com.lucas.techchallenge.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechChallenge03Application {

	public static void main(String[] args) {
		SpringApplication.run(TechChallenge03Application.class, args);
	}

/*	@Bean
	public CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			User user = new User(1L, "Lucas", "lucas@email.com");
			userRepository.insert(user);
		};
	}*/

}
