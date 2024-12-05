package com.OOP.CW.CLI.Event;

import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TicketPool {

    private static List<Ticket> tickets = Collections.synchronizedList(new ArrayList<Ticket>());
    private static int totalTickets;


    public TicketPool() {}

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
        tickets.add(ticket);
        totalTickets++;
    }

    public synchronized void removeTicket() {
        tickets.removeFirst();
        totalTickets--;
    }
}
