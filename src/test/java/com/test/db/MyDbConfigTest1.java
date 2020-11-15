package com.test.db;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class MyDbConfigTest1 {

    @Autowired
    @Qualifier("templateRead")
    private NamedParameterJdbcTemplate readDatasource;

    @Autowired
    @Qualifier("templateWrite")
    private NamedParameterJdbcTemplate writeDatasource;

    /**
     * In this case dataSource.isReadOnly() is coming as true that mean you can't write the data to the DB
     */
    @Test
    public void testReadDb(){
        HikariDataSource dataSource = (HikariDataSource) readDatasource.getJdbcTemplate().getDataSource();
        Assertions.assertTrue(dataSource.isReadOnly());
    }

    /**
     * In this case dataSource.isReadOnly() is coming as false that mean you can write/read the data to the DB
     */
    @Test
    public void testWriteDb(){
        HikariDataSource dataSource = (HikariDataSource) writeDatasource.getJdbcTemplate().getDataSource();
        Assertions.assertTrue((!dataSource.isReadOnly()));
    }
}
