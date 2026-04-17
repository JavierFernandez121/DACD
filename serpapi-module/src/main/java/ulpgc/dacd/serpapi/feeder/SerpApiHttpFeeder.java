package ulpgc.dacd.serpapi.feeder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SerpApiHttpFeeder {

    public String getData() {
        OkHttpClient client = new OkHttpClient();

        String apiKey = "REMOVED";
        String url = "https://serpapi.com/search.json?q=google&api_key=" + apiKey;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}