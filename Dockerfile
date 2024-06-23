FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk-slim 
COPY --from=build /target/codeground-0.0.1-SNAPSHOT.jar codeground.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","codeground.jar"]


# # First stage: Build the application
# FROM maven:3.9.4-openjdk-22.ea-b17 AS build

# # Set the working directory
# WORKDIR /codeground

# # Copy all files to the working directory
# COPY . .

# # Build the application, skipping tests
# RUN mvn clean package -DskipTests

# # Second stage: Create the final image
# FROM openjdk:22-jdk-slim 

# # Set the working directory
# WORKDIR /codeground

# # Copy the built .jar file from the first stage to the working directory
# COPY --from=build /codeground/target/codeground-0.0.1-SNAPSHOT.jar codeground.jar

# # Expose the application's port
# EXPOSE 8080

# # Run the application
# ENTRYPOINT ["java", "-jar", "codeground.jar"]
