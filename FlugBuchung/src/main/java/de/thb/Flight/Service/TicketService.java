package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Entity.Seat;
import de.thb.Flight.Entity.Ticket;
import de.thb.Flight.Entity.User;
import de.thb.Flight.Repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    public final TicketRepository ticketRepository;

    public void createTicket(User user, Flight flight, Seat seat)  {
        LocalDateTime DateTicketCreated  = LocalDateTime.now();
        Ticket ticket = new Ticket(user, flight, seat);
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return (List<Ticket>) ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketByID(long id){
        return ticketRepository.findById(id);
    }

    public Ticket getTicketByUser(User user){
        return ticketRepository.selectByUser(user);
    }

    public void deleteTicketByUser(User user){
        ticketRepository.deleteByUser(user);
    }

    public void deleteTicketById(long id){
        ticketRepository.deleteById(id);
    }









}
