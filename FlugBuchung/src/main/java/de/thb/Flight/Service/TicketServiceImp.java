package de.thb.Flight.Service;

import de.thb.Flight.Entity.Ticket;
import de.thb.Flight.Repository.TicketRepository;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;



@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public ResponseEntity<?> createTicket(Ticket newTicket) {

        Optional<Ticket> findTicketById = ticketRepository.findById(newTicket.getTicketId());
        try {
            if (!findTicketById.isPresent()) {
                ticketRepository.save(newTicket);
                return new ResponseEntity<Ticket>(newTicket, HttpStatus.OK);
            } else
                throw new RecordAlreadyPresentException(
                        "Ticket mit Ticket Id: " + newTicket.getTicketId() + " schon exitiert");


        } catch (RecordAlreadyPresentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public Ticket updateTicket(Ticket changedTicket) {
        Optional<Ticket> findTicketById = ticketRepository.findById(changedTicket.getTicketId());

        if (findTicketById.isPresent()) {
            ticketRepository.save(changedTicket);
        } else
            throw new RecordNotFoundException(
                    "Ticket mit Ticket Id: " + changedTicket.getTicketId() + " not exists!!");
        return changedTicket;


    }

    @Override
    public String deleteTicket(BigInteger ticketId) {

        Optional<Ticket> findTicketById = ticketRepository.findById(ticketId);
        if (findTicketById.isPresent()) {
            ticketRepository.deleteById(ticketId);
            return "Ticket gelöscht";


        } else
            throw new RecordNotFoundException("Booking not found for the entered BookingID");


    }

    @Override
    public Iterable<Ticket> displayAllTicket() {

        return ticketRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findTicketById(BigInteger ticketId) {
        Optional<Ticket> findById = ticketRepository.findById(ticketId);
        try {
            if (findById.isPresent()) {
                Ticket findTicket = findById.get();
                return new ResponseEntity<Ticket>(findTicket, HttpStatus.OK);
            } else
                throw new RecordNotFoundException("No record found with ID " + ticketId);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
