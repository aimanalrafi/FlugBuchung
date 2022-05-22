package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor


public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    //Seat Nummer
    int nummer;
    Flight flight;

}
