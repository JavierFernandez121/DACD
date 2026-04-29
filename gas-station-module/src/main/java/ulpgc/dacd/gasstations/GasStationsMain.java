package ulpgc.dacd.gasstations;

import ulpgc.dacd.gasstations.feeder.GasStationsApiFeeder;

public class GasStationsMain {
    public static void main(String[] args) {
        System.out.println("--- Iniciando prueba de API ---");

        GasStationsApiFeeder feeder = new GasStationsApiFeeder();

        try {
            String data = feeder.fetch();

            System.out.println("Datos recibidos correctamente");
            System.out.println("Longitud: " + data.length());
            System.out.println(data.substring(0, Math.min(300, data.length())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--- Fin ---");
    }
}