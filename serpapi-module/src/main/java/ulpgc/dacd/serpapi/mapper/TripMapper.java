package ulpgc.dacd.serpapi.mapper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ulpgc.dacd.serpapi.model.Trip;

public class TripMapper {

    public Trip map(String json) {
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        JsonObject firstOption = root
                .getAsJsonArray("best_flights")
                .get(0)
                .getAsJsonObject();

        double price = firstOption.get("price").getAsDouble();
        String type = firstOption.get("type").getAsString();
        int totalDuration = firstOption.get("total_duration").getAsInt();

        JsonObject firstFlight = firstOption
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

        return new Trip(
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
    }
}