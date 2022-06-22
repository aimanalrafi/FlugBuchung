package de.thb.Flight.Service;

import de.thb.Flight.Entity.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface PassengerService {
    public abstract Page<Passenger> getAllPassengersPaged(int pageNum);
    public abstract List<Passenger> getAllPassengers();
    public abstract Passenger getPassengerById(Long passengerId);
    public abstract Passenger savePassenger(Passenger passenger);
    public abstract void deletePassengerById(Long passengerId);
}
