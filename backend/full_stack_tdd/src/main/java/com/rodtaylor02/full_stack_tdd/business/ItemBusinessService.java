package com.rodtaylor02.full_stack_tdd.business;

import com.rodtaylor02.full_stack_tdd.data.ItemRepository;
import com.rodtaylor02.full_stack_tdd.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        Item i = new Item(2, "Lego car", 5, 3);
        System.out.println(i);
        return i;
    }

    public List<Item> retrieveAllItems() {
        return itemRepository.findAll();
    }
}
