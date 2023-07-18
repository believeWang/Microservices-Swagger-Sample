package com.robertwang.organizationservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrganizationServiceApplication {

	@Value("${gateway.url:}")
	private String gatewayUrl;

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		Server server = new Server();
		server.setUrl(gatewayUrl);
		return new OpenAPI()
				.servers(Arrays.asList(server));
	}

}
