package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private long passengerId;
    private String firstName;

    private String lastName;
    private String phoneNumber;
    private String passportNumber;

    private String email;

    private String address;

    @ManyToOne
    private Flight flight ;

}
