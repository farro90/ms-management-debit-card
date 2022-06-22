package com.nttdata.bc19.msmanagementdebitcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsManagementDebitCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsManagementDebitCardApplication.class, args);
	}

}
