package com.rodtaylor02.full_stack_tdd.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@NoArgsConstructor @AllArgsConstructor
@Getter @ToString
@Entity
@Table(name = "item")
public class Item {

    @Id
    private int id;
    private String name;
    private int price;

    @Transient // Exclude from DB column
    @Setter
    private int value;
}
