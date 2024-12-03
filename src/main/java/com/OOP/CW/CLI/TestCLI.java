package com.OOP.CW.CLI;

import com.OOP.CW.Backend.TicketingSystemApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

public class TestCLI {
    public static void main(String[] args) {
        System.out.println("starting ticketing system!");
        SpringApplication app = new SpringApplication(TicketingSystemApplication.class);

        // turn of spring boot banner
        app.setBannerMode(Banner.Mode.OFF);
        // turn of the logging
        System.setProperty("logging.level.root", "OFF");
        System.setProperty("logging.level.org.springframework.boot", "OFF");
        System.setProperty("logging.level.org.springframework.web", "OFF");

        // run the backend
        ApplicationContext context = app.run(args);
        //CustomerController customerController = context.getBean(CustomerController.class);

        System.out.println("No logs are being printed");

        //CLI interface

        while (true){
            System.out.println("Welcome to the ticketing system");
            System.out.println("Enter Y to continue or Q to exit ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Q")){
                break;
            }else{
                if (choice.equalsIgnoreCase("Y")){
                    System.out.println("Do you want to call customer methods");
                    String choice2 = scanner.nextLine();

                    if (choice2.equalsIgnoreCase("Y")){
                        // can call customer methods that are assign to mappings
                        //System.out.println(customerController.allevents());
                    }
                }
            }
        }
    }
}
