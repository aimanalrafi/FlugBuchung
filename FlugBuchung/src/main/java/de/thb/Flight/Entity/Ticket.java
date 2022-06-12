package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ticket {


    @Id
    private BigInteger ticketId;
    private String ticketDate;
    private int numberMitR;

}
