package analysis;

import file.FileWorker;
import model.Flight;
import model.FlightList;
import org.junit.Test;
import parse.ParserObjectFrJson;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightStatisticTest {

    @Test
    public void createStatisticForFlights() {
        String json = FileWorker.readTextFromFile("src/test/java/analysis/flights.json");
        ParserObjectFrJson parser = new ParserObjectFrJson();
        FlightList flightList = parser.getFlightList(json);
        List<Flight> flights = flightList.getFlights();
        FlightStatistic statistic = new FlightStatistic();
        statistic.createStatisticForFlights("Москва", "Хабаровск", flights);
        assertEquals(11000L, statistic.getMinPay().longValue());
        assertEquals(11832L, statistic.getAveragePay().longValue());
        assertEquals(12500L, statistic.getMaxPay().longValue());
    }

}