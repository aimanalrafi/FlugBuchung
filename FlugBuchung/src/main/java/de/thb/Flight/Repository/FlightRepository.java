package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository

public interface FlightRepository extends CrudRepository<Flight, BigInteger> {

}
