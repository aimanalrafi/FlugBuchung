package de.thb.Flight.Controller;


import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/Home")
public class FlightController {


    private final FlightService flightService;

    @GetMapping("/flights")
    public String showFlights(Model model) {
        List<Flight>flights = FlightService.getAllFlights();
        model.addAttribute("flights",flights);

        return "flights";
    }

    @GetMapping("/flightsById")
    public String showFlightsById(@Param("Fid") long Fid, Model model) {
        Optional<Flight> flights = FlightService.getFlightById(Fid);
        model.addAttribute("flights",flights);

        return "flights";
    }

    @GetMapping("/flightsByAbflugsort")
    public String showFlightsByAbflugsort(@Param("fAbflugsOrt") String fAbflugsort, Model model) {
        List<Flight>flights = FlightService.getFlightByAbflugsort(fAbflugsort);
        model.addAttribute("flights",flights);

        return "flights";
    }

    @GetMapping("/flightsByZielort")
    public String showFlightsByZielort(@Param("fZielort") String fZielort, Model model) {
        List<Flight> flights = FlightService.getFlightByZielort(fZielort);
        model.addAttribute("flights", flights);

        return "flights";
    }

    @GetMapping("/flightsByDepartureDate")
    public String showFlightsByDepartureDate(@Param("fDate") Date fDate, Model model) {
        List<Flight> flights = FlightService.getFlightByDepartureDate(fDate);
        model.addAttribute("flights", flights);

        return "flights";
    }

    @GetMapping("/flightsByPriceAsc")
    public String showFlightsByPriceAsc(Model model) {
        List<Flight> flights = FlightService.getFlightByPriceAsc();
        model.addAttribute("flights", flights);

        return "flights";
    }

    @GetMapping("/flightsByPriceDesc")
    public String showFlightsByPriceDesc(Model model) {
        List<Flight> flights = FlightService.getFlightByPriceDesc();
        model.addAttribute("flights", flights);

        return "flights";
    }
}

