package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

/**
 * Services should define all the CRUD functions of a specific class (objects)
 * - Create
 * - Read
 * - Update
 * - Delete
 *
 * All are done through FlightRepository
 *
 * Idea Sketch:-
 * The Flight DB contains following attributes
 *     private int id;
 *     //flight nummer
 *     private int nummer;
 *     private String abflugsort;
 *     private String zielort;
 *     private Date departureDate; //time and date
 *     private Date arrivalDate;
 *
 * So just orient the CRUD functions to work with these attributes
 *
 */

@Service
@RequiredArgsConstructor
public class FlightService {

    public static final FlightRepository flightRepository = null;

    public static List<Flight> getAllFlights(){
        return (List<Flight>) flightRepository.findAll();
    }

    public static Optional<Flight> getFlightById(long id){
        Optional<Flight> result = flightRepository.findById(id);
        Flight flights;
        if (result.isPresent()) {
            flights = result.get();
        } else {
            throw new RuntimeException("Did not find flight id");
        }
        return Optional.of(flights);
    }

    public static List<Flight> getFlightByAbflugsort(String abflugsort){
        if(abflugsort != null){
            return flightRepository.searchFlightByAbflugsort(abflugsort);
        } else {
            throw new RuntimeException("Typo? Abflugsort doesn't exist");
        }
    }

    public static List<Flight> getFlightByZielort(String Zielort){
        if(Zielort != null){
            return flightRepository.searchFlightByZielort(Zielort);
        } else {
            throw new RuntimeException("Typo? Zielort doesn't exist");
        }
    }

    public static List<Flight> getFlightByDepartureDate(Date departureDate){
        if(departureDate != null){
            return flightRepository.searchFlightByDepartureDateAsc(departureDate);
        }else {
            throw new RuntimeException("Typo? Departure Date doesn't exist");
        }
    }

    public static List<Flight> getFlightByPriceAsc(){
        return flightRepository.searchFlightByPriceAsc();
    }

    public static List<Flight> getFlightByPriceDesc(){
        return flightRepository.searchFlightByPriceDesc();
    }

    /**
     * Admin functions
     */
    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void deleteFlightById(long id){
        flightRepository.deleteById(id);
    }

    //returns number of flights in DB
    public long CountFlights(){
        return flightRepository.count();
    }



}
