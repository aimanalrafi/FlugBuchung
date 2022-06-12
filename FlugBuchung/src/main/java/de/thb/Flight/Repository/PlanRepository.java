package de.thb.Flight.Repository;


import de.thb.Flight.Entity.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface PlanRepository extends CrudRepository<Plan, BigInteger> {

}
