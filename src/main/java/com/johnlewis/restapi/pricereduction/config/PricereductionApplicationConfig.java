package com.johnlewis.restapi.pricereduction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PricereductionApplicationConfig {

	@Bean
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
}
