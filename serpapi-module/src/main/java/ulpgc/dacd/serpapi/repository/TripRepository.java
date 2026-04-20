package ulpgc.dacd.serpapi.repository;

import ulpgc.dacd.serpapi.model.Trip;

import java.sql.SQLException;

public interface TripRepository {
    void save(Trip trip) throws SQLException;
}
