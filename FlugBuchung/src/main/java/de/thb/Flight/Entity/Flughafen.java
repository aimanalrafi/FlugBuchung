package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Flughafen")

public class Flughafen {

    @GeneratedValue(strategy = GenerationType.AUTO)

        @Id
        private String flughafenCode;
        private String flughafenLocation;
        private String flughafenName;



    @Override
    public String toString() {
        return "flughafen{" + "flughafenName='" + flughafenName + '\'' + ", flughafenLocation='" + flughafenLocation + '\''
                + ", flughafenCode='" + flughafenCode + '\'' + '}';
    }


}
