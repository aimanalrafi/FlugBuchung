package de.thb.Flight.Entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class Flugplan {

    @Id
    @Column(name = "flugplanId")
    private BigInteger flugplanId;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Flight flight;

    @Column(name = "availableSeats")
    @NotNull
    private Integer availableSeats;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Plan plan;


}
