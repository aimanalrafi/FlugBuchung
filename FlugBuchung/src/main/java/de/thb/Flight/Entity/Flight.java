package de.thb.Flight.Entity;

import java.util.ArrayList;
import java.util.Date;

public class Flight {

    int id;
    //flight nummer
    int nummer;
    String abflugsort;
    String zielort;
    Date departureDate; //time and date
    Date arrivalDate; //time and date
    ArrayList<Seat> seat;



}
