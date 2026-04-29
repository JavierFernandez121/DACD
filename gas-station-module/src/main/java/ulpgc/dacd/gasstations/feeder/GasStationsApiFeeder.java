package ulpgc.dacd.gasstations.feeder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GasStationsApiFeeder implements GasStationsFeeder {

    private static final String API_URL =
            "https://energia.serviciosmin.gob.es/ServiciosRestCarburantes/PreciosCarburantes/EstacionesTerrestres/";

    @Override
    public String fetch() {

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0")
                .timeout(Duration.ofSeconds(120))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("STATUS: " + response.statusCode());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error HTTP: " + response.statusCode());
            }

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener los datos de la API", e);
        }
    }
}