package de.thb.Flight.Repository;


import de.thb.Flight.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;



@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository extends  CrudRepository <User, Long> {


}
