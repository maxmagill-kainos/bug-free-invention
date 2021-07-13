package com.bug.free.invention.api.unitTest;

import com.bug.free.invention.api.controllers.US002;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class US002Test {
    private US002 jobRolesObject;

    @BeforeEach
    public void setUp(){
        jobRolesObject = new US002();
    }

    @Test
    @DisplayName("Testing a list is returned")
    public void getJobRolesReturnsAListTest() {
        setUp();

        assertEquals(ArrayList.class,jobRolesObject.getJobRoles().getClass(),"This return is invalid");

    }

    @Test
    @DisplayName("Testing an invalid login")
    public void getJobRolesDoesNotReturnNullTest(){
        setUp();

        assertNotNull(jobRolesObject.getJobRoles());
    }
}