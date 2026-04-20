package ulpgc.dacd.serpapi.feeder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SerpApiHttpFeeder {

    private static final String BASE_URL = "https://serpapi.com/search.json";
    private final OkHttpClient client = new OkHttpClient();

    public String getData(String departure, String arrival, String date) {
        String apiKey = System.getenv("SERPAPI_KEY");

        String url = BASE_URL
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
            return response.body().string();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}