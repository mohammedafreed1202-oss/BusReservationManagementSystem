package com.busreservation.main;
import com.busreservation.model.*;
import com.busreservation.service.ReservationService;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationService service = new ReservationService();
        while (true) {
            System.out.println("\n--- Bus Reservation System | Roll 2600520029 - JSON Persistence ---");
            System.out.println("1. View All Buses");
            System.out.println("2. Search Buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View All Tickets");
            System.out.println("6. Exit (Data Auto-Saved)");
            System.out.print("Please enter your choice: ");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); } catch (Exception e) { System.out.println("Please enter a valid number."); continue; }
            if (choice == 1) {
                for (Bus b : service.getAllBuses()) System.out.println(b);
            } else if (choice == 2) {
                System.out.print("Source: "); String s = sc.nextLine();
                System.out.print("Destination: "); String d = sc.nextLine();
                List<Bus> list = service.searchBuses(s, d);
                if (list.isEmpty()) System.out.println("No buses found.");
                else for (Bus b : list) System.out.println(b);
            } else if (choice == 3) {
                System.out.print("Bus Id (B1/B2/B3): "); String busId = sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
                System.out.print("Phone: "); String phone = sc.nextLine();
                System.out.print("Seat Number: "); int seat = Integer.parseInt(sc.nextLine());
                Passenger p = new Passenger("P" + UUID.randomUUID().toString().substring(0, 4).toUpperCase(), name, age, phone, "");
                Ticket t = service.bookTicket(busId, p, seat);
                if (t == null) System.out.println("Booking failed. Seat booked or Bus not found.");
                else System.out.println("Booked! Ticket ID: " + t.getTicketId());
            } else if (choice == 4) {
                System.out.print("Ticket ID: "); String tid = sc.nextLine();
                if (service.cancelTicket(tid)) System.out.println("Cancelled successfully.");
                else System.out.println("Ticket not found.");
            } else if (choice == 5) {
                for (Ticket t : service.getAllTickets()) System.out.println(t);
            } else if (choice == 6) {
                System.out.println("Exiting. Data saved in data/reservations.json");
                break;
            } else System.out.println("Please enter a valid number.");
        }
        sc.close();
    }
}