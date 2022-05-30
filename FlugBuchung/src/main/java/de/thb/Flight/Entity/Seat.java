package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Seat

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

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

}
