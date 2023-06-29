package com.Daily.Userview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserviewApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(UserviewApplication.class, args);
	}

}
