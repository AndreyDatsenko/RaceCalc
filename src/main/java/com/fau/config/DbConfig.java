package com.fau.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Value("${dataSource.driverClassName}")
    private String driver;

    @Value("${dev.dataSource.url}")
    private String devUrl;
    @Value("${dev.dataSource.username}")
    private String devUsername;
    @Value("${dev.dataSource.password}")
    private String devPassword;

    @Bean
    public DataSource configureDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(devUrl);
        config.setUsername(devUsername);
        config.setPassword(devPassword);

        return new HikariDataSource(config);
    }

    @Bean
    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.fau");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return entityManagerFactoryBean;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource configureDataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(configureDataSource);
        flyway.setLocations("classpath:db/migration");
        flyway.migrate();

        return flyway;
    }
}