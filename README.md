# Employee Management System

This is a Spring Boot project for managing employees with multiple API versions. The project follows the MVC architecture and utilizes MySQL as the database, Hibernate for ORM, and JPA for data persistence.

## Table of Contents

- [Controllers](#controllers)
  - [EmployeeController](#employeecontroller)
  - [V2EmployeeController](#v2employeecontroller)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Application Properties Setup](#application-properties-setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Controllers

### EmployeeController

```java
@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImplementation")
    EmployeeService employeeService;

    // ... (Other methods as described below)
}
```

#### Endpoints:

- **POST /v1/employee/add-employee**
  - Adds a new employee.

- **POST /v1/employee/remove-employee**
  - Removes an employee by ID.

- **GET /v1/employee/get-all-employees**
  - Retrieves a list of all employees.

- **GET /v1/employee/{id}**
  - Retrieves an employee by ID.

- **DELETE /v1/employee/nuke-employee-list**
  - Deletes all employees.

### V2EmployeeController

```java
@RestController
@RequestMapping("/v2/employee")
public class V2EmployeeController {

    @Autowired
    @Qualifier("v2EmployeeServiceImplementation")
    EmployeeService employeeService;

    // ... (Other methods as described below)
}
```

#### Additional Endpoint:

- **POST /v2/employee/some-new-api**
  - Adds a new API with a custom message.

## Technologies Used

- Spring Boot
- MVC Architecture
- MySQL Database
- Hibernate
- JPA (Java Persistence API)

## Getting Started

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your-username/employee-management-system.git
    cd employee-management-system
    ```

2. **Configure Database:**

    Set up your MySQL database and update the `application.properties` file with the appropriate database connection details.

    **application.properties:**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Build and Run:**

    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

    The application will be accessible at [http://localhost:8080](http://localhost:8080).

## Usage

- Utilize the API endpoints as described in the [Controllers](#controllers) section.
- Customize and extend the controllers or service classes to meet your specific business requirements.

