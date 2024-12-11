package com.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class View1 {
    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private Long numBusinesses;
    private Long numPlaces;
    private Long highs;
    private Long lows;
    private Long debt;

    public View1(String username, String firstName, String lastName, String address, Long numBusinesses,
    Long numPlaces, Long highs, Long lows, Long debt) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.numBusinesses = numBusinesses;
        this.numPlaces = numPlaces;
        this.highs = highs;
        this.lows = lows;
        this.debt = debt;
    }
}