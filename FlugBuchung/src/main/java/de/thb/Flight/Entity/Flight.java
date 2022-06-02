package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.cfg.AnnotationBinder;

//Flight

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

    @Temporal(TemporalType.DATE)
    private Date departureDate; //time and date

    @Temporal(TemporalType.TIME)
    private Date departureTime; //time and date

    @Temporal(TemporalType.DATE)
    private Date arrivalDate; //time and date

    @Temporal(TemporalType.TIME)
    private Date arrivalTime; //time and date

//    private float price;

//    public float getPrice(float price){
//        return this.price = Seat.getPrice();
//    }

    @OneToMany
    @JoinColumn(name = "seat_id")
    private List<Seat> seat;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;



}
