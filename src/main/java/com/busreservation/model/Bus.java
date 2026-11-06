package com.busreservation.model;
import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String busId;
    private String busNumber;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double fare;
    private List<Seat> seats;

    public Bus() {}

    public Bus(String busId, String busNumber, String source, String destination, int totalSeats, double fare) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }
    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public List<Seat> getSeats() { return seats; }
    public void setSeats(List<Seat> seats) { this.seats = seats; }

    @Override
    public String toString() {
        return busId + " | " + busNumber + " | " + source + " -> " + destination + " | Seats Left: " + availableSeats + " | Fare: " + fare;
    }
}