package com.busreservation.service;
import com.busreservation.model.*;
import com.busreservation.persistence.JsonFileManager;
import com.busreservation.persistence.ReservationData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationService {
    private ReservationData data;

    public ReservationService() {
        this.data = JsonFileManager.loadData();
        if (data.getBuses() == null) data.setBuses(new ArrayList<>());
        if (data.getPassengers() == null) data.setPassengers(new ArrayList<>());
        if (data.getTickets() == null) data.setTickets(new ArrayList<>());
        if (data.getBuses().isEmpty()) {
            addBus(new Bus("B1", "AP-01-1234", "Vijayawada", "Hyderabad", 40, 500));
            addBus(new Bus("B2", "AP-02-5678", "Vijayawada", "Vizag", 40, 600));
            addBus(new Bus("B3", "AP-03-9999", "Guntur", "Hyderabad", 30, 450));
            save();
        }
    }
    public void save() { JsonFileManager.saveData(data); }
    public void addBus(Bus bus) { data.getBuses().add(bus); }
    public List<Bus> getAllBuses() { return data.getBuses(); }
    public List<Bus> searchBuses(String source, String destination) {
        List<Bus> result = new ArrayList<>();
        for (Bus b : data.getBuses()) {
            if (b.getSource().equalsIgnoreCase(source) && b.getDestination().equalsIgnoreCase(destination)) result.add(b);
        }
        return result;
    }
    public Bus findBusById(String busId) {
        for (Bus b : data.getBuses()) if (b.getBusId().equals(busId)) return b;
        return null;
    }
    public Ticket bookTicket(String busId, Passenger passenger, int seatNumber) {
        Bus bus = findBusById(busId);
        if (bus == null) return null;
        for (Seat seat : bus.getSeats()) {
            if (seat.getSeatNumber() == seatNumber) {
                if (seat.isBooked()) return null;
                seat.setBooked(true);
                seat.setPassengerId(passenger.getPassengerId());
                bus.setAvailableSeats(bus.getAvailableSeats() - 1);
                data.getPassengers().add(passenger);
                Ticket ticket = new Ticket("T" + UUID.randomUUID().toString().substring(0, 5).toUpperCase(), bus.getBusId(), bus.getBusNumber(), passenger, seatNumber, bus.getSource(), bus.getDestination(), bus.getFare(), java.time.LocalDate.now().toString(), "CONFIRMED");
                data.getTickets().add(ticket);
                save();
                return ticket;
            }
        }
        return null;
    }
    public boolean cancelTicket(String ticketId) {
        for (Ticket t : data.getTickets()) {
            if (t.getTicketId().equals(ticketId)) {
                Bus bus = findBusById(t.getBusId());
                if (bus != null) {
                    for (Seat s : bus.getSeats()) if (s.getSeatNumber() == t.getSeatNumber()) { s.setBooked(false); s.setPassengerId(null); break; }
                    bus.setAvailableSeats(bus.getAvailableSeats() + 1);
                }
                t.setStatus("CANCELLED");
                save();
                return true;
            }
        }
        return false;
    }
    public List<Ticket> getAllTickets() { return data.getTickets(); }
}