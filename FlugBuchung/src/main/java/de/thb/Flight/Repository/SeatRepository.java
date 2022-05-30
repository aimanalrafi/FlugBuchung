package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Entity.Seat ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Seat.class, idClass = Long.class)
public interface SeatRepository extends CrudRepository <Seat, Long>{

    @Query("SELECT s , f FROM Seat s, Flight f WHERE s.available = true ")
    List<Seat> availableSeats(Flight flight);



}
