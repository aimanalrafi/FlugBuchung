package de.thb.Flight.Repository;

import de.thb.Flight.Entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;



@Repository

public interface TicketRepository  extends CrudRepository<Ticket, BigInteger> {


}
