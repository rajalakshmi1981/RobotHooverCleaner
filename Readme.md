# Robot Clean Demo Project 

Demo Project for Robot Hoover

### Project Details

Technologies used: Java 8, SpringBoot
Database: In memory H2 database

Since we have not used the file persistance in application.properties for the H2 database the data is cleaned when application is restarted 

For Demo purposes we have used the H2 database and we can plugin any other database by including the appropriate drivers and providing the database details

### Build

Run mvn clean install

### Testing

Run mvn test

### Runnning

using Maven 

mvn spring-boot:run

Using java -jar command 

java -jar target/RobotClean-0.0.1-SNAPSHOT.jar

### API's

If running locally then the URL is http://localhost:8080/clean and the method used is POST

Request and Response in JSON format. 

Sample Input JSON 

{
  "roomSize": [5,5],
  "coords": [1,2],
  "patches": [
	[1,0],
	[2,2],
	[2,3]
   ],
   "instructions" : "NNESEESWNWESWSSW"
}

Related Output

{
  "coords": [1,0],
  "patches": 3
}





