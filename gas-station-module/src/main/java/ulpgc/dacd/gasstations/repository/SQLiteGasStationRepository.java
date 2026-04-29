package ulpgc.dacd.gasstations.repository;

import ulpgc.dacd.gasstations.database.SQLiteConnection;
import ulpgc.dacd.gasstations.model.GasStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class SQLiteGasStationRepository implements GasStationRepository {

    @Override
    public void saveAll(List<GasStation> stations) {

        String sql = """
                INSERT INTO gas_stations (cp, direccion, localidad, municipio, precio_gasolina_95)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (GasStation s : stations) {
                stmt.setString(1, s.getCp());
                stmt.setString(2, s.getDireccion());
                stmt.setString(3, s.getLocalidad());
                stmt.setString(4, s.getMunicipio());
                stmt.setDouble(5, s.getPrecioGasolina95());
                stmt.addBatch();
            }

            stmt.executeBatch();

            System.out.println("Datos guardados en la base de datos ✔");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}