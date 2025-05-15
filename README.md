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

    Configuration Parameters in Resilience4J
- failureRateThreshold: Sets the failure rate threshold percentage. When the failure rate meets or exceeds this percentage, the circuit transitions to the open state.
 - slidingWindowSize: Defines the size of the sliding window used for calculating the failure rate. It can be count-based or time-based.
- minimumNumberOfCalls: Specifies the minimum number of calls needed before the Circuit Breaker begins calculating the failure rate. The Circuit Breaker will not open until this number is reached.
- waitDurationInOpenState: Duration the Circuit Breaker stays in the open state before transitioning to the half-open state.
- permittedNumberOfCallsInHalfOpenState: Number of test calls allowed in the half-open state to determine if the Circuit Breaker should close again.
