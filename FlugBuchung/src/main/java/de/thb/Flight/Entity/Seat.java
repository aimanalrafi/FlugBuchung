package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Seat Nummer
    private int nummer;
    private float price;

    //Attribute to check if seat is available
    private boolean available;

    //@ManyToOne(mappedBy = "seat_id", fetch = FetchType.EAGER)
    @OneToOne(mappedBy = "flight_id", fetch = FetchType.EAGER)
    private Flight flight;

    @OneToOne(mappedBy = "ticket_id", fetch = FetchType.EAGER)
    private Ticket ticket;

}
