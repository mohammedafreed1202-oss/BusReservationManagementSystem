package com.busreservation.persistence;
import com.busreservation.model.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationData {
    private List<Bus> buses = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public ReservationData() {}
    public List<Bus> getBuses() { return buses; }
    public void setBuses(List<Bus> buses) { this.buses = buses; }
    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }
    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}