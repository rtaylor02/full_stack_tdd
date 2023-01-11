package com.rodtaylor02.full_stack_tdd.controllers;

import com.rodtaylor02.full_stack_tdd.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/dummyitem")
    public Item dummyItem() {
        Item i = new Item(1,"london bus", 12, 9);
        System.out.println(i);
        return i;
    }

}
