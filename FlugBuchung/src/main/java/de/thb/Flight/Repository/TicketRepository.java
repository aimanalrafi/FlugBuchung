package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Ticket ;
import de.thb.Flight.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;


@RepositoryDefinition(domainClass = Ticket.class, idClass = Long.class)
public interface TicketRepository extends CrudRepository <Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.user.id =: id")
    Ticket selectByUser(User user);

    @Query("SELECT t FROM Ticket t WHERE t.user.id =: id")
    Ticket deleteByUser(User user);
}
