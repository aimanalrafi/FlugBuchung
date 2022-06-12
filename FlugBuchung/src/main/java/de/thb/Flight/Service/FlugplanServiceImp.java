package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flugplan;
import de.thb.Flight.Entity.Plan;
import de.thb.Flight.Repository.FlugplanRepository;
import de.thb.Flight.Repository.PlanRepository;
import de.thb.Flight.exceptions.FlugplanNotFoundException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service

public class FlugplanServiceImp implements FlugplanService{


    @Autowired
    FlugplanRepository repository;

    @Autowired
    PlanRepository planRepository;
    @Autowired
    TicketService ticketService;

    @Override
    public Flugplan addFlugplan(Flugplan flugplan) {
        return  repository.save(flugplan);
    }

    @Override
    public Flugplan modifyFlugplan(Flugplan flugplan) {
        Flugplan updateFlugplan = repository.findById(flugplan.getFlugplanId()).get();
        Plan updatePlan = planRepository.findById(flugplan.getPlan().getPlanId()).get();
        updateFlugplan.setAvailableSeats(flugplan.getAvailableSeats());
        updatePlan.setSrcFlughafen(flugplan.getPlan().getSrcFlughafen());
        updatePlan.setDstnFlughafen(flugplan.getPlan().getDstnFlughafen());
        updatePlan.setArrDateTime(flugplan.getPlan().getArrDateTime());
        updatePlan.setDeptDateTime(flugplan.getPlan().getDeptDateTime());
        return flugplan ;

    }

    @Override
    public String removeFlugplan(BigInteger flightId) throws RecordNotFoundException {
        if (flightId == null)
            throw new RecordNotFoundException("Enter flight Id");
        Optional<Flugplan> flugplan = repository.findById(flightId);
        if (!flugplan.isPresent())
            throw new RecordNotFoundException("enter a Valid Id");
        else{
            repository.deleteById(flightId);
        }
        return "Flugplan mit ID" + flightId + "is not found";
    }

    @Override
    public Iterable<Flugplan> viewAllFlugplans() {
        return repository.findAll();
    }

    @Override
    public Flugplan viewFlugplan(BigInteger flightId) throws FlugplanNotFoundException {
        if (flightId == null )
            throw new FlugplanNotFoundException("Enter flight Id");
        Optional<Flugplan> flugplan = repository.findById(flightId);
        if (!flugplan.isPresent())
            throw new FlugplanNotFoundException("Enter a valid Flight Id");
        else
            return flugplan.get();
    }
}
