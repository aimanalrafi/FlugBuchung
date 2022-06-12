package de.thb.Flight.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reisender")
public class Reisender {

    @Id
    private BigInteger reisenderID;
    private String reisenderName;
    private int reisenderAge;
    private BigInteger reisenderUIN;

}
