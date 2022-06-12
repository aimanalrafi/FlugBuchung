package de.thb.Flight.Repository;

import de.thb.Flight.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {

}
