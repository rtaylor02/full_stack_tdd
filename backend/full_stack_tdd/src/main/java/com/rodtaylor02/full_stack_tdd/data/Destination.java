package com.rodtaylor02.full_stack_tdd.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor // No args constructor needed for Spring Data JPA
@Setter @Getter // Getters and setters required for Jackson's serialisation
@EqualsAndHashCode
@Entity(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id = -1;

    public String place;
    private String country;
    private double latitude;
    private double longitude;
    private String info;
    private String image;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="DESTINATION_ID")
    private List<Review> reviews;
}
