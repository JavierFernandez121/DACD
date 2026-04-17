package ulpgc.dacd.serpapi.model;

public class Trip {

    private double price;
    private String airline;
    private String departureTime;
    private String arrivalTime;

    public Trip(double price, String airline, String departureTime, String arrivalTime) {
        this.price = price;
        this.airline = airline;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public String getAirline() {
        return airline;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
}
