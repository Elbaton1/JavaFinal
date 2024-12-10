# User Documentation

This document explains how to use each feature of the E-Commerce Platform from a user's perspective.

The E-Commerce Platform allows three types of users: **Admins**, **Sellers**, and **Buyers**. Each role has specific features and permissions.
When signing up you will be able to assign yourself as either admin,seller or buyer each having a specific dashboard

## Getting Started

1. Launch the application using:

```bash
   java -cp target/ecommerce-platform-1.0-SNAPSHOT-jar-with-dependencies.jar MainMenu
```

# Development Documentation

Build and Run
Requirements:

Java 8+
Maven 3.6+
PostgreSQL or a similar database running
Build:

```bash
mvn clean install
```

Run:

```bash
java -cp target/ecommerce-platform-1.0-SNAPSHOT-jar-with-dependencies.jar MainMenu
```

Follow the on-screen menus to register, login, and use the app.

# Coding Style

- Use clear, descriptive names for classes, methods, and variables.
- Indent code with 4 spaces, no tabs.
- Keep methods and classes short.
- Add simple comments when necessary, and Javadoc on public methods.

# Error Handling

- DAOs print errors if something fails (like a DB issue).
- Services show user-friendly messages.
- Consider improving error handling over time, e.g., by adding better logging.

# Testing

Add tests in src/test/java.
Use JUnit for unit tests on DAOs and Services.
Run tests:

```bash
mvn test
```

Branching and Workflow/master branch.
Create a new branch (feature/...) for each new feature or fix.
Merge changes into master after code review by another team member.

# Configuration

Adjust application.properties for DB settings (URL, username, password).

# Deployment Documentation

Maven 3.6+:
Check with:

```bash
mvn -v
```

Make sure the version is compatible.

# PostgreSQL or Compatible Database:

You should have:

- A running PostgreSQL instance.
- A database created (e.g., ecommerce_db).
- A database user with the necessary privileges to create and modify tables.
- Database Setup
- Create Database Tables
- Connect to your PostgreSQL instance and run:

Open sql shell and connect and create a database if you havent already ex.

```bash
CREATE DATABASE mydatabase;
```

Once db is created now create your tables

```bash
CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(100) NOT NULL,
email VARCHAR(100),
role VARCHAR(20) NOT NULL
);
```

```bash
CREATE TABLE IF NOT EXISTS products (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
price DECIMAL(10,2) NOT NULL,
quantity INT NOT NULL,
seller_id INT NOT NULL REFERENCES users(id)
);
```

# Test Connectivity

Ensure you can log into the database using the credentials you plan to use in application.properties.

# Configuration

Set Database Credentials
Open src/main/resources/application.properties and edit:

# properties

```bash
db.url=jdbc:postgresql://localhost:5432/ecommerce_db
db.username=ecom_user
db.password=secret_password
```

# Replace with your actual database name, username, and password.

# Security Note:

Do not commit real credentials to version control. Use environment variables or a separate secure file in production.

# Building the Application

In the project’s root directory (or where pom.xml is located), run:

```bash
mvn clean install
```

This command compiles the code, runs any tests, and produces a runnable JAR file in the target directory.

# Running the Application

Once the build is complete, run:

```bash
java -cp target/ecommerce-platform-1.0-SNAPSHOT-jar-with-dependencies.jar MainMenu
```

# Expected Result:

======================
Welcome to the E-Commerce Platform
======================

1. User Menu (Register/Login)
2. Exit
   Choose an option:

The console displays the main menu.
you can register a user, log in, and access role-specific menus (Admin, Buyer, Seller).
