package com.test.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MyDbConfig {

    @Primary
    @Bean(name = "templateRead")
    public NamedParameterJdbcTemplate templateRead() {
        return new NamedParameterJdbcTemplate(createReadDb());
    }

    @Bean(name = "templateWrite")
    public NamedParameterJdbcTemplate templateWrite() {
        return new NamedParameterJdbcTemplate(createWriteDb());
    }

    //@Bean(destroyMethod = "close")
    public DataSource createReadDb() {
        HikariDataSource readDataSource = createHikariDataSource("read");
        //readDataSource.setReadOnly(true);
        return readDataSource;
    }

    //@Bean(destroyMethod = "close")
    public DataSource createWriteDb() {
        return createHikariDataSource("write");
    }

    public HikariDataSource createHikariDataSource(String read_right) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test_db");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        if (read_right.equalsIgnoreCase("read")) {
            config.setReadOnly(true);
        }

        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;

//		final HikariDataSource hikariDataSource = new HikariDataSource();
//		hikariDataSource.setMaximumPoolSize(25);
//		hikariDataSource.setDataSourceClassName("org.h2.Driver");
//		hikariDataSource.addDataSourceProperty("url", "jdbc:h2:mem:assingment2");
//		hikariDataSource.addDataSourceProperty("username", "root");
//		hikariDataSource.addDataSourceProperty("password", "root");
//		return hikariDataSource;
    }

}
