package ulpgc.dacd.gasstations.database;

import java.sql.Connection;
import java.sql.Statement;

public class GasStationsDatabaseInitializer {

    public static void init() {
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement()) {

            String sql = """
                CREATE TABLE IF NOT EXISTS gas_stations (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    cp TEXT,
                    direccion TEXT,
                    localidad TEXT,
                    municipio TEXT,
                    precio_gasolina_95 REAL
                );
            """;

            stmt.execute(sql);
            System.out.println("Tabla creada correctamente ✔");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}