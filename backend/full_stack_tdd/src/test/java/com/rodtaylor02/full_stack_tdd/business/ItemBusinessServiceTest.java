package com.rodtaylor02.full_stack_tdd.business;

import com.rodtaylor02.full_stack_tdd.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Test
    void retrieveHardCodedItem() {
        Item item = itemBusinessService.retrieveHardCodedItem();

        assertEquals("Lego car", item.getName());
    }
}