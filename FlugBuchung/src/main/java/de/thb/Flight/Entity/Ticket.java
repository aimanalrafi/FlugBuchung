package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
// standart Constructor
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Ticket {


    @Id
    private int id ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User")
    private User user ;




    @ManyToOne(fetch = FetchType.EAGER)
    private Flight flight;

    @OneToMany(fetch = FetchType.EAGER)
    private Seat seat;

}
