package com.rodtaylor02.full_stack_tdd.data;

import com.rodtaylor02.full_stack_tdd.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
