package com.rodtaylor02.full_stack_tdd.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor @AllArgsConstructor // No args constructor needed for Spring Data JPA
@Setter @Getter // Getters and setters required for Jackson's serialisation
@EqualsAndHashCode
@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id = -1;

    public int rating;
    public String comment;
    public String by;
}
