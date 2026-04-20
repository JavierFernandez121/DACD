package ulpgc.dacd.serpapi;

import ulpgc.dacd.serpapi.database.SerpApiDatabaseInitializer;
import ulpgc.dacd.serpapi.feeder.SerpApiHttpFeeder;
import ulpgc.dacd.serpapi.mapper.TripMapper;
import ulpgc.dacd.serpapi.model.Trip;
import ulpgc.dacd.serpapi.repository.SQLiteTripRepository;

public class SerpApiMain {
    public static void main(String[] args) {
        try {
            SerpApiDatabaseInitializer db = new SerpApiDatabaseInitializer();
            db.initialize();

            SerpApiHttpFeeder feeder = new SerpApiHttpFeeder();
            String response = feeder.getData();

            TripMapper mapper = new TripMapper();
            Trip trip = mapper.map(response);

            SQLiteTripRepository repository = new SQLiteTripRepository(db);
            repository.save(trip);

            System.out.println("Trip guardado en la base de datos");
            repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}