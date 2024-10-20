package com.ac.OneBlood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class OneBloodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneBloodApplication.class, args);
	}

}
