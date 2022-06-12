package de.thb.Flight.Entity;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    private BigInteger flightNo;
    private String carrierName;
    private String flightModel;
    private int seatKaptazit;


    @Override
    public String toString() {
        return "Flight [flightNo=" + flightNo + ",carrierName=" + carrierName + ",flightModel=" + flightModel
                + ",seatKaptazit=" + seatKaptazit + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carrierName == null) ? 0 : carrierName.hashCode());
        result = prime * result + ((flightModel == null) ? 0 : flightModel.hashCode());
        result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
        result = prime * result + seatKaptazit;
        return result;


    }









}