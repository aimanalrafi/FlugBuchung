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

    @ManyToOne(fetch = FetchType.EAGER)//foreign key of user
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    @OneToOne(mappedBy = "seat")
    private User user;

}
