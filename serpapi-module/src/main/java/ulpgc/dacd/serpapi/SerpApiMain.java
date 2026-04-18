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
        System.out.println("Type: " + trip.getType());
        System.out.println("Airline: " + trip.getAirline());
        System.out.println("Flight number: " + trip.getFlightNumber());
        System.out.println("Departure airport: " + trip.getDepartureAirportId());
        System.out.println("Departure time: " + trip.getDepartureTime());
        System.out.println("Arrival airport: " + trip.getArrivalAirportId());
        System.out.println("Arrival time: " + trip.getArrivalTime());
        System.out.println("Duration: " + trip.getDuration());
        System.out.println("Total duration: " + trip.getTotalDuration());
        System.out.println("Travel class: " + trip.getTravelClass());
    }
}