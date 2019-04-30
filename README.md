# CsvDataDownloader
App for download data from csv in DB. using Spring Boot, AOP, Spring Data JPA, MySQL
____
 
 ### How to install:
 1. Import database to MySQL using SQL script.sql located in the root directory
 2. Change database connection settings in src\main\resources\application.properties, if required.
 Default values:
    -  url = jdbc:mysql://localhost:3306/test_task?serverTimezone=UTC
    -  user = root
    -  password = root
 3. Open command line in the project directory and enter 'mvn package'
 4. Place your csv. files in 'unprocessed' package.
 4. Enter in command line 'java -jar target/data-loader-0.0.1-SNAPSHOT.jar'
