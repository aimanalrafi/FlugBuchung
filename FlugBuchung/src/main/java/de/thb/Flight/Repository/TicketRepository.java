package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Ticket ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;


@RepositoryDefinition(domainClass = Ticket.class, idClass = Long.class)
public interface TicketRepository extends CrudRepository <Ticket, Long> {
}
