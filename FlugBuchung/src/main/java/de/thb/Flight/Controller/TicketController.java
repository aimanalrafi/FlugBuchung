package de.thb.Flight.Controller;


import de.thb.Flight.Entity.Ticket;
import de.thb.Flight.Service.TicketService;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@AllArgsConstructor
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    TicketService ticketService ;
    @PostMapping("/createTicket")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addTicket(@RequestBody Ticket newTicket){
        ticketService.createTicket(newTicket);
    }
    @GetMapping("/readAllTicket")
    public Iterable<Ticket> readAllTicket(){
        return ticketService.displayAllTicket();
    }
    @PutMapping("/updateTicket")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyTicket(@RequestBody Ticket updateTicket){
        ticketService.updateTicket(updateTicket);
    }
    @GetMapping("/searchTicket/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> searchTicketByID(@PathVariable("id")BigInteger ticketId){
        return ticketService.findTicketById(ticketId) ;

    }
    @DeleteMapping("/deleteTicket/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void deletTicketByID(@PathVariable("id") BigInteger ticketId){

            ticketService.deleteTicket(ticketId);
        }


}
