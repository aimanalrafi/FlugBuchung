package de.thb.Flight.Service;


import de.thb.Flight.Entity.Flughafen;
import de.thb.Flight.Repository.FlughafenRepository;
import de.thb.Flight.exceptions.RecordAlreadyPresentException;
import de.thb.Flight.exceptions.RecordNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class FlughafenServiceImp implements FlughafenService {
    @Autowired
    FlughafenRepository flughafenRepository ;
    @Override
    public Iterable<Flughafen> viewAllFlughahen(){
        return flughafenRepository.findAll();
    };

    @Override
    public Flughafen viewFlughafen(String flughafenCode){
        Optional<Flughafen> findById = flughafenRepository.findById(flughafenCode);
        if (findById.isPresent()){
            return findById.get();
        }

        else
            throw new RecordNotFoundException("Flughafen mit flughafen code :" + flughafenCode + "not exists");



    }

    @Override

    public ResponseEntity<?> addFlughafen(Flughafen flughafen){

        Optional<Flughafen> findById = flughafenRepository.findById(flughafen.getFlughafenCode());
        try {
            if(!findById.isPresent()){
                flughafenRepository.save(flughafen);
                return new ResponseEntity<Flughafen>(flughafen, HttpStatus.OK);

            }
            else
                throw new RecordAlreadyPresentException(
                        "Flughafen mit Code : " + flughafen.getFlughafenCode() + "schon da");



        }
        catch ( RecordAlreadyPresentException e){
            return new ResponseEntity<Flughafen>(flughafen, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Flughafen modifyFlughafen(Flughafen flughafen) {
        Optional<Flughafen> findById = flughafenRepository.findById(flughafen.getFlughafenCode());

        if(findById.isPresent()){
            flughafenRepository.save(flughafen);
        }
        else
            throw new RecordNotFoundException("Flughafen mit code: " + flughafen.getFlughafenCode() + "exitiert nicht");
        return flughafen;
    }

    @Override
    public String removeFlughafen(String flughafenCode) {
        Optional<Flughafen> findById = flughafenRepository.findById(flughafenCode);

        if(findById.isPresent()){
            flughafenRepository.deleteById(flughafenCode);
            return "Flughafen gelöscht";
        } else
            throw new RecordNotFoundException("Flughafen mit Code: " + flughafenCode +"exitiert nicht");
    }


}
