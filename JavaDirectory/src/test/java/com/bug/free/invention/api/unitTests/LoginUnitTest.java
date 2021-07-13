package com.bug.free.invention.api.unitTests;

import com.bug.free.invention.api.controllers.US024;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class LoginUnitTest {

    private US024 loginObject;
    @BeforeEach
    public void setUp(){
        loginObject = new US024();
    }

    @Test
    @DisplayName("Testing a valid login")
    public void testValidLogin(){
        setUp();
        String loginReturnString = loginObject.validateLogin("{\"Email\":\"john.smith\",\"Password\":\"0390a23613727a918e3f305b4bae0159\"}");
        assertEquals("Invalid login details",loginReturnString, "{\"Employee_ID\": \"1\", \"Is_Admin\": \"0\"}");
    }

    @Test
    @DisplayName("Testing an invalid login")
    public void testInvalidLogin(){
        setUp();
        String loginReturnString = loginObject.validateLogin("{\"Email\":\"john.smith\",\"Password\":\"password\"}");
        assertEquals("Valid login details",loginReturnString, "{\"response\": \"Incorrect Username or Password\"}");
    }
}
