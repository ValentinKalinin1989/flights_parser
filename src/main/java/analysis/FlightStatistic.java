package analysis;

import model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class for create statistic for flights
 */
public class FlightStatistic {
    private Integer minPay = 0;
    private Integer maxPay = 0;
    private Integer averagePay = 0;

    public Integer getMinPay() {
        return minPay;
    }

    public Integer getMaxPay() {
        return maxPay;
    }

    public Integer getAveragePay() {
        return averagePay;
    }

    /**
     * create statistic for price
     *
     * @param fromTown - start town
     * @param toCity   - end town
     * @param flights  - list of flights
     */
    public void createStatisticForFlights(String fromTown, String toCity, List<Flight> flights) {
        List<Flight> forStatFlights = createListOfSameFlights(fromTown, toCity, flights);
        Integer numOfFlights = forStatFlights.size();
        forStatFlights.forEach(flight -> {
            Integer price = flight.getPrice();
            averagePay += price / numOfFlights;
            if (price > maxPay) {
                maxPay = price;
            }
            if (minPay == 0) {
                minPay = price;
            } else if (price < minPay) {
                minPay = price;
            }
        });
    }

    /**
     * create list of same flights
     *
     * @param fromTown - start town
     * @param toCity   - end town
     * @param flights  - list of flights
     * @return - list of same flights
     */
    private List<Flight> createListOfSameFlights(String fromTown, String toCity, List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getFromCity().equals(fromTown) && flight.getToCity().equals(toCity))
                .collect(Collectors.toList());
    }
}
