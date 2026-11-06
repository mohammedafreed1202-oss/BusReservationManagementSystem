package com.busreservation.model;

public class Seat {
    private int seatNumber;
    private boolean booked;
    private String passengerId;

    public Seat() {}
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    public boolean isBooked() { return booked; }
    public void setBooked(boolean booked) { this.booked = booked; }
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
}