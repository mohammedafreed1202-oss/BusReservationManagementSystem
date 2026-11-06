package com.busreservation.model;

public class Ticket {
    private String ticketId;
    private String busId;
    private String busNumber;
    private Passenger passenger;
    private int seatNumber;
    private String source;
    private String destination;
    private double fare;
    private String date;
    private String status;

    public Ticket() {}
    public Ticket(String ticketId, String busId, String busNumber, Passenger passenger, int seatNumber, String source, String destination, double fare, String date, String status) {
        this.ticketId = ticketId;
        this.busId = busId;
        this.busNumber = busNumber;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.date = date;
        this.status = status;
    }
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }
    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return ticketId + " | Bus: " + busNumber + " | " + source + " -> " + destination + " | Passenger: " + (passenger != null ? passenger.getName() : "") + " | Seat: " + seatNumber + " | " + status;
    }
}