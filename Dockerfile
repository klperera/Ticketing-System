# Use OpenJDK as base image
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml (if using Maven)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x ./mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/CW-0.0.1-SNAPSHOT.jar"]