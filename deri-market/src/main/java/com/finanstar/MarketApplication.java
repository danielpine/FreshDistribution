package com.finanstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//开启servlet注解，用于配置过滤器
@ServletComponentScan

public class MarketApplication {

	public static String port;

	public static void main(String[] args) {
		if (args.length == 1) {
			MarketApplication.port = "8082";
			args = new String[] { args[0], "--server.port=" + MarketApplication.port };
		}
		SpringApplication.run(MarketApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}

}
