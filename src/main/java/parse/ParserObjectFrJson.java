package parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.FlightList;

/**
 * class for create list of flights from JSON
 */
public class ParserObjectFrJson {

    private ObjectMapper mapper = new ObjectMapper();

    public FlightList getFlightList(String json) {
        FlightList flightList = new FlightList();
        try {
            flightList = mapper.readValue(json, FlightList.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return flightList;
    }
}
