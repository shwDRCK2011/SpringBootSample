package com.bugReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BugReportWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugReportWebApplication.class, args);
		
	}
}
