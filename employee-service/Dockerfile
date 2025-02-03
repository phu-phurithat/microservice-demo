# Use official base image of Java Runtim
FROM openjdk:23-jdk-slim

# Make port 8082 available to the world outside container
EXPOSE 8082

COPY target/employeeservice-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]