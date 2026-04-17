package ulpgc.dacd.serpapi.mapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ulpgc.dacd.serpapi.model.Trip;

public class TripMapper {

    public Trip map(String json) {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        JsonArray bestFlights = root.getAsJsonArray("best_flights");
        JsonObject firstBestFlight = bestFlights.get(0).getAsJsonObject();

        double price = firstBestFlight.get("price").getAsDouble();

        JsonArray flights = firstBestFlight.getAsJsonArray("flights");
        JsonObject firstFlight = flights.get(0).getAsJsonObject();

        String airline = firstFlight.get("airline").getAsString();

        JsonObject departureAirport = firstFlight.getAsJsonObject("departure_airport");
        String departureTime = departureAirport.get("time").getAsString();

        JsonObject arrivalAirport = firstFlight.getAsJsonObject("arrival_airport");
        String arrivalTime = arrivalAirport.get("time").getAsString();

        return new Trip(price, airline, departureTime, arrivalTime);
    }
}