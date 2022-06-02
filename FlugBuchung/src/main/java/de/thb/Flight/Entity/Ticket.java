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

    @OneToOne(fetch = FetchType.EAGER)//foreign key of user
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)//foreign key of user
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne(fetch = FetchType.EAGER)//foreign key of user
    @JoinColumn(name = "seat_id")
    private Seat seat;


    public Ticket(User user, Flight flight, Seat seat) {
        this.user = user;
        this.flight = flight;
        this.seat = seat;
    }
}
