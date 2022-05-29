package de.thb.Flight.Repository;


import de.thb.Flight.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;





public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT m from User m WHERE m.vorname=:vorname")
    User getUserByVorname(String vorname);


    @Query("SELECT m from User m WHERE m.Nachname=:Nachname")
    User getUserByNachname(String Nachname);




}
