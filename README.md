<div align="center">

# ⚙️ SHIPPSURE — BACKEND RESTFUL LOGISTICS & DISPATCH SERVICE

### ⚡ Central Microservice Architecture & Fleet Telemetry Engine
### 💻 Spring Boot 3 + Spring Data JPA + MySQL + Java 17

<br/>

<a href="#"><img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white" /></a>
<a href="#"><img src="https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" /></a>
<a href="#"><img src="https://img.shields.io/badge/Spring_Data_JPA-3.2.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white" /></a>
<a href="#"><img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" /></a>
<a href="#"><img src="https://img.shields.io/badge/Hibernate-6.x-59666C?style=for-the-badge&logo=hibernate&logoColor=white" /></a>
<a href="#"><img src="https://img.shields.io/badge/Maven-3.9.6-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" /></a>

<br/><br/>

> 🔗 **Companion Repository:** This backend REST service powers the [**ShippSure Frontend Web Application**](https://github.com/aniketlabs77/ShippSure---The-AI-Logistics-Frontend-SpringBoot-Thymleaf-).

</div>

---

## 📖 Overview

> **ShippSure Backend** is a high-performance RESTful microservice built with **Java 17, Spring Boot, Spring Data JPA, and MySQL**.

It acts as the single source of truth for the entire ShippSure logistics network, handling **driver fleet telemetry**, **binary document storage**, **order lifecycles**, **geographical candidate discovery**, and **administrative oversight**.

### 🎯 Key Responsibilities

| Responsibility | Logo | Description |
|----------------|:---:|-------------|
| 🚚 **Driver Telemetry & Fleet** | <img src="https://img.icons8.com/color/32/000000/delivery.png"/> | Registration, RC & Driving License binary persistence, verification approval lifecycles |
| 🔄 **State Machine Management** | <img src="https://img.icons8.com/color/32/000000/synchronize.png"/> | Atomic duty status (`Free` $\leftrightarrow$ `Busy`) and shipment stages (`Pending` $\rightarrow$ `InTransit` $\rightarrow$ `Delivered`) |
| 📍 **Dispatch Candidate Queries** | <img src="https://img.icons8.com/color/32/000000/search-more.png"/> | High-speed multi-parameter search for available fleet drivers by vehicle type & status |
| 📊 **Central Data Persistence** | <img src="https://img.icons8.com/color/32/000000/database.png"/> | Transactional relational storage with Hibernate 6 and MySQL 8.0 |

---

## 🛠️ Technology Stack

| Technology | Version | Logo | Description |
|------------|---------|:---:|-------------|
| ☕ **Java** | 17 LTS | <img src="https://img.icons8.com/color/32/000000/java-coffee-cup-logo.png"/> | Core enterprise programming language |
| 🍃 **Spring Boot** | 3.x | <img src="https://img.icons8.com/color/32/000000/spring-logo.png"/> | High-performance RESTful application framework |
| 📊 **Spring Data JPA** | 3.x | <img src="https://img.icons8.com/color/32/000000/database.png"/> | Object-Relational Mapping (ORM) and repository layer |
| 🗄️ **MySQL Database** | 8.0 | <img src="https://img.icons8.com/color/32/000000/mysql-logo.png"/> | Persistent relational database storage |
| ⚙️ **Hibernate** | 6.x | <img src="https://img.icons8.com/color/32/000000/hibernate.png"/> | Core JPA entity lifecycle provider |
| 📦 **Apache Maven** | 3.9+ | <img src="https://img.icons8.com/color/32/000000/maven.png"/> | Build lifecycle & dependency management |

---

## 🏗️ System Architecture & Data Flow

### 📊 Component Breakdown:

| Component | Logo | Responsibility |
|-----------|:---:|----------------|
| **REST Controllers** | <img src="https://img.icons8.com/color/32/000000/api-settings.png"/> | Expose HTTP REST endpoints for client applications |
| **Service Layer** | <img src="https://img.icons8.com/color/32/000000/services.png"/> | Business logic, state validation, and transactional workflows |
| **Repository Layer** | <img src="https://img.icons8.com/color/32/000000/data-configuration.png"/> | Spring Data JPA query interfaces with Spring Query derivation |
| **Entity Layer** | <img src="https://img.icons8.com/color/32/000000/entity.png"/> | Relational entity mappings (`Driver`, `Shipment`, `Customer`, `Admin`) |
| **Database Conduit** | <img src="https://img.icons8.com/color/32/000000/database.png"/> | MySQL 8.0 schema (`ailogistic`) with connection pooling |

### 🔄 End-to-End REST Flow:
```
ShippSure Frontend (Port 2222)
            ↓ (HTTP JSON / REST)
Spring MVC RestController Layer
            ↓
Spring Service Layer (Business Rules & Timestamping)
            ↓
Spring Data JPA Repositories
            ↓
MySQL Database (Schema: ailogistic on Port 3306)
```

---

## 📁 Project Structure

```
⚙️ AI-Logistics-Backend/
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/com/aniket/
│   │   │   ├── 📂 controller/
│   │   │   │   ├── 📄 AdminController.java
│   │   │   │   ├── 📄 AiLogisticController.java
│   │   │   │   ├── 📄 CustomerController.java
│   │   │   │   ├── 📄 DriverController.java
│   │   │   │   └── 📄 ShipmentController.java
│   │   │   ├── 📂 entity/
│   │   │   │   ├── 📄 Admin.java
│   │   │   │   ├── 📄 Customer.java
│   │   │   │   ├── 📄 Driver.java
│   │   │   │   └── 📄 Shipment.java
│   │   │   ├── 📂 repo/
│   │   │   │   ├── 📄 AdminRepo.java
│   │   │   │   ├── 📄 CustomerRepo.java
│   │   │   │   ├── 📄 DriverRepo.java
│   │   │   │   └── 📄 ShipmentRepo.java
│   │   │   ├── 📂 service/
│   │   │   │   ├── 📄 AdminService.java
│   │   │   │   ├── 📄 CustomerService.java
│   │   │   │   ├── 📄 DriverService.java
│   │   │   │   └── 📄 ShipmentService.java
│   │   │   ├── 📄 AILogisticsBackendApplication.java
│   │   │   └── 📄 DataInitializer.java
│   │   └── 📂 resources/
│   │       └── 📄 application.properties.example
├── 📄 .gitignore
├── 📄 FUTURE_ENHANCEMENTS.md
├── 📄 pom.xml
└── 📄 README.md
```

---

## 🌐 API Endpoints Reference

### 1. 🚚 Driver Fleet Telemetry (`/driver`)

| Method | Endpoint | Logo | Description | Example Request / Param |
|:---:|---|:---:|---|---|
| `POST` | `/driver/register` | <img src="https://img.icons8.com/color/24/000000/add-user-male.png"/> | Register new driver with RC & License binary | Multipart form data |
| `GET` | `/driver/findByEmail/{email}` | <img src="https://img.icons8.com/color/24/000000/search.png"/> | Fetch driver profile by email | `/driver/findByEmail/driver@gmail.com` |
| `PUT` | `/driver/setStatus/{status}/{email}` | <img src="https://img.icons8.com/color/24/000000/approval.png"/> | Admin verification (`Activated`, `Rejected`) | `/driver/setStatus/Activated/driver@gmail.com` |
| `PUT` | `/driver/setRideStatus/{email}` | <img src="https://img.icons8.com/color/24/000000/switch.png"/> | Toggle driver duty (`Free` $\leftrightarrow$ `Busy`) | `/driver/setRideStatus/driver@gmail.com` |
| `GET` | `/driver/findAllByStatusAndRideStatus/{status}/{rideStatus}` | <img src="https://img.icons8.com/color/24/000000/radar.png"/> | Query available fleet candidates | `/driver/findAllByStatusAndRideStatus/Activated/Free` |

---

### 2. 📦 Shipment Lifecycle (`/shipment`, `/customer`)

| Method | Endpoint | Logo | Description | Example Request / Param |
|:---:|---|:---:|---|---|
| `POST` | `/customer/saveorder` | <img src="https://img.icons8.com/color/24/000000/box.png"/> | Persist newly booked shipment | JSON Shipment object |
| `GET` | `/shipment/getAllShipments` | <img src="https://img.icons8.com/color/24/000000/list.png"/> | Fetch entire network shipment manifest | `/shipment/getAllShipments` |
| `GET` | `/shipment/getShipmentById/{id}` | <img src="https://img.icons8.com/color/24/000000/barcode.png"/> | Retrieve shipment by ID | `/shipment/getShipmentById/1` |
| `GET` | `/shipment/getAllShipmentByCustomer_id/{id}/{status}` | <img src="https://img.icons8.com/color/24/000000/customer-insight.png"/> | Customer order history | `/shipment/getAllShipmentByCustomer_id/user@gmail.com/All` |
| `GET` | `/shipment/getAllShipmentByDriver_id/{id}/{status}` | <img src="https://img.icons8.com/color/24/000000/delivery.png"/> | Driver delivery queue | `/shipment/getAllShipmentByDriver_id/driver@gmail.com/Pending` |
| `PUT` | `/shipment/setStatus/{status}/{id}` | <img src="https://img.icons8.com/color/24/000000/checkmark.png"/> | Update stage (`InTransit`, `Delivered`) | `/shipment/setStatus/Delivered/1` |
| `PUT` | `/shipment/updateLocation/{lat}/{lng}/{id}` | <img src="https://img.icons8.com/color/24/000000/marker.png"/> | Update live GPS coordinates | `/shipment/updateLocation/28.5355/77.3910/1` |

---

### 📋 Example JSON Payload & Response

#### POST /customer/saveorder (Request Body)
```json
{
  "customer_id": "customer@gmail.com",
  "customer_name": "Rahul Verma",
  "driver_id": "driver@gmail.com",
  "driver_name": "Amit Sharma",
  "vtype": "Cargo Auto",
  "amount": 250.00,
  "pickup_latitude": 28.5355,
  "pickup_longitude": 77.3910,
  "drop_latitude": 28.6139,
  "drop_longitude": 77.2090,
  "pickup_address": "Noida Sector 62, Uttar Pradesh",
  "drop_address": "Connaught Place, New Delhi",
  "status": "Pending"
}
```

#### GET /shipment/getShipmentById/1 (Response)
```json
{
  "id": 1,
  "vtype": "Cargo Auto",
  "description": "Electronics cartons",
  "customer_id": "customer@gmail.com",
  "customer_name": "Rahul Verma",
  "driver_id": "driver@gmail.com",
  "driver_name": "Amit Sharma",
  "amount": 250.00,
  "status": "InTransit",
  "current_latitude": 28.5601,
  "current_longitude": 77.3105,
  "pickup_datetime": "2026-11-06T12:00:00"
}
```

---

## 🚀 Getting Started

### 📋 Prerequisites

| Software | Version | Logo |
|----------|---------|:---:|
| ☕ **Java** | 17+ | <img src="https://img.icons8.com/color/24/000000/java-coffee-cup-logo.png"/> |
| 📦 **Maven** | 3.8+ | <img src="https://img.icons8.com/color/24/000000/maven.png"/> |
| 🗄️ **MySQL** | 8.0+ | <img src="https://img.icons8.com/color/24/000000/mysql-logo.png"/> |
| 💻 **IDE** | STS / IntelliJ / Eclipse | <img src="https://img.icons8.com/color/24/000000/visual-studio-code-2019.png"/> |

---

### 📥 Step-by-Step Installation

#### 1️⃣ Create MySQL Database
```sql
CREATE DATABASE ailogistic;
```

#### 2️⃣ Clone Repository
```bash
git clone https://github.com/aniketlabs77/ShippSure-The-AI-Logistics-SpringBoot-Backend-.git
cd ShippSure-The-AI-Logistics-SpringBoot-Backend-
```

#### 3️⃣ Properties Configuration
Copy the configuration template:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Verify or update database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ailogistic?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=pass@sql
```
*(Supports standard environment variable overrides: `DB_USERNAME`, `DB_PASSWORD`, `DB_URL`)*

#### 4️⃣ Build & Run
```bash
# Build the application
mvn clean install

# Start the Backend Microservice (Runs on Port 3333)
mvn spring-boot:run
```

---

## 👤 Author

### Aniket Singh Chauhan

<table>
  <tr>
    <td><img src="https://img.icons8.com/fluency/48/000000/github.png"/></td>
    <td><b>GitHub</b></td>
    <td><a href="https://github.com/aniketlabs77">@aniketlabs77</a></td>
  </tr>
  <tr>
    <td><img src="https://img.icons8.com/fluency/48/000000/linkedin.png"/></td>
    <td><b>LinkedIn</b></td>
    <td><a href="https://linkedin.com/in/aniket-singh-chauhan-740350305/">Aniket Singh Chauhan</a></td>
  </tr>
  <tr>
    <td><img src="https://img.icons8.com/fluency/48/000000/gmail.png"/></td>
    <td><b>Email</b></td>
    <td><a href="mailto:aniketsinghchauhan77@gmail.com">aniketsinghchauhan77@gmail.com</a></td>
  </tr>
</table>

---

<div align="center">

**ShippSure — Move Smart. Ship Sure.**

**Spring Boot 3 + Spring Data JPA + MySQL + Java 17**

</div>
