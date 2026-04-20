package ulpgc.dacd.serpapi.repository;

import ulpgc.dacd.serpapi.database.SerpApiDatabaseInitializer;
import ulpgc.dacd.serpapi.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTripRepository implements TripRepository {

    private final SerpApiDatabaseInitializer database;

    public SQLiteTripRepository(SerpApiDatabaseInitializer database) {
        this.database = database;
    }

    @Override
    public void save(Trip trip) throws SQLException {
        String sql = """
        INSERT INTO trips (
            price,
            type,
            airline,
            flight_number,
            departure_airport_id,
            departure_time,
            arrival_airport_id,
            arrival_time,
            duration,
            total_duration,
            travel_class,
            captured_at
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection connection = database.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, trip.getPrice());
            statement.setString(2, trip.getType());
            statement.setString(3, trip.getAirline());
            statement.setString(4, trip.getFlightNumber());
            statement.setString(5, trip.getDepartureAirportId());
            statement.setString(6, trip.getDepartureTime());
            statement.setString(7, trip.getArrivalAirportId());
            statement.setString(8, trip.getArrivalTime());
            statement.setInt(9, trip.getDuration());
            statement.setInt(10, trip.getTotalDuration());
            statement.setString(11, trip.getTravelClass());
            statement.setString(12, java.time.LocalDateTime.now().toString());

            statement.executeUpdate();
        }
    }

    public void findAll() throws SQLException {
        String sql = "SELECT * FROM trips";

        try (Connection connection = database.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Price: " + resultSet.getDouble("price"));
                System.out.println("Type: " + resultSet.getString("type"));
                System.out.println("Airline: " + resultSet.getString("airline"));
                System.out.println("Flight: " + resultSet.getString("flight_number"));
                System.out.println("Departure airport: " + resultSet.getString("departure_airport_id"));
                System.out.println("Departure time: " + resultSet.getString("departure_time"));
                System.out.println("Arrival airport: " + resultSet.getString("arrival_airport_id"));
                System.out.println("Arrival time: " + resultSet.getString("arrival_time"));
                System.out.println("Duration: " + resultSet.getInt("duration"));
                System.out.println("Total duration: " + resultSet.getInt("total_duration"));
                System.out.println("Travel class: " + resultSet.getString("travel_class"));
                System.out.println("Captured at: " + resultSet.getString("captured_at"));
                System.out.println("-----");
            }
        }
    }
}