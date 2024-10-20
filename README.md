

# OneBlood - Donation Center Appointment Management Application

Spring Boot application that manages appointments for a blood donation center. The application provides a REST API for managing patients, doctors, and appointments. The application also includes role-based authentication and authorization using JWT tokens, an in-memory database, and logs all incoming and outgoing requests and responses.

## Features

- **Appointment Management**: Patients can book appointments, doctors can manage appointments, and admins can oversee everything.
- **In-Memory Database**: The application uses H2 as an in-memory database to store information on patients, doctors, appointments, and users.
- **JWT Authentication & Role-based Authorization**: 
  - Users are authenticated using JWT bearer tokens.
  - The application has three roles: 
    - **Admin**: Has full access to manage doctors, patients, and appointments.
    - **Doctor**: Can view and manage appointments.
    - **Patient**: Can view and book appointments.

## Tech Stack

- **Java 21**
- **Spring Boot 3.3.4**
- **Spring Data JPA (Hibernate)**
- **Spring Security (JWT-based Authentication)**
- **H2 In-Memory Database**
  
## Roles and Permissions

| Role    | Permissions                                            |
|---------|--------------------------------------------------------|
| Admin   | Full control over doctors, patients, and appointments. |
| Doctor  | Manage appointments for their patients.                |
| Patient | Book and manage their own appointments.                |

## Endpoints

### Authentication
- **POST** `/v1/auth/authenticate`: Authenticate a user with email and password to receive a JWT token.

### Patient Endpoints
- **POST** `/v1/medical/patient`: Register a new patient (Admin only).
- **GET** `/v1/medical/patient/{id}`: View patient details (Admin only).
  
### Doctor Endpoints
- **POST** `/v1/medical/doctor`: Register a new doctor (Admin only).
- **GET** `/v1/medical/doctor/{id}`: View doctor details (Admin only).

### Appointment Endpoints
- **POST** `/v1/medical/appointment`: Book an appointment (Patient, Doctor, Admin).
- **GET** `/v1/medical/appointment/{id}`: View appointment details (Doctor, Patient, Admin).

## Prerequisites

- Java 17+
- Maven 3.8+
- Postman or any API testing tool for testing endpoints.

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/ilinca20/OneBlood.git
   cd blood-donation-center
   ```

2. Build and run the application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. The application will start on port `8090`. You can access the H2 database console at:

   ```
   http://localhost:8090/db
   ```

   **Note**: Use `jdbc:h2:mem:testdb` as the JDBC URL in the H2 console.

## Authentication and Authorization

To interact with the secured endpoints, you'll need to authenticate and obtain a JWT token. Here’s how to do it:

### 1. **Get a JWT Token**

Send a `POST` request to `/v1/auth/authenticate` with the following body:

```json
{
  "email": "john.doe@example.com",
  "password": "123456"
}
```

The response will contain a JWT token:

```json
{
  "token": "your-jwt-token-here"
}
```

### 2. **Use the Token for Secured Endpoints**

Include the token in the `Authorization` header of your requests:

```bash
Authorization: Bearer your-jwt-token-here
```

### Example Request

```bash
curl -H "Authorization: Bearer your-jwt-token-here" http://localhost:8090/v1/medical/appointment/1
```

## Database Initialization

The application uses an in-memory H2 database for development and testing purposes. Upon startup, the database is initialized with default tables and relationships using JPA and Spring Data.

You can view and interact with the database using the H2 console:

```
http://localhost:8090/db
```

## Security

- The application uses **JWT** for securing its endpoints.
- The security configuration allows the following:
  - **Permit all**: `/v1/auth/authenticate` and the H2 console `/db`.
  - **Role-based access control** for other endpoints as described earlier.
  
