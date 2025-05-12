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
- Supplier

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

- `accessories_tp` - Stores accessory details like code, name, price, etc.
- `accessories_category_tp` - Contains categories for accessories
- `supplier_tp` - Stores supplier information

## Setup Instructions

### Prerequisites

- JDK 8
- Maven 3.6+
- Payara 5 or compatible Java EE server
- MySQL 8.0.x

### Database Setup

1. Create a MySQL database for the application:
   ```sql
   CREATE DATABASE accessories_listing_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   CREATE USER 'accessories_user'@'%' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON accessories_listing_db.* TO 'accessories_user'@'%';
   FLUSH PRIVILEGES;
   ```

2. Update the database connection properties in `src/main/resources/db.properties` with your credentials:
   ```properties
   db.url=jdbc:mysql://localhost:3306/accessories_listing_db?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
   db.username=accessories_user
   db.password=your_password
   db.driver=com.mysql.cj.jdbc.Driver
   ```

### Running Database Migrations

The application uses Flyway to manage database migrations. To run migrations:

1. Using Maven:
   ```bash
   mvn flyway:migrate
   ```

2. Alternatively, the migrations will run automatically when the application starts if you set
   `flyway.migrate-at-start=true` in your configuration.

### Quick Start (Development)

1. **Run locally using Maven plugin**:
   ```bash
   mvn payara-micro:start
   ```
   This will start the application on an embedded Payara Micro server.

2. **Run with auto-redeploy** (for development):
   ```bash
   mvn payara-micro:start -Dpayara.autoDeployDir=target
   ```

3. Access the application at: http://localhost:8080/accessories-listing-app-primefaces/

### Building and Deploying to Production

1. Build the application:
   ```bash
   mvn clean package
   ```

2. Deploy options:
    - Copy the generated WAR file to Payara server's `deployments` directory:
      ```bash
      cp target/accessories-listing-app-primefaces.war [PAYARA_HOME]/deployments/
      ```
    - Use the Payara Admin Console to deploy the WAR file
    - Use the asadmin command line tool:
      ```bash
      asadmin deploy --force=true target/accessories-listing-app-primefaces.war
      ```

3. Access the application at: http://your-server:8080/accessories-listing-app-primefaces/

## Features To Be Implemented

See the TODO.md file for planned features and enhancements.

## Troubleshooting

### Database Connection Issues

- Verify MySQL is running: `mysql --version`
- Check connection properties in `db.properties`
- Confirm database user has proper permissions

### Deployment Issues

- If the application fails to deploy, check server logs in `[PAYARA_HOME]/logs/server.log`
- Ensure the Payara server is running: `asadmin list-domains`
- Verify WAR file was built correctly: `ls -la target/accessories-listing-app-primefaces.war`

### Application Errors

- For database schema issues, verify migrations ran successfully
- Check browser console for JavaScript errors
- Examine server logs for exceptions

## Contributing

Please follow the standard Git workflow for contributions:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request
