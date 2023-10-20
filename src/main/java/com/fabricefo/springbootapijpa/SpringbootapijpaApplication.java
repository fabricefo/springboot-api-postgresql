package com.fabricefo.springbootapijpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.fabricefo.springbootapijpa.entity")
public class SpringbootapijpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootapijpaApplication.class, args);
	}

}
