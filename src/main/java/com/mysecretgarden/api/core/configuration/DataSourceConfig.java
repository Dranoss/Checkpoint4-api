package com.mysecretgarden.api.core.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("mysecretgarden_db_username"));
        dataSourceBuilder.password(System.getenv("mysecretgarden_db_password"));
        dataSourceBuilder.url(System.getenv("mysecretgarden_db_url"));

        return dataSourceBuilder.build();
    }

}
