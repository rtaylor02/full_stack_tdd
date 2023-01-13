package com.rodtaylor02.full_stack_tdd.controllers;

import com.rodtaylor02.full_stack_tdd.business.ItemBusinessService;
import com.rodtaylor02.full_stack_tdd.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummyitem")
    public Item dummyItem() {
        Item i = new Item(1, "london bus", 12, 9);
        System.out.println(i);
        return i;
    }

    @GetMapping("/itembusinessservice")
    public Item getItemFromItemBusinessService() {
        return itemBusinessService.retrieveHardCodedItem();
    }

    @GetMapping("/allitemsbusinessservice")
    public List<Item> getAllItemsFromItemBusinessService() {
        return itemBusinessService.retrieveAllItems();
    }
}
