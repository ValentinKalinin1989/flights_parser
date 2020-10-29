package model;

import java.util.List;

/**
 * class for using in Jackson
 * for convert Json to list of Flights
 */
public class FlightList {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
