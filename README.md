# Online Bookstore Microservices 

Online Bookstore Microservices
A Spring Boot microservices application for an online bookstore with two services:

Book Service: Manages book inventory in PostgreSQL.
Order Service: Manages orders in MongoDB, integrates with Book Service, and logs events to Kafka.

Technologies

Java 21
Spring Boot 3.3.5
PostgreSQL
MongoDB
Kafka
Docker
GitHub

Setup

Clone the repository:
git clone https://github.com/codewithpraneeth/bookstore-microservices.git
cd bookstore-microservices


Build and run with Docker Compose:
docker-compose build
docker-compose up -d


Access services:

Book Service: http://localhost:8081/api/books
Order Service: http://localhost:8082/api/orders



Testing
Use Postman or curl to test APIs (see below).
APIs
Book Service

POST /api/books: Create a book
GET /api/books: Get all books
GET /api/books/{id}: Get a book
DELETE /api/books/{id}: Delete a book

Order Service

POST /api/orders: Create an order
GET /api/orders: Get all orders
GET /api/orders/{id}: Get an order
PUT /api/orders/{id}/cancel: Cancel an order

Stop
docker-compose down


