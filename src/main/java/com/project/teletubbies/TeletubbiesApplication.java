package com.project.teletubbies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class TeletubbiesApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/"+ "teletubbies");
		SpringApplication.run(TeletubbiesApplication.class, args);
	}

}
