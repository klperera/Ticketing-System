package com.OOP.CW.CLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketSystemCLI {

    public static void main(String[] args) {

        System.out.println("""
                
                =========================================================================================================
                \t\t\t\t\t\t\t\t\t\tWelcome to the Ticket System!
                =========================================================================================================""");
        SimulateDetails();
        createEvent();



    }

    public static void SimulateDetails() {
        Scanner scanner = new Scanner(System.in);

        int numOrganizers = 0;
        int numVendors = 0;
        int numCustomers = 0;
        try{
            System.out.println("Number of Organizers to Simulate : ");
            numOrganizers = scanner.nextInt();
            System.out.println("Number of Vendors to Simulate : ");
            numVendors = scanner.nextInt();
            System.out.println("Number of Customers to Simulate : ");
            numCustomers = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please enter a valid number");
        }
        System.out.println(numOrganizers + " Organizers ");
        System.out.println(numVendors + " Vendors ");
        System.out.println(numCustomers + " Customers ");
    }

    public static void createEvent(int numOrganizers){

    }

}
