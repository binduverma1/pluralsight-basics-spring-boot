package com.divyendu.pluralsightbasics.conference.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
	
	/*@Bean
	public DataSource datasource() {
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost:3306/Conference").username("root").password("password");
		return builder.build();
	}*/

}
