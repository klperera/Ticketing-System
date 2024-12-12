package com.OOP.CW.CLI.Event;

import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TicketPool {

    private static List<Ticket> tickets = Collections.synchronizedList(new ArrayList<Ticket>());
    private static int totalTickets;
    private final int maxcapacity;


    public TicketPool(int maxcapacity) {
        this.maxcapacity = maxcapacity;
    }

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static void setTickets(List<Ticket> tickets) {
        TicketPool.tickets = tickets;
    }

    public static int getTotalTickets() {
        return totalTickets;
    }

    public static void setTotalTickets(int totalTickets) {
        TicketPool.totalTickets = totalTickets;
    }

    public synchronized void addTicket(Ticket ticket) {
        while (totalTickets >= maxcapacity) {
            System.out.println("Pool is full. Vendor waiting for space...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Vendor thread interrupted while waiting.");
            }
        }
        tickets.add(ticket);
        totalTickets++;
        System.out.println(Thread.currentThread().getName() + " added a ticket to the TicketPool." + " - Current pool size: " + tickets.size());
        notifyAll();
    }

    public synchronized void removeTicket() {
        while (tickets.isEmpty()) {
            System.out.println("No tickets available! Customer waiting for vendors...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Customer thread interrupted while waiting.");
            }
        }
        tickets.removeFirst();
        totalTickets--;
        System.out.println(Thread.currentThread().getName() + " removed a ticket from the TicketPool." + " - Current pool size: " + totalTickets);
    }
}
