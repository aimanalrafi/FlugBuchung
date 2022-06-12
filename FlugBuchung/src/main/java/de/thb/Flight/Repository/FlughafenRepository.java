package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Flughafen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlughafenRepository extends CrudRepository<Flughafen, String> {


}
