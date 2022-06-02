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

    @OneToOne(mappedBy = "user_id", fetch = FetchType.EAGER)//foreign key of user
    private User user;

    @OneToOne(mappedBy = "flight_id", fetch = FetchType.EAGER)//foreign key of ticket
    private Flight flight;

    @OneToOne(mappedBy = "seat_id", fetch = FetchType.EAGER)//foreign key of ticket
    private Seat seat;


    public Ticket(User user, Flight flight, Seat seat) {
        this.user = user;
        this.flight = flight;
        this.seat = seat;
    }
}
