package com.khadri.spring.student.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.student" })
public class StudentAppConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dms.setUrl("jdbc:mysql://localhost:3306/2024_batch");
		dms.setUsername("root");
		dms.setPassword("root");
		return dms;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;
	}

}