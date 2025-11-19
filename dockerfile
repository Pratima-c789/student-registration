# Use a lightweight OpenJDK runtime as base image
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the Spring Boot fat jar from target folder to container 
# Replace 'student-registration-0.0.1-SNAPSHOT.jar' with your actual jar file name
COPY target/student-registration-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to the outside
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jagit commit -m "Initial commit of student registration app"
r","app.jar"]
