package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    int seatId;
    int seatNumber;
    Flight flight;

}
