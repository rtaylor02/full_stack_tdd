package com.rodtaylor02.full_stack_tdd.business;

import com.rodtaylor02.full_stack_tdd.model.Item;

public class ItemBusinessService {
    public Item retrieveHardCodedItem() {
        Item i = new Item(2, "Lego car", 5, 3);
        System.out.println(i);
        return i;
    }
}
