package de.thb.Flight.Repository;


import de.thb.Flight.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT m from User m WHERE m.vorname=:vorname")
    List<User> searchUserByVorname(String vorname);


    @Query("SELECT m from User m WHERE m.nachname=:nachname")
    List<User> searchUserByNachname(String Nachname);




}
