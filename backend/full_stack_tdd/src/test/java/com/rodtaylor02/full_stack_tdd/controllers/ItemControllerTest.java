package com.rodtaylor02.full_stack_tdd.controllers;

import com.rodtaylor02.full_stack_tdd.business.ItemBusinessService;
import com.rodtaylor02.full_stack_tdd.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ItemControllerTest {

    /*
    ARRANGE
     */
    @Autowired
    private MockMvc mockMvc;
    @MockBean // To mock Autowired bean
    private ItemBusinessService itemBusinessService;

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

    @Test // Check if dummy item returned is EXACTLY of id=1, name = "london bus", price=12, value=9. Order
        // and spcaces are unchecked.
    void dummyItem_strict() throws Exception {
        /*
        ACT : create a request that accepts JSON
         */
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummyitem")
                .accept(MediaType.APPLICATION_JSON);

        /*
        ASSERT: check exact match (except for element order and spaces),
        if item returned is of id=1, name="london bus", price=12, value=9
         */
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{value: 9, id: 1, name: \"london bus\", price: 12}", true)) // OK: value property first
                .andReturn();
    }

    @Test
    void getItemFromItemBusinessService() throws Exception {
        //region ARRANGE
        when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Lego car", 5, 3));
        //endregion

        //region ACT
        RequestBuilder request = MockMvcRequestBuilders
                .get("/itembusinessservice")
                .accept(MediaType.APPLICATION_JSON);
        //endregion

        //region ASSERT
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{ id: 2, name: \"Lego car\", price: 5, value: 3 }"))
                .andReturn();
        //endregion
    }

    @Test
    void getAllItemsFromItemBusinessService() throws Exception{
        //region ARRANGE
        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(1, "Grey flask", 20, 3),
                        new Item(2, "Green jumper", 40, 3),
                        new Item(3, "Jumpy frog", 7, 3))
        );
        //endregion

        //region ACT
        RequestBuilder request = MockMvcRequestBuilders
                .get("/allitemsbusinessservice")
                .accept(MediaType.APPLICATION_JSON);
        //endregion

        //region ASSERT
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{ id:1,name:\"Grey flask\", price: 20, value: 3 }," +
                        "{ id:2,name:\"Green jumper\",price:40,value:3 }," +
                        "{ id:3,name:\"Jumpy frog\",price:7,value:3 }" +
                        "]"))
                .andReturn();
        //endregion

    }
}