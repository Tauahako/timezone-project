# Company Timezone management system (CTMS)

## Table of contents

    * About
    * Technologies
    * Key Features
        * Web Application (SPA)
    * Lauch Application

### About
***
**Company Timezone management system (CTMS)** - Backend, Contains 
APIs, business logic, persistence layers. CTMS is a Single Page Application 
that allows a user to manage schedules across different timezones.

### Technologies

    Java 17
    Spring Boot
    Spring Boot Data JPA
    Swagger UI / Springdoc OpenAPI UI
    Lombok
    Gradle
    h2 database

### Key Features

### Single Page Application (SPA)

    Companies Timezone management
        Add timezone
        Update timezone
        Delete timezone
        Show timezone's list configured
        Show timezone details

### Launch Application

### Pre-Requisites

* Install [Docker](https://docs.docker.com/get-docker/)
* Install [Docker Compose](https://docs.docker.com/compose/install/linux/)

### Bootstrap the services 

```zsh
./gradlew build
```
```zsh
docker-compose up
```