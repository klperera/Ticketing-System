package com.OOP.CW.CLI.Event;

import com.OOP.CW.CLI.Ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TicketPool {

    private static List<Ticket> tickets = Collections.synchronizedList(new ArrayList<Ticket>());


    public TicketPool() {}

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static void setTickets(List<Ticket> tickets) {
        TicketPool.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket() {
        tickets.removeFirst();
    }
}
