# restful-booker-restassured

[![CI](https://github.com/sabrinajohanson/restful-booker-restassured/actions/workflows/ci.yml/badge.svg)](https://github.com/sabrinajohanson/restful-booker-restassured/actions/workflows/ci.yml)

API tests for the Restful Booker application using **Java + Rest Assured + TestNG**.

---

## Project structure

```
restful-booker-restassured/
├── src/
│   └── test/
│       └── java/
│           └── com/sabrina/api/
│               ├── config/
│               │   └── BaseTest.java       # Base configuration for all tests
│               ├── models/
│               │   ├── Booking.java        # Booking request model
│               │   └── BookingDates.java   # Booking dates model
│               └── tests/
│                   └── BookingTest.java    # API tests
├── pom.xml
└── README.md
```

---

## How to run the tests

### 1. Prerequisites

- Java 21+
- Maven 3.9+

### 2. Run all tests

```bash
mvn test
```

---

## Test reports

Every push automatically publishes a full [Allure Report](https://sabrinajohanson.github.io/restful-booker-restassured/) with the detailed results of the test suite (suites, timeline, and per-test steps).

---

## Test coverage

| Method | Endpoint | Test |
|---|---|---|
| GET | `/booking` | Should return list of bookings |
| POST | `/booking` | Should create a booking |
| GET | `/booking/{id}` | Should get booking by ID |
| PUT | `/booking/{id}` | Should update booking |
| PATCH | `/booking/{id}` | Should partially update booking |
| DELETE | `/booking/{id}` | Should delete booking |
| GET | `/booking/999999` | Should return 404 for invalid ID |

---

## Bugs found during development

| # | Bug | Root cause | Status |
|---|---|---|---|
| #1 | PUT returns 418 I'm a Teapot | Restful Booker public environment rejects authentication on Heroku | ✅ Documented |
| #2 | PATCH returns 500 Internal Server Error | Restful Booker public environment is unstable on Heroku | ✅ Documented |

---

## Known limitations

- The Restful Booker public environment hosted on Heroku is unstable for PUT and PATCH operations
- Authentication via token cookie and Basic Auth both affected by environment instability
- Tests for PUT and PATCH accept both success (200) and known failure codes (418/500)

---

## Stack

- Java 21
- Rest Assured 5.4.0
- TestNG 7.9.0
- Jackson Databind 2.17.0
- Maven 3.9+