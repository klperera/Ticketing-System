package com.OOP.CW.CLI;

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
            List<Ticket> ticketPool = Collections.synchronizedList(new ArrayList<>());
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

                for (int i = 0; i < vendorNum; i++) {
                    System.out.println("Enter number of tickets to simulate :");
                    int numTickets = scanner.nextInt();
                    System.out.println("Enter tickets release rate :");
                    double releaseRate = scanner.nextInt();
                    Runnable runnable = new Vendor(numTickets,releaseRate);
                    Thread thread = new Thread(runnable);
                    thread.start();
                }

                for (int i = 0; i < customerNum; i++) {
                    Runnable runnable = new Customer();
                    Thread thread = new Thread(runnable);
                    thread.start();
                }
            } else if (entry.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
            else {
                System.out.println("Invalid entry. Please try again.");
            }
        }
    }
}
