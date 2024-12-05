package com.OOP.CW.CLI;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CLIProducerConsumerSimulation {

    private static final String BASE_URL = "http://localhost:8080"; // Your API base URL

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Producer-Consumer Simulation started. Enter commands (produce/consume/exit):");

        while (true) {
            String input = reader.readLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Simulation stopped.");
                break;
            }

            switch (input.toLowerCase()) {
                case "produce":
                    System.out.println("Enter item to produce:");
                    String item = reader.readLine();
                    Thread producerThread = new Thread(() -> sendProduceRequest(item));
                    producerThread.start();
                    break;

                case "consume":
                    Thread consumerThread = new Thread(CLIProducerConsumerSimulation::sendConsumeRequest);
                    consumerThread.start();
                    break;

                default:
                    System.out.println("Invalid command. Use 'produce', 'consume', or 'exit'.");
            }
        }
    }

    private static void sendProduceRequest(String item) {
        try {
            URL url = new URL(BASE_URL + "/produce");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\"item\": \"" + item + "\"}";
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Produced item response: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendConsumeRequest() {
        try {
            URL url = new URL(BASE_URL + "/consume");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Consumed item: " + response.toString());
                }
            } else {
                System.out.println("Consume request failed. Response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

