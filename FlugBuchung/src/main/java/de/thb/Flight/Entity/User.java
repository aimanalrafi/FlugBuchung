package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.*;

//User

@Data
@Entity
@AllArgsConstructor
@Table(name = "User")
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
    @Column(nullable = false, unique = true)
    String email;

    @NotNull
    private String password;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public User(){
        setRoles("USER");
    }



    public String getFullname(){
        return this.getVorname() + " " + this.getNachname();
    }

}
