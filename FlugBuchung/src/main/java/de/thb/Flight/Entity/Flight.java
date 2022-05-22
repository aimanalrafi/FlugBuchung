package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity

@Data
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    //flight nummer
    private int nummer;
    private String abflugsort;
    private String zielort;
    private Date departureDate; //time and date
    private Date arrivalDate; //time and date
    private ArrayList<Seat> seat;



}
