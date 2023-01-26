package com.example.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@RestController
public class SpringBootDockerApplication{

	public class Greeting {
		private String content;

		public Greeting(String str){
			this.content = str;
		}

		public String getContent(){
			return content;
		}

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/").allowedOrigins("http://localhost:4200");
				registry.addMapping("/test").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@RequestMapping("/")
	public Greeting home(){
		return new Greeting("Hello World");
	}

	@RequestMapping("/test")
	public Greeting test(){
		return new Greeting("This is testing");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
