package de.thb.Flight.Controller;

import de.thb.Flight.Entity.Flughafen;
import de.thb.Flight.Service.FlughafenService;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@AllArgsConstructor
@RequestMapping("/Flughafen")

public class FlughafenController {

    @Autowired
    FlughafenService flughafenService ;

    @GetMapping("/viewFlughafen/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public Flughafen viewFlughafen(@PathVariable("id")String flughafenCode){
        return flughafenService.viewFlughafen(flughafenCode);
    }
    @GetMapping("/allFlughafen")
    public Iterable<Flughafen> viewAllFlughahen(){
        return flughafenService.viewAllFlughahen();
    }
    @PostMapping("/addFlughafen")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public void addAirport(@RequestBody Flughafen flughafen) {
        flughafenService.addFlughafen(flughafen);
    }

    @PostMapping("/updateFlughafen")
    @ExceptionHandler(RecordNotFoundException.class)
    public void modifyFlughafen(@RequestBody Flughafen flughafen){
        flughafenService.modifyFlughafen(flughafen);
    }
    @DeleteMapping("/deleteFlughafen/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public void removeFlughafen(@PathVariable("id") String flughafenCode){
        flughafenService.removeFlughafen(flughafenCode);
    }




}
