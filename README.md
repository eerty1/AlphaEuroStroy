# Alpha Euro Stroy

The domain of the project is borrowed from the existing website, that is dealing in cottages and other 
real estate

## Project idea

The idea is simple - I wanted to develop a simple project to continue my acquaintance with Quarks framework. But here a thought arose - this pet project won’t be very beneficial from the point of view of my hard skills, since It brings nothing new except for a framework, which ofc resembles Spring a bit. Combined with already habitual relation database (Postgresql for example), Alpha EuroStroy is nothing more but a waste of time. That’s why I decided to give this project a little extra zhuzh with MongoDB.

The goal was to implement a simple crud service on the example of which I could practice the following:

* Dependency injection
* Database connectivity
* Exception handling
* Jwts and route security
* Mailing
* Revise API consumption

You are proposed to use Java 17.

My Maven version.

![This is an image](https://i.ibb.co/5M5bxcm/image.png)

There're the steps to unpack my project: 

* git clone AlphaEuroStroy

* Open it via your IDE

* Set required environmental variables (See application.yml file)

## Usage

Build and run application:

* mvn clean install

* Run **java –jar target/quarkus-app/quarkus-run.jar**

* Open **http://localhost:8080/api/q/swagger-ui/** to see all the available endpoints and entities