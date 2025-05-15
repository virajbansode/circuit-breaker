This repo contains two projects
1) Product Service
2) User Service

- Product service is a simple web service which runs on port 9090 and has controller will return list of hardcoded product
- User service is a another simple web service which runs on port 8080 and has
  Circuit breaker configuration which applied on service class method
  It is expected to get call fallback method on RuntimeException
  RTE could be mannually thrown occurred at run time when calling product service

<br>
To test success senario
    Start both the services and hit user service http://localhost:8080/user-products<br> 
To test circuit breaker fallback scenario.
    Stop Product service and hit user service. Fallback methos should get trigger and can have successful response from API
