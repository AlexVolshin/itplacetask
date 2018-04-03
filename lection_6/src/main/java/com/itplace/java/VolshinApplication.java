package com.itplace.java;

import com.itplace.java.Api.HtmlGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VolshinApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(VolshinApplication.class, args);
		HtmlGenerator generator = ctx.getBean("htmlGeneratorImp", HtmlGenerator.class);
		generator.generate("input.properties", "result.html");

	}
}
