package com.nick.springcloud.gateway.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PortalGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalGatewayApplication.class, args);
	}

}
