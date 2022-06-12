package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flughafen;
import org.springframework.http.ResponseEntity;

public interface FlughafenService {
    public Iterable<Flughafen> viewAllFlughahen();

    public Flughafen viewFlughafen(String flughafenCode);

    public ResponseEntity<?> addFlughafen(Flughafen flughafen);

    public Flughafen modifyFlughafen(Flughafen flughafen);

    public String removeFlughafen(String flughafenCode);


}
