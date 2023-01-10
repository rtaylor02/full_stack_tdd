package com.rodtaylor02.full_stack_tdd.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    // ARRANGE
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        // ACT: Make the request and get the result.
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-rod")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        // ASSERT: check if content is as expected.
        assertEquals("Hello Rod", result.getResponse().getContentAsString());
    }
}