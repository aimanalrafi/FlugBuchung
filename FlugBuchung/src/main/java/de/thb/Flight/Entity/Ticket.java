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
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
