# Netflix Hystrix Circuit breaker Pattern POC

This is a simple application to demonstrate **circuit breaker patter** using the netflix-hystrix library 

### Scenario 1: Third party api is available to the microservice for communication

For this scenario, before running the application **run the docker-compose** which will expose an api with which our service will interact.
Once the docker-compose is up, run the springboot application and hit the endpoint, observe the logs.

### Scenario 2: Third party API is not available to the microservice for communication

For this scenario, **do not run the docker-compose** file which will make the API unavailable for the service with which our microservice interacts thus implementing the **fallback method** in our service.

## Endpoint 

Once the service is up you can test both the scenarios by using the endpoint:

```
http://localhost:8080
```
