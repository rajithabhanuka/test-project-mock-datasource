package com.test.db;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

@SpringBootTest
class MyDbConfigTest {

    @Autowired
    private Map<String, NamedParameterJdbcTemplate> dataSources;


    /**
     * In this case Checking the datasource qualified names, below loop is looping 2 times and checking against
     * "templateRead|templateWrite" for datasource qualified name. and also you can put a debug point and can check the
     * datasource properties using this "dataSources.get("templateWrite").getJdbcTemplate().getDataSource()"
     * at this time also you can see the readonly status whether it is true of false
     */
    @Test
    public void testCreateDatasource(){

        for (Map.Entry<String, NamedParameterJdbcTemplate> entry : dataSources.entrySet()) {
            String k = entry.getKey();
            Assertions.assertTrue(k.matches("templateRead|templateWrite"));

        }
    }

}
