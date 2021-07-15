package com.bug.free.invention.api;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.bug.free.invention.api.controllers.DBConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;


public class DBConfigTests {
    /*
    @InjectMocks private DBConfig dbConfig;
    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;
    @Mock private PreparedStatement preparedStatement;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testMockDBConnection() throws Exception{
        Mockito.when(mockConnection.prepareStatement(any())).thenReturn(preparedStatement);
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        int value = mockStatement.executeUpdate("");
        Assert.assertEquals(value, 1);
        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
    }
*/
}

