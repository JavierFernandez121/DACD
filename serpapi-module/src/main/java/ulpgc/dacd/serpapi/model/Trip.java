package ulpgc.dacd.serpapi.model;

public class Trip {
    private final double price;
    private final String type;
    private final String airline;
    private final String flightNumber;
    private final String departureAirportId;
    private final String departureTime;
    private final String arrivalAirportId;
    private final String arrivalTime;
    private final int duration;
    private final int totalDuration;
    private final String travelClass;

    public Trip(double price, String type, String airline, String flightNumber,
                String departureAirportId, String departureTime,
                String arrivalAirportId, String arrivalTime,
                int duration, int totalDuration, String travelClass) {
        this.price = price;
        this.type = type;
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirportId = departureAirportId;
        this.departureTime = departureTime;
        this.arrivalAirportId = arrivalAirportId;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.totalDuration = totalDuration;
        this.travelClass = travelClass;
    }

    public double getPrice() { return price; }
    public String getType() { return type; }
    public String getAirline() { return airline; }
    public String getFlightNumber() { return flightNumber; }
    public String getDepartureAirportId() { return departureAirportId; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalAirportId() { return arrivalAirportId; }
    public String getArrivalTime() { return arrivalTime; }
    public int getDuration() { return duration; }
    public int getTotalDuration() { return totalDuration; }
    public String getTravelClass() { return travelClass; }

    @Override
    public String toString() {
        return "Trip{" +
                "price=" + price +
                ", airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departure='" + departureAirportId + " " + departureTime + '\'' +
                ", arrival='" + arrivalAirportId + " " + arrivalTime + '\'' +
                '}';
    }
}