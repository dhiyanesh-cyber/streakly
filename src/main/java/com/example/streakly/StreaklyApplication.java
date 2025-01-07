package com.example.streakly;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreaklyApplication {

	public static void main(String[] args) {
		// Load .env file
		Dotenv dotenv = Dotenv.configure().load();

		// Set environment variables programmatically
		System.setProperty("SPRING_APPLICATION_NAME", dotenv.get("SPRING_APPLICATION_NAME"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("JPA_DDL_AUTO", dotenv.get("JPA_DDL_AUTO"));
		System.setProperty("SHOW_SQL", dotenv.get("SHOW_SQL"));
		System.setProperty("HIBERNATE_DIALECT", dotenv.get("HIBERNATE_DIALECT"));
		SpringApplication.run(StreaklyApplication.class, args);
	}

}
