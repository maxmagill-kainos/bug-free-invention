package com.bug.free.invention.api.integrationTests;

import com.bug.free.invention.api.controllers.DBConfig;
import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

public class LoginIntegrationTest {

    @RunWith(SpringRunner.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class JobControllerTests {
        @LocalServerPort
        private int port;
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();


        @BeforeEach
        public void setup() {
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            restTemplate.exchange(createURLWithPort("/students"), HttpMethod.POST, entity, String.class);
            System.out.println(DBConfig.TestMode() + DBConfig.url);
        }

        @BeforeEach
        public void EnsureTestMode(){
            DBConfig.TestMode();
        }
}
