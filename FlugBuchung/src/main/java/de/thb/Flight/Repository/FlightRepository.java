package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Flight ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.*;

/**
 * The RepositoryDefinition annotation provides a convenient way to limit the exposure of unwanted or potentially dangerous methods and fine tune the repository.
 */
@RepositoryDefinition(domainClass = Flight.class, idClass = Long.class)
public interface FlightRepository extends CrudRepository <Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.abflugsort like %:abflugsort")
    List<Flight> searchFlightByAbflugsort(String Abflugsort);

    @Query("SELECT f FROM Flight f WHERE f.zielort like %:zielort")
    List<Flight> searchFlightByZielort(String zielort);

    @Query("SELECT f, s FROM Flight f, Seat s order by s.price asc")
    List<Flight> searchFlightByPriceAsc();

    @Query("SELECT f, s FROM Flight f, Seat s order by s.price desc")
    List<Flight> searchFlightByPriceDesc();

    @Query("SELECT f FROM Flight f order by f.departureDate asc")
    List<Flight> searchFlightByDepartureDateAsc(Date departureDate);
}

