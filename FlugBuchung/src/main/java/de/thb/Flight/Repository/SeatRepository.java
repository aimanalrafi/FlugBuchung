package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Seat ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Seat.class, idClass = Long.class)
public interface SeatRepository extends CrudRepository <Seat, Long>{


}
