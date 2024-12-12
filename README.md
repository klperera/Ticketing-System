
# Real-Time Event Ticketing System with Producer-Consumer Pattern

Real-Time Event Ticketing System System is an event management and ticketing platform designed for vendors, organizers, and customers. It features a user-friendly frontend, a robust backend, and a command-line interface (CLI) for simulations and testing.


## Features

### Frontend

Built with Angular to provide an intuitive and responsive interface.

#### Key Features:

User registration and login.

Event creation and management for organizers.

Viewing and purchasing tickets for customers.

Displaying available events and ticket pools.

### Backend

Powered by Spring Boot to manage data and APIs.

#### Key Features:

RESTful APIs for user authentication, event management, and ticket purchasing.

Role-based access control for vendors, organizers, and customers.

Database interactions using JPA and Hibernate.

Integration of ticket pools with event management.

### Command-Line Interface (CLI)

Simulates real-world functionalities of the system.

#### Key Features:

Multithreaded simulation of backend processes.

User and vendor simulations for testing core functionalities.

Ticket purchases and event management operations.

## Technologies Used

Frontend: Angular, TypeScript, HTML, CSS

Backend: Spring Boot, Java, Hibernate, MySQL

CLI: Java
## API Reference

#### Backend

1. Use API tools like Postman to test endpoints.

Sample endpoints:

POST /:usertype/register: User registration.

POST /:usertype/login: User login.

POST /:usertype/allevents: Fetch all events.

POST /:usertype/buttickets: Purchase tickets.

### Frontend

Access the web interface via http://localhost:4200.

Interact with features like event management, ticket viewing, and purchases.

### CLI

Run the CLI for simulation:

Register users, create events, and purchase tickets using interactive commands.


## Contact

For any inquiries or feedback, please contact:

Name: Kalpa Perera
IIT ID: 20220915
Email: kalpa.20220915@iit.ac.lk


