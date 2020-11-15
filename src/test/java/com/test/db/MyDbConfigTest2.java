package com.test.db;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MyDbConfigTest2 {

    @MockBean(name = "createReadDb")
    private HikariDataSource createReadDb;

    @MockBean(name = "createWriteDb")
    private HikariDataSource createWriteDb;


    @Test
    public void testTemplateRead() {
        Mockito.when((createReadDb).isReadOnly()).thenReturn(true);
        Assert.assertTrue(createReadDb.isReadOnly());
    }

    @Test
    public void testTemplateWrite() {
        Mockito.when((createWriteDb).isReadOnly()).thenReturn(false);
        Assert.assertFalse(createWriteDb.isReadOnly());
    }

}
