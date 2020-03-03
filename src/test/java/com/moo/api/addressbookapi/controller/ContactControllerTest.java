package com.moo.api.addressbookapi.controller;

import com.moo.api.addressbookapi.AddressBookApiApplication;
import com.moo.api.addressbookapi.model.Contact;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AddressBookApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactControllerTest {

    private static final String REST_END_POINT = "/api/v1/contacts";


    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testSearchContact() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURL(REST_END_POINT + "/search?lastName=Anderson"), HttpMethod.GET, new HttpEntity<String>(null, null), String.class);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    public void testGetContact() {
        ResponseEntity<String> response = restTemplate.exchange(
                createURL(REST_END_POINT + "/get?id=1"),
                HttpMethod.GET, new HttpEntity<String>(null, null), String.class);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    private String createURL(String url) {
        return "http://localhost:" + port + url;
    }
}
