# Codeground Backend

Codeground is an interactive platform that teaches you Java from scratch. Read lessons and practice coding simultaneously in our built-in compiler. Codeground offers a unique, interactive learning experience, allowing users to read lessons and practice coding simultaneously with a built-in code editor. While our current curriculum focuses on Java fundamentals and advanced topics, there is high demand for additional content on related technologies and frameworks. Join Codeground today and master Java with engaging lessons, practical exercises, and instant feedback!

## Overview

The Codeground Backend is a Spring Boot application with a PostgreSQL database. It handles all backend operations for the Codeground app, including user authentication and a Java compiler service. The frontend of the Codeground app is maintained in a separate repository, which can be found [here](https://github.com/caprian/CodeGround-Frontend).

## Features

- **User Authentication**: Secure user authentication and management.
- **Built-in Java Compiler**: Allows users to compile and run Java code within the platform.
- **Interactive Learning**: Supports the interactive learning experience provided by the Codeground app.
- **Spring Boot Framework**: Robust and scalable backend framework.
- **PostgreSQL Database**: Reliable and efficient data storage.

## Installation

To set up the Codeground Backend, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/codeground-backend.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd codeground-backend
    ```
3. **Set up the PostgreSQL database**:
    - Ensure you have PostgreSQL installed and running.
    - Create a new database for the application.
    - Update the `application.properties` file with your database credentials.
4. **Build the application**:
    ```bash
    ./mvnw clean install
    ```
5. **Run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## Usage

Once the backend is running, it will handle all backend functionalities for the Codeground app. You can access the API endpoints for user authentication, compiling Java code, and other features provided by the backend.

## Frontend Repository

The frontend of the Codeground app is maintained in a separate repository. You can find it [here](https://github.com/caprian/CodeGround-Frontend).

## Contributing

We welcome contributions! Please fork the repository and submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions or need support, please reach out to [shashankag20@example.com].
