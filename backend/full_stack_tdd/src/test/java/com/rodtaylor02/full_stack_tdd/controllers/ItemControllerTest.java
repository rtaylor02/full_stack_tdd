package com.rodtaylor02.full_stack_tdd.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ItemControllerTest {

    /*
    ARRANGE
     */
    @Autowired
    private MockMvc mockMvc;

    @Test // Check if dummy item of id 1 with price of 12 is returned
    void dummyItem() throws Exception {
        /*
        ACT : create a request that accepts JSON
         */
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummyitem")
                .accept(MediaType.APPLICATION_JSON);

        /*
        ASSERT: check if item returned is of id 1 with name of "london bus" and price of 12
         */
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 1, name: \"london bus\", price: 12}"))
                .andReturn();
    }
}