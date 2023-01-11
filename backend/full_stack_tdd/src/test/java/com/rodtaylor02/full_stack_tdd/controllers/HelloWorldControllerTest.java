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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    /*
    ARRANGE
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        /*
        ACT: Make the request and get the result.
         */
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-rod")
                .accept(MediaType.APPLICATION_JSON);

        /*
        ASSERT: check if content is as expected. There are 2 ways:
        1) (preferred) Without assertEquals (straight from MvcResult)
        2) With assertEquals
         */

        //region 2) With assertEquals
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("Hello Rod", result.getResponse().getContentAsString());
        //endregion

        //region 1) Without assertEquals (preferred)
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Rod"))
                .andReturn();
        //endregion


    }
}