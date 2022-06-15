package de.thb.Flight.Service;

import de.thb.Flight.Entity.Aircraft;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AircraftService {
    public abstract Page<Aircraft> getAllAircraftsPaged(int pageNum);
    public abstract List<Aircraft> getAllAircrafts();
    public abstract Aircraft getAircraftById(Long aircraftId);
    public abstract Aircraft saveAircraft(Aircraft aircraft);
    public abstract void deleteAircraftById(Long aircraftId);
}
