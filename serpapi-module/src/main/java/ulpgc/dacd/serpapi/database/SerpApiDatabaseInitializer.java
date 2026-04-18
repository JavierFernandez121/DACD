package ulpgc.dacd.serpapi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SerpApiDatabaseInitializer {

    private static final String DATABASE_URL = "jdbc:sqlite:serpapi.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public void initialize() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS trips (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    price REAL NOT NULL,
                    type TEXT NOT NULL,
                    airline TEXT NOT NULL,
                    flight_number TEXT NOT NULL,
                    departure_airport_id TEXT NOT NULL,
                    departure_time TEXT NOT NULL,
                    arrival_airport_id TEXT NOT NULL,
                    arrival_time TEXT NOT NULL,
                    duration INTEGER NOT NULL,
                    total_duration INTEGER NOT NULL,
                    travel_class TEXT NOT NULL
                );
                """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
}