package ulpgc.dacd.gasstations;

import ulpgc.dacd.gasstations.database.GasStationsDatabaseInitializer;
import ulpgc.dacd.gasstations.feeder.GasStationsApiFeeder;
import ulpgc.dacd.gasstations.mapper.GasStationMapper;
import ulpgc.dacd.gasstations.model.GasStation;
import ulpgc.dacd.gasstations.repository.SQLiteGasStationRepository;

import java.util.List;

public class GasStationsMain {
    public static void main(String[] args) {
        System.out.println("--- Iniciando prueba de API ---");

        GasStationsDatabaseInitializer.init();

        GasStationsApiFeeder feeder = new GasStationsApiFeeder();
        GasStationMapper mapper = new GasStationMapper();
        SQLiteGasStationRepository repository = new SQLiteGasStationRepository();

        try {
            String data = feeder.fetch();

            List<GasStation> stations = mapper.map(data);

            System.out.println("Número de gasolineras: " + stations.size());

            for (int i = 0; i < Math.min(5, stations.size()); i++) {
                System.out.println(stations.get(i));
            }

            repository.saveAll(stations);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--- Fin ---");
    }
}