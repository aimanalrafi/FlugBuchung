package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Seats {
    int seatNumber;
    Flight flight;
    Customer vorname;
    Customer nachname;
}
