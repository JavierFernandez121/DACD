package ulpgc.dacd.serpapi.mapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ulpgc.dacd.serpapi.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripMapper {

    public List<Trip> map(String json) {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        JsonArray bestFlights = root.getAsJsonArray("best_flights");
        List<Trip> trips = new ArrayList<>();

        for (int i = 0; i < bestFlights.size(); i++) {
            JsonObject option = bestFlights.get(i).getAsJsonObject();

            double price = option.get("price").getAsDouble();
            String type = option.get("type").getAsString();
            int totalDuration = option.get("total_duration").getAsInt();

            JsonObject firstFlight = option
                    .getAsJsonArray("flights")
                    .get(0)
                    .getAsJsonObject();

            String airline = firstFlight.get("airline").getAsString();
            String flightNumber = firstFlight.get("flight_number").getAsString();
            int duration = firstFlight.get("duration").getAsInt();
            String travelClass = firstFlight.get("travel_class").getAsString();

            JsonObject departureAirport = firstFlight.getAsJsonObject("departure_airport");
            String departureAirportId = departureAirport.get("id").getAsString();
            String departureTime = departureAirport.get("time").getAsString();

            JsonObject arrivalAirport = firstFlight.getAsJsonObject("arrival_airport");
            String arrivalAirportId = arrivalAirport.get("id").getAsString();
            String arrivalTime = arrivalAirport.get("time").getAsString();

            Trip trip = new Trip(
                    price,
                    type,
                    airline,
                    flightNumber,
                    departureAirportId,
                    departureTime,
                    arrivalAirportId,
                    arrivalTime,
                    duration,
                    totalDuration,
                    travelClass
            );

            trips.add(trip);
        }

        return trips;
    }
}