package com.applications.own.dataservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableCaching
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled= true)
//@EnableWebMvc
//@EnableScheduling
@ComponentScan(basePackages = "com.applications.own.*")
public class DataServiceApplication extends SpringBootServletInitializer{
	
//	public SpringApplicationBuilder congifure(SpringApplicationBuilder application) {
//		return application.sources( DataServiceApplication.class);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}
	
}