package de.thb.Flight.Repository;

import de.thb.Flight.Entity.Flugplan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository

public interface FlugplanRepository extends CrudRepository<Flugplan, BigInteger> {
}