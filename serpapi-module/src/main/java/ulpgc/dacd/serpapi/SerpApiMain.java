package ulpgc.dacd.serpapi;

import ulpgc.dacd.serpapi.database.SerpApiDatabaseInitializer;
import ulpgc.dacd.serpapi.feeder.SerpApiHttpFeeder;
import ulpgc.dacd.serpapi.mapper.TripMapper;
import ulpgc.dacd.serpapi.model.Trip;
import ulpgc.dacd.serpapi.repository.SQLiteTripRepository;

import java.util.List;

public class SerpApiMain {
    public static void main(String[] args) {
        SerpApiDatabaseInitializer db = new SerpApiDatabaseInitializer();
        db.initialize();

        SerpApiHttpFeeder feeder = new SerpApiHttpFeeder();
        String response = feeder.getData("LPA", "MAD", "2026-05-10");

        TripMapper mapper = new TripMapper();
        List<Trip> trips = mapper.map(response);

        SQLiteTripRepository repository = new SQLiteTripRepository(db);

        for (Trip trip : trips) {
            repository.save(trip);
        }
    }
}