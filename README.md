# Retail Bill Generate Server

This Spring Boot application is used to generate bill of the item based on the user (Employee, Affiliate, Regular, New) discount percentages.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Run Test and Code coverage report

- mvn clean test
- Access the code coverage report target/site/jacoco/index.html

## Compile and package

- mvn clean package

## Run the application

- cd target
- java -jar retail-server-0.0.1-SNAPSHOT.jar

## Sample Request and Response

- Access URL: http://localhost:9090/swagger-ui.html#!/billing45controller/getBillDetailsUsingGET once application started.
- user_id=1 and item_id=1 in request to generate bill.
- Please refer screenshot in git.
  Request: sample_generate_bill_request.png
  Response: sample_bill_generate_response.png

## Sample UML Class Diagram

  - Created initial draft for Class Diagram of retail server and attached the screenshot
  Screenshot: retail_server_class_diagram.jpeg
  
## packages

- `entities`  —  to hold our entities;
- `dao`  —  to communicate with the database. for now not used in this project;
- `services` —  to hold our business logic;
- `controllers`  —  to listen to the client;

- `resources/application-develop.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies
