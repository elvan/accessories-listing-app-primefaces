# House of Donatello Accessories Listing Application

A Java web application for listing and filtering accessories using PrimeFaces UI framework.

## Technical Stack

- Java 8
- PrimeFaces 8 (UI Library)
- Payara 5 (Server)
- MySQL 8.0.x (Database)

## Project Overview

This application displays accessories data in a table with filtering capability. Users can filter accessories by:
- Accessory code
- Accessory name
- Category
- Price range
- Supplier (KERAS or SUPP_3)

## Project Structure

```
accessories-listing-app-primefaces/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── houseofdonatello/
│   │   │           └── accessories/
│   │   │               ├── bean/         # JSF Managed Beans
│   │   │               ├── dao/          # Data Access Objects
│   │   │               ├── model/        # Entity models
│   │   │               └── util/         # Utility classes
│   │   ├── resources/                    # Configuration files
│   │   └── webapp/
│   │       ├── resources/                # Static resources (CSS, JS)
│   │       │   ├── css/
│   │       │   └── js/
│   │       ├── WEB-INF/                  # Web application configuration
│   │       └── index.xhtml               # Main application page
└── pom.xml                               # Maven configuration
```

## Features

1. **Accessory List Display**: Shows all accessories in a paginated data table
2. **Filtering**: Filter accessories by multiple criteria
3. **Sorting**: Sort accessories by any column
4. **Responsive Design**: Works on desktop and mobile devices

## Database Schema

The application works with the following database tables:
- accessories
- accessories_category
- accessories_price
- accessories_discount

## Setup Instructions

### Prerequisites
- JDK 8
- Maven
- Payara 5 or compatible Java EE server
- MySQL 8.0.x

### Configuration
1. Update the database connection properties in `src/main/resources/db.properties`
2. Make sure your MySQL database contains the required tables

### Build and Deployment
1. Build the application:
   ```
   mvn clean package
   ```
2. Deploy the generated WAR file to Payara server:
   - Copy the WAR file to `[PAYARA_HOME]/deployments/` directory, or
   - Use the Payara Admin Console to deploy the application

### Accessing the Application
Once deployed, access the application at: http://localhost:8080/accessories-listing-app/

## Features To Be Implemented
See the TODO.md file for planned features and enhancements.
