import analysis.FlightStatistic;
import file.FileWorker;
import parse.ParserObjectFrJson;

/**
 * main class for start app
 */
public class main {
    public static void main(String[] args) {
        FlightStatistic statistic = new FlightStatistic();
        ParserObjectFrJson parser = new ParserObjectFrJson();
        String json = FileWorker.readTextFromFile(args[0]);
        statistic.createStatisticForFlights("Москва", "Хабаровск", parser.getFlightList(json).getFlights());
        System.out.println("Минимальная стоимость перелета  " + statistic.getMinPay());
        System.out.println("Средняя стоимость перелета  " + statistic.getAveragePay());
        System.out.println("Максимальная стоимость перелета  " + statistic.getMaxPay());
    }
}
