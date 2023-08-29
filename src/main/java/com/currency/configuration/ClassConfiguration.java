package com.currency.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.currency.service.CurrencyService;

@Configuration
public class ClassConfiguration {
	@Bean
	public CurrencyService currencyService()
	{
		return new CurrencyService();
	}

}
