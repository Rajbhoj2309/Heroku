package com.heroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.heroku.model.User;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.heroku.repository")
//@EnableConfigurationProperties({User.class})
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
//
/*
 * if we want add multiple properties the we can used
 * 
 * @PropertySources({
 * 
 * @PropertySource(
 * "classpath:application-${spring.profiles.active:default}.properties") })
 */

public class HerokuApplication {
	public static void main(String[] args) {
		SpringApplication.run(HerokuApplication.class, args);
	}

}
