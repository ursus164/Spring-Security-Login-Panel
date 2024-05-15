# Spring-Security-Login-Panel

## Overview
This project is a Spring Boot application that integrates Spring Security to handle user authentication and authorization.

## Features
- User authentication with BCrypt password encoding
- Custom login and logout pages
- User registration functionality
- Endpoints restriction. Only authenticated users can access home page.
- Proper alerts about login/registration process

## Overview
### Login Page
![image](https://github.com/ursus164/Spring-Security-Login-Panel/assets/101526933/e3447242-1416-49a6-82e1-c6d64aef560c)
### Registration Page
![image](https://github.com/ursus164/Spring-Security-Login-Panel/assets/101526933/136a9acc-709e-4bcc-83e4-af0dc6ec7547)
### Home Page
![image](https://github.com/ursus164/Spring-Security-Login-Panel/assets/101526933/0adcdb95-9dc6-4945-ba3b-941a4794d2e7)

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```
2. Build the project:
    ```sh
    mvn clean install
    ```
3. Run the application:
    ```sh
    mvn {PROJECT_NAME}:run
    ```

## Project Structure
The project follows a standard Spring Boot structure with the following main packages:

- `com.ursus.configuration`: Contains the security configuration class.
- `com.ursus.controller`: Contains the controller classes for handling web requests.
- `com.ursus.model`: Contains the entity classes representing the database schema.
- `com.ursus.model.dto`: Contains the Data Transfer Object (DTO) classes.
- `com.ursus.repository`: Contains the repository interfaces for data access.
- `com.ursus.service`: Contains the service classes for business logic.

### Detailed Components

#### Security Configuration
The security configuration is defined in the `SecurityConfig` class located in the `configuration` package.

- **Custom User Details Service:** The application uses a custom implementation of `UserDetailsService` to load user-specific data. This service is injected into the security configuration to manage authentication.
- **Password Encoding:** Passwords are encoded using `BCryptPasswordEncoder` to ensure they are stored securely.
- **HTTP Security:** The `securityFilterChain` method configures HTTP security for the application, permitting access to specific endpoints without authentication and configuring custom login and logout pages.

#### Controllers
The `UserController` class in the `com.ursus.controller` package handles web requests related to user operations, including:
- Displaying the home page
- Handling login requests
- Handling user registration

#### Models
- **User:** The `User` class in the `com.ursus.model` package represents the user entity stored in the database.
- **UserDto:** The `UserDto` class in the `com.ursus.model.dto` package is a Data Transfer Object used to transfer user data between the client and the server.

#### Services
- **CustomUserDetailsService:** This class in the `com.ursus.service` package implements `UserDetailsService` to provide user-specific data for authentication.
- **UserServiceImpl:** This class implements the `UserService` interface, providing methods to handle user-related business logic, such as retrieving users and saving new users.

#### Repository
- **UserRepository:** This interface in the `repository` package extends `JpaRepository` to provide CRUD operations for the `User` entity.


## Usage
After starting the application, you can access the following endpoints:
- `/home`: Accessible only after the user is authenticated, displays the home page.
- `/login`: Custom login page.
- `/register`: User registration page.

## License
This project is licensed under the MIT License.

