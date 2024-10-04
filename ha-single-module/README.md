Inspired by https://github.com/thombergs/buckpal

The mix of Hexagonal(ports and adapters) and Onion architecture

#### Prerequisites:
Java 21

### Hexagonal Architecture
![hexagonal-architecture.png](img%2Fhexagonal-architecture.png)
![Hexagonal Architecture](img/hexagonal-architecture-ports-and-adapters.png)

The core application defines the input port.
External components, like a web controller, implement this input port to pass data into the application.
This inversion ensures that the core business logic is not tightly coupled to any specific technology, user interface, or input mechanism.
Input validation or authentication can be consistently handled at the port level, ensuring that only valid, authorized data reaches the core logic.

### Onion Architecture

![onion-arch.png](img%2Fonion-arch.png)

The main difference is Application core in onion architecture, defined with concrete layers: domain model, domain services and application services

Key aspect: a domain service is only responsible for making business decisions, whereas an application service is only responsible for orchestration (finding the correct objects and invoking the correct methods in the correct order). Because of this, a domain service should generally not invoke any repository methods that alter the state of the database - that is the responsibility of the application service.

#### References:
https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)
https://github.com/thombergs/buckpal
https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/
