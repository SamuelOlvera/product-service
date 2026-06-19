# ProductService

Microservice responsible for managing the product catalog and exposing a search API with real time stock from the Inventory SErvice

# Architecture

The architecture consist of two microservices:
- **ProductService** (this) prot '8080'
- **InventoryService** (dependency) port '8081'

Synchronous communication between services using OpenFeign

# Tech Stack

- Java 17
- Spring Boot 3.5.3
- MongoDb 7.0+
- Spring Cloud OpenFeign
- Lombok

## Prerequisites

- Java 21+
- Maven 3.8+
- Inventory Service running on port '8081'

## MongoDB

The service connects to MongoDB automatically on startup.
No manual schema creation needed, Spring data creates the 'products' collection on first insert