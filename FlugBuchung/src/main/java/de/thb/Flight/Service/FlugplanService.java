package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flugplan;
import de.thb.Flight.exceptions.FlugplanNotFoundException;
import de.thb.Flight.exceptions.RecordNotFoundException;

import java.math.BigInteger;

public interface FlugplanService {

    public Flugplan addFlugplan(Flugplan flugplan);

    public Flugplan modifyFlugplan(Flugplan flugplan);

    public String removeFlugplan(BigInteger id) throws RecordNotFoundException;

    public Iterable<Flugplan> viewAllFlugplans();

    public Flugplan viewFlugplan(BigInteger id) throws FlugplanNotFoundException;
    // boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;


}
