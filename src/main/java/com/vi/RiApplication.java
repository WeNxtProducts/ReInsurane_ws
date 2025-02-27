package com.vi;

import com.vi.corelib.exceptions.EnableApiException;
//import com.security.authorization.EnableAuthFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAuthFilter
@EnableApiException
@SpringBootApplication
public class RiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiApplication.class, args);
	}

}
