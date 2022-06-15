package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Airport {


    @Id
    @GeneratedValue
    private int airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String state;
    private String country;


    @OneToMany(mappedBy = "departureAirport")
    List<Flight> flights = new ArrayList<Flight>();

}
