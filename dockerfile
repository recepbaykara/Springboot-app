FROM openjdk:21-jdk-slim

# # # # # # # Create the /app directory inside the container
WORKDIR /app

# # # # # # # Copy the JAR file from the local target directory to the /app directory in the container
COPY target/demo-student-management-system.jar /app/demo-student-management-system.jar

# # # # # # # Expose port 8080
EXPOSE 8080

# # # # # # # Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/demo-student-management-system.jar"]


