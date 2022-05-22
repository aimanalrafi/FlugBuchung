package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.*;


@Data
@Entity
@AllArgsConstructor
public class User {
    /*
    Primary Key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vorname;
    private String nachname;
    private String roles;

    @NotNull
    String email;

    @NotNull
    private String password;

    public User(){
        setRoles("USER");
    }



    public String getFullname(){
        return this.getVorname() + " " + this.getNachname();
    }

}
