package com.sample;

import com.sample.models.AppUser;
import com.sample.models.UserRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
  @Bean
	public UserRegistration userRegistration(){
		return new UserRegistration();
	}
	@Bean
	public AppUser appUser(){
		return new AppUser();
	}

}
