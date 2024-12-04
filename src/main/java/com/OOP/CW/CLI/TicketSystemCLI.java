package com.OOP.CW.CLI;

import com.OOP.CW.CLI.Event.TicketPool;
import com.OOP.CW.CLI.Ticket.Ticket;
import com.OOP.CW.CLI.Users.Customer;
import com.OOP.CW.CLI.Users.Vendor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicketSystemCLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("""
                =========================================================================================================
                \t\t\t\t\t\t\t\t\t\tWelcome to the Ticket System!
                =========================================================================================================""");
        while (true) {
            TicketPool ticketPool = new TicketPool();
            int maxCapacity = 0;
            int totalNumberOfTickets = 0;
            System.out.println("Enter 'start' or 'exit' :");
            String entry = scanner.nextLine();
            if (entry.equalsIgnoreCase("start")) {
                System.out.println("Enter System configurations..");
                System.out.println("Enter Max Capacity :");
                maxCapacity = scanner.nextInt();
                System.out.println("Enter number of Vendors to simulate :");
                int vendorNum = scanner.nextInt();
                System.out.println("Enter number of Customers to simulate :");
                int customerNum = scanner.nextInt();

                for (int i = 1; i <= vendorNum; i++) {
                    System.out.println("Vendor " + i +  " Enter number of tickets to simulate :");
                    int numTickets = scanner.nextInt();
                    System.out.println("Vendor "+ i + " Enter tickets releaseRate :");
                    int releaseRate = scanner.nextInt();
                    Runnable runnable = new Vendor(numTickets, releaseRate, ticketPool);
                    Thread thread = new Thread(runnable);
                    thread.start();
                }

                for (int i = 1; i <= customerNum; i++) {
                    System.out.println("Customer " + i +  " Enter number of tickets you buy :");
                    int buyTickets = scanner.nextInt();
                    System.out.println("Customer "+ i + " Enter Customer RetrievalRate :");
                    int retrievalRate = scanner.nextInt();
                    Runnable runnable = new Customer(buyTickets, retrievalRate, ticketPool);
                    Thread thread = new Thread(runnable);
                    thread.start();
                }
            }
            else if (entry.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
            else {
                System.out.println("Invalid entry. Please try again.");
            }
        }
    }
}
