package ulpgc.dacd.serpapi;

import ulpgc.dacd.serpapi.feeder.SerpApiHttpFeeder;
import ulpgc.dacd.serpapi.mapper.TripMapper;
import ulpgc.dacd.serpapi.model.Trip;

public class SerpApiMain {
    public static void main(String[] args) {
        SerpApiHttpFeeder feeder = new SerpApiHttpFeeder();
        String response = feeder.getData();

        TripMapper mapper = new TripMapper();
        Trip trip = mapper.map(response);

        System.out.println("Price: " + trip.getPrice());
        System.out.println("Airline: " + trip.getAirline());
        System.out.println("Departure: " + trip.getDepartureTime());
        System.out.println("Arrival: " + trip.getArrivalTime());
    }
}