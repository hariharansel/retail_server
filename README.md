# Retail Bill Generate Server

This Spring Boot application is used to generate bill of the item based on the user (Employee, Affiliate, Regular, New) discount percentages.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## Run Test

- mvn test

## Compile and package

- mvn clean package

## Run the application

- cd target
- java -jar retail-server-0.0.1-SNAPSHOT.jar

## packages

- `entities` — to hold our entities;
- `dao` — to communicate with the database. for now not used in this project;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;

- `resources/application-develop.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies