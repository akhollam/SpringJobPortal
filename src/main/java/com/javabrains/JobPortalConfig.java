package com.javabrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@PropertySource("classpath:/db.properties")
public class JobPortalConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		log.debug("init");

		DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("url"));
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername(env.getProperty("user"));
		dataSource.setPassword(env.getProperty("password"));

		return new JdbcTemplate(dataSource);
	}

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

		//WEB-INF/views/welcome.jsp
	}
}
