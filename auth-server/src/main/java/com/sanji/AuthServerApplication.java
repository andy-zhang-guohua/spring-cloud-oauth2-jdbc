package com.sanji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableResourceServer
public class AuthServerApplication {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
