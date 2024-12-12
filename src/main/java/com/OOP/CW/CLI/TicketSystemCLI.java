package com.OOP.CW.CLI;

import com.OOP.CW.CLI.Event.Configuration;
import com.OOP.CW.CLI.Event.TicketPool;
import com.OOP.CW.CLI.Users.Customer;
import com.OOP.CW.CLI.Users.Vendor;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketSystemCLI {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                =========================================================================================================
                \t\t\t\t\t\t\t\t\t\tWelcome to the Ticket System!
                =========================================================================================================""");
        while (true) {
            Configuration config = new Configuration();
            ArrayList<Thread> vendorThreads = new ArrayList<>();
            ArrayList<Thread> CustomerThreads = new ArrayList<>();
            int totalNumberOfTickets = 0;
            System.out.println("Enter System configurations..");
            System.out.print("Enter Max Capacity :");
            config.setMaxTicketCapacity(scanner.nextInt());
            TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
            System.out.println("Enter number of Vendors to simulate :");
            int vendorNum = scanner.nextInt();
            System.out.println("Enter number of Customers to simulate :");
            int customerNum = scanner.nextInt();

            for (int i = 1; i <= vendorNum; i++) {
                System.out.println("Vendor " + i +  " - Enter number of tickets to simulate :");
                int numTickets = scanner.nextInt();
                System.out.println("Vendor "+ i + " - Enter tickets releaseRate (in milliseconds) :");
                int releaseRate = scanner.nextInt();
                Runnable runnable = new Vendor(numTickets, releaseRate, ticketPool, config.getMaxTicketCapacity());
                Thread thread = new Thread(runnable);
                vendorThreads.add(thread);
                thread.setName("Vendor " + i);
                //thread.start();
            }
            for (int i = 1; i <= customerNum; i++) {
                System.out.println("Customer " + i +  " - Enter number of tickets you buy :");
                int buyTickets = scanner.nextInt();
                System.out.println("Customer "+ i + " - Enter Customer RetrievalRate :");
                int retrievalRate = scanner.nextInt();
                Runnable runnable = new Customer(buyTickets, retrievalRate, ticketPool);
                Thread thread = new Thread(runnable);
                CustomerThreads.add(thread);
                thread.setName("Customer " + i);
                //thread.start();
            }
            System.out.println("Enter 'start' or 'exit' :");
            String entry = scanner.next();
            if (entry.equalsIgnoreCase("start")) {

//                for (Thread thread : vendorThreads) {
//                    thread.start();
//                }
//                for (Thread thread : CustomerThreads) {
//                    thread.start();
//                }
                try {
                    for (Thread thread : vendorThreads) {
                        thread.start();
                        //thread.join();
                    }
                    for (Thread thread : CustomerThreads) {
                        thread.start();
                        //thread.join();
                    }
                    for (Thread thread : vendorThreads) {
                        //thread.start();
                        thread.join();
                    }
                    for (Thread thread : CustomerThreads) {
                        //thread.start();
                        thread.join();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
