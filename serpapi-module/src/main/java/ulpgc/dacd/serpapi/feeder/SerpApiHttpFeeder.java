package ulpgc.dacd.serpapi.feeder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SerpApiHttpFeeder {

    public String getData(String departure, String arrival, String date) {
        OkHttpClient client = new OkHttpClient();

        String apiKey = System.getenv("SERPAPI_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("La variable de entorno SERPAPI_KEY no está definida.");
        }

        String url = "https://serpapi.com/search.json"
                + "?engine=google_flights"
                + "&departure_id=" + departure
                + "&arrival_id=" + arrival
                + "&outbound_date=" + date
                + "&type=2"
                + "&currency=EUR"
                + "&hl=es"
                + "&api_key=" + apiKey;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new RuntimeException("La respuesta de la API no tiene body.");
            }
            return response.body().string();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar SerpApi", e);
        }
    }
}