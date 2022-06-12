package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity

@Table(name = "plan")

public class Plan {


    @Id
    @Column(name = "planId")
    private BigInteger planId;

    @OneToOne(fetch = FetchType.EAGER)
    private Flughafen srcFlughafen;

    @OneToOne(fetch = FetchType.EAGER)
    private Flughafen dstnFlughafen;

    @Column(name = "deptDateTime")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String deptDateTime;

    @Column(name = "arrDateTime")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String arrDateTime;

}
