package com.example.demo;

import com.example.consumingwebservice.wsdl.GetInventoryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	// 	to generate classes run:
	//  ./mvnw compile
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	CommandLineRunner lookup(Client quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetInventoryResponse response = quoteClient.getInventory();
			System.err.println(response.getGetInventoryResult());
		};
	}
}
