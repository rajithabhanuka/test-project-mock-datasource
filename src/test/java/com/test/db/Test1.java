package com.test.db;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Test1 {

        /*
         * I setup a context runner with the class ExampleConfiguration
         * in it. For that, I use ApplicationContextRunner#withUserConfiguration()
         * methods to populate the context.
         */
        ApplicationContextRunner context = new ApplicationContextRunner()
                .withUserConfiguration(MyDbConfig.class);

        @Test
        public void checkBeansAreConfiguredWithReadAndWriteDataSources() {
            /*
             * We start the context and we will be able to trigger
             * assertions in a lambda receiving a
             * AssertableApplicationContext
             */
            context.run(it -> {
                /*
                 * I can use assertThat to assert on the context
                 * and check if the @Bean configured is present
                 * (and unique)
                 */
                NamedParameterJdbcTemplate jdbcTemplate = (NamedParameterJdbcTemplate) it.getBean("templateRead");
                HikariDataSource dataSource = (HikariDataSource) jdbcTemplate.getJdbcTemplate().getDataSource();
                Assertions.assertTrue(dataSource.isReadOnly());
                NamedParameterJdbcTemplate jdbcTemplateWrite = (NamedParameterJdbcTemplate) it.getBean("templateWrite");
                HikariDataSource dataSourceWrite = (HikariDataSource) jdbcTemplateWrite.getJdbcTemplate().getDataSource();
                Assertions.assertFalse(dataSourceWrite.isReadOnly());
            });
        }

    }

