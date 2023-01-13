package com.rodtaylor02.full_stack_tdd.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update(
                "INSERT INTO destinations (place, country, latitude, longitude, info, image) values (?, ?, ?, ?, ?, ?)"
                , "Ålesund"
                , "Norway"
                , 62.5
                , 2.3
                , "Ålesund is a sea port on the west coast of Norway, " +
                        "noted for its beautiful Art Nouveau architecture and spectacular mountain scenery."
                , "alesund.jpg");

        jdbcTemplate.update(
                "INSERT INTO destinations (place, country, latitude, longitude, info, image) values (?, ?, ?, ?, ?, ?)"
                , "Åndalsnes"
                , "Norway"
                , 62.5
                , 7.5
                , "Åndalsnes is a pretty town located on the banks of Isfjorden in Norway, " +
                        "famed for its Trollstigen Road with 11-hairpin corners."
                , "andalsnes.jpg");

        jdbcTemplate.update(
                "INSERT INTO destinations (place, country, latitude, longitude, info, image) values (?, ?, ?, ?, ?, ?)"
                , "Belfast"
                , "Northern Ireland"
                , 54.5
                , -6.0
                ,"Belfast is the capital city of Northern Ireland, and is home of the famous " +
                        "Harland and Wolff shipyard where the Titanic was built."
                ,"belfast.jpg");

        jdbcTemplate.update(
                "INSERT INTO destinations (place, country, latitude, longitude, info, image) values (?, ?, ?, ?, ?, ?)"
                , "Singapore"
                , "Singapore"
                , 1.2
                , 103.9
                , "Singapore is a city-state with a strong history as a trading route and " +
                        "a thriving centre for commerce."
                , "singapore.jpg");

        jdbcTemplate.update(
                "INSERT INTO reviews (destination_id, rating, comment, by) values (?, ?, ?, ?)"
                , 1
                , 5
                , "What an incredibly beautiful place"
                , "J. Smith");

        jdbcTemplate.update(
                "INSERT INTO reviews (destination_id, rating, comment, by) values (?, ?, ?, ?)"
                , 1
                , 4
                , "Spectacular natural beauty, with snow-peaked mountains and crystal sea"
                , "O. Nordmann");

        jdbcTemplate.update(
                "INSERT INTO reviews (destination_id, rating, comment, by) values (?, ?, ?, ?)"
                , 1
                , 5
                , "I wanna go back!"
                , "A. Olsen");

        jdbcTemplate.update(
                "INSERT INTO reviews (destination_id, rating, comment, by) values (?, ?, ?, ?)"
                , 3
                , 5
                , "What an incredible place - I loved the V&A Waterfront"
                , "P. Lafayette");
    }
}
