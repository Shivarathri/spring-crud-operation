package com.capgemini.springangular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class EntityManagerConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntity() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("TestPersistence");
		return factoryBean;
	}
}
