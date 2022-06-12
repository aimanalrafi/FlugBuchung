package de.thb.Flight.Service;

import de.thb.Flight.Entity.Ticket;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;

public interface TicketService {

    public ResponseEntity<?> createTicket(Ticket newTicket);

    public Ticket updateTicket(Ticket changedTicket);

    public String deleteTicket(BigInteger ticketId);

    public Iterable<Ticket> displayAllTicket();

    public ResponseEntity<?> findTicketById(BigInteger ticketId);

}
