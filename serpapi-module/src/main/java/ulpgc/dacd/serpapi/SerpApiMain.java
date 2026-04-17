package ulpgc.dacd.serpapi;
import ulpgc.dacd.serpapi.feeder.SerpApiHttpFeeder;

public class SerpApiMain {
    public static void main(String[] args) {
        SerpApiHttpFeeder feeder = new SerpApiHttpFeeder();

        String response = feeder.getData();
        System.out.println(response);
    }
}