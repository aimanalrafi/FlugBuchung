package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Flight ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
 //Repository
@RepositoryDefinition(domainClass = Flight.class, idClass = Long.class)
public interface FlightRepository extends CrudRepository <Flight, Long> {



}



