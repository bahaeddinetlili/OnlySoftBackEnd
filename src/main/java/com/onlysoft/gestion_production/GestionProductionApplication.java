package com.onlysoft.gestion_production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@EnableJpaAuditing
public class GestionProductionApplication {

	public static void main(String[] args) {


		SpringApplication.run(GestionProductionApplication.class, args);


	}



}
