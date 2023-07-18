package com.robertwang.gatewayservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Value("${gateway.url:}")
	private String gatewayUrl;

	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis(
			SwaggerUiConfigParameters swaggerUiConfigParameters, RouteLocator locator) {
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<Route> routes = locator.getRoutes();
		swaggerUiConfigParameters.addGroup("", "gateway");
		for (Route definition : routes) {
			if (definition.getId().contains("Swagger")) {
				swaggerUiConfigParameters.addGroup(definition.getId().split("-")[0]);
			}
		}
		return groups;
	}

	@Bean
	public OpenAPI customOpenAPI() {
		Server server = new Server();
		server.setUrl(gatewayUrl);
		return new OpenAPI()
				.servers(Arrays.asList(server));
	}
}
