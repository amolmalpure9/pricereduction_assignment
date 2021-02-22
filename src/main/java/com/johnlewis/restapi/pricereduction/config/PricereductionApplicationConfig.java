package com.johnlewis.restapi.pricereduction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Amol
 * This class is used to set configuration for project
 *
 */
@Configuration
public class PricereductionApplicationConfig {

	@Bean
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
}
