package de.thb.Flight.Entity;

import javax.persistence.*;
import lombok.*;

//Ticket

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id") //foreign key of ticket
    private User user;

    @OneToOne
    @JoinColumn(name = "flight_id") //foreign key of ticket
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "seat_id") //foreign key of ticket
    private Seat seat;


    public Ticket(User user, Flight flight, Seat seat) {
        this.user = user;
        this.flight = flight;
        this.seat = seat;
    }
}
