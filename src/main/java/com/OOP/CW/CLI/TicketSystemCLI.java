package com.OOP.CW.CLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketSystemCLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
              
                =========================================================================================================
                \t\t\t\t\t\t\t\t\t\tWelcome to the Ticket System!
                =========================================================================================================""");
        while (true) {
            System.out.println("\n1: log in \n2: register \n3: exit");
            System.out.print("chosen an option: ");
            if (scanner.hasNextInt()) {
                int entry = scanner.nextInt();
                switch (entry) {
                    case 1 -> login();
                    case 2 -> register();
                    case 3 -> {
                        System.out.println("Exiting From System");
                        System.exit(0);
                    }
                    default -> System.out.println("Please enter a number between 1 and 3");
                }
            } else {
                System.out.println("Please enter a number between 1 and 3");
                scanner.next();
            }
        }


//        System.out.println(" 1: Organizer\n 2: Vendor \n 3: Customer");
//        System.out.println("\n1: Add Ticket\n2: Check Available Tickets\n3: Exit");
//        int choice = scanner.nextInt();
//
//        switch (choice){
//            case 1:
//        }
    }

    public static void login(){

    }

    public static void register(){
        System.out.println();
        login();
    }
}
