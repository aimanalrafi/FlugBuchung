package de.thb.Flight.Controller;


import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Service.FlightService;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@AllArgsConstructor
@RequestMapping("/Flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/addFlight")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @GetMapping("/allFlight")
    public Iterable<Flight> viewAllFlight() {
        return flightService.viewAllFlight();
    }

    @GetMapping("/viewFlight/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public Flight viewFlight(@PathVariable("id") BigInteger flightNo) {
        return flightService.viewFlight(flightNo);
    }

    @PutMapping("/updateFlight")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyFlight(@RequestBody Flight flight) {
        flightService.modifyFlight(flight);
    }

    @DeleteMapping("/deleteFlight/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void removeFlight(@PathVariable("id") BigInteger flightNo) {
        flightService.removeFlight(flightNo);
    }
}
