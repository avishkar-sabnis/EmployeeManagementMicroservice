package com.EmployeeManagement.SalaryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.EmployeeManagement.SalaryService"})
@EnableEurekaClient
@EnableFeignClients
public class SalaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryServiceApplication.class, args);
	}

}
