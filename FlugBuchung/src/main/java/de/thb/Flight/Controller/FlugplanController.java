package de.thb.Flight.Controller;


import de.thb.Flight.Entity.Flugplan;
import de.thb.Flight.Entity.Plan;
import de.thb.Flight.Service.FlightService;
import de.thb.Flight.Service.FlughafenService;
import de.thb.Flight.Service.FlugplanService;
import de.thb.Flight.exceptions.FlugplanNotFoundException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@Controller
@AllArgsConstructor
@RequestMapping("/Flugplan")
public class FlugplanController {
    @Autowired
    FlugplanService flugplanService;
    @Autowired
    FlughafenService flughafenService;
    @Autowired
    FlightService flightService;



    @PostMapping("/add")

    public ResponseEntity<Flugplan> addFp(@ModelAttribute Flugplan flugplan,
                                          @RequestParam(name = "srcFlughafen") String source , @RequestParam(name = "dstnFlughafen") String destination,
                                          @RequestParam(name =  "deptDateTime") String departureTime, @RequestParam(name = "arrDateTime") String arrivalTime){
        Plan plan = new Plan();
        plan.setPlanId(flugplan.getFlugplanId());
        try {
            plan.setSrcFlughafen(flughafenService.viewFlughafen(source));
        } catch (RecordNotFoundException e){
            return new ResponseEntity("Flughafen Not Found", HttpStatus.BAD_REQUEST);
        }
        try {
            plan.setDstnFlughafen(flughafenService.viewFlughafen(destination));
        }catch (RecordNotFoundException e){
            return new ResponseEntity("Flughafen Not Found", HttpStatus.BAD_REQUEST);
        }
        plan.setDeptDateTime(departureTime);
        plan.setArrDateTime(arrivalTime);
        try{
            flugplan.setFlight(flightService.viewFlight(flugplan.getFlugplanId()));
        } catch (RecordNotFoundException e1){
            return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
        }
        flugplan.setPlan(plan);
        flugplan.setAvailableSeats(flugplan.getFlight().getSeatKaptazit());
        try {
            return new ResponseEntity<Flugplan>(flugplanService.addFlugplan(flugplan), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST) ;
        }

    }


    @PutMapping("/modify")
    public ResponseEntity<Flugplan> modifyFlugplan(@ModelAttribute Flugplan flugplan){
        Flugplan modifyFplan = flugplanService.modifyFlugplan(flugplan);
        if (modifyFplan == null){
            return new ResponseEntity("Flight not modifizierbar", HttpStatus.INTERNAL_SERVER_ERROR);

        }else {
            return new ResponseEntity<Flugplan>(modifyFplan, HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete")
    public String deleteFp(@RequestParam BigInteger flightId) throws RecordNotFoundException {
        return flugplanService.removeFlugplan(flightId);
    }
    @GetMapping("/search")
    @ExceptionHandler(FlugplanNotFoundException.class)
    public ResponseEntity<Flugplan> viewSF(@RequestParam BigInteger flightId) throws FlugplanNotFoundException {
        Flugplan searchFplan = flugplanService.viewFlugplan(flightId);
        if (searchFplan == null) {
            return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Flugplan>(searchFplan, HttpStatus.OK);
        }
    }
    @GetMapping("/viewAll")
    public Iterable<Flugplan> viewAllFp() {
        return flugplanService.viewAllFlugplans();
    }
}
