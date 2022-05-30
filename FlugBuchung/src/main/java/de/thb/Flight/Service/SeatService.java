package de.thb.Flight.Service;

import de.thb.Flight.Entity.Flight;
import de.thb.Flight.Entity.Seat;
import de.thb.Flight.Repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<Seat> getAllAvailableSeats(Flight flight){
        return seatRepository.availableSeats(flight);
    }

    public List<Seat> getAllSeats(Flight flight){
        return (List<Seat>) seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(long id){
        return seatRepository.findById(id);
    }

    public void addSeat(Seat seat){
        seatRepository.save(seat);
    }

    public void deleteSeatById(long id){
        seatRepository.deleteById(id);
    }




}
