# E-Commerce Platform

## Overview

This E-Commerce platform is a console-based Java application that integrates with PostgreSQL for data storage. Users can register as buyers, sellers, or admins, and each role has specific functionalities:

- **Buyers**: Browse products, search products.
- **Sellers**: Add, update, delete their products.
- **Admins**: View and manage all users and products.

## Prerequisites

- **Java JDK** installed and accessible (check `java -version`).
- **Maven** installed and accessible (check `mvn -v`), or run Maven with full path if not on PATH.
- **PostgreSQL** running, with a database named `ecommerce` created.
  For example:
  ```bash
  psql -U postgres -c "CREATE DATABASE ecommerce;"
  psql -U postgres -d ecommerce -f src/main/resources/schema.sql
  psql -U postgres -d ecommerce -f src/main/resources/data.sql
  Project Structure
  Your project should look like this:
  ```

css
Copy code
ecommerce-platform/
├── pom.xml
├── documentation/
│ ├── User_Documentation.md
│ ├── Product_Documentation.md
│ ├── Development_Documentation.md
│ ├── Deployment_Documentation.md
│ └── Team_Contributions.md
├── presentation/
│ └── presentation_video.mp4
└── src/
├── main/
│ ├── java/
│ │ ├── Admin.java
│ │ ├── AdminMenu.java
│ │ ├── Buyer.java
│ │ ├── DBConnection.java
│ │ ├── MainMenu.java
│ │ ├── Product.java
│ │ ├── ProductMenu.java
│ │ ├── ProductService.java
│ │ ├── ProductDAO.java
│ │ ├── ProductDAOImpl.java
│ │ ├── Seller.java
│ │ ├── User.java
│ │ ├── UserDAO.java
│ │ ├── UserDAOImpl.java
│ │ ├── UserMenu.java
│ │ ├── UserService.java
│ │ └── UserServiceImpl.java
│ └── resources/
│ ├── application.properties
│ ├── schema.sql
│ └── data.sql
└── test/
└── java/
├── AdminServiceTest.java
├── ProductServiceTest.java
└── UserServiceTest.java
Building the Project
Navigate to the project directory:
bash
Copy code
cd C:\Users\mobri\Documents\School\ecommerce-platform
Run Maven build:
bash
Copy code
mvn clean install
or, if mvn is not on PATH:
bash
Copy code
& "C:\Users\mobri\Downloads\apache-maven-3.9.9-bin\apache-maven-3.9.9\bin\mvn.cmd" clean install
Running the Application
After a successful build, run:

bash
Copy code
java -cp target/ecommerce-platform-1.0-SNAPSHOT-jar-with-dependencies.jar MainMenu
This will launch the application’s main menu.

Usage
From the main menu, select:
1 for User Menu (Register/Login)
2 for Admin Menu
3 for Product Menu
4 to Exit
Follow the prompts to register new users, log in, manage products, and so on.

Further Documentation
See the documentation/ folder for:

User_Documentation.md: How to use each feature.
Product_Documentation.md: Explanation of product classes and features.
Development_Documentation.md: Code structure, build steps, development standards.
Deployment_Documentation.md: Detailed instructions on installing and running the app on a fresh environment.
Team_Contributions.md: Who did what, branch info, and project management details.
