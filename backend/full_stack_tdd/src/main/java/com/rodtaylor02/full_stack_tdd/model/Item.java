package com.rodtaylor02.full_stack_tdd.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor @AllArgsConstructor
@Getter @ToString
@Repository
public class Item {

    @Id
    private int id;
    private String name;
    private int price;

    @Transient // Exclude from DB column
    @Setter
    private int value;
}
