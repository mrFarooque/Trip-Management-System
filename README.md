# REST API for an Online Trip Management System

- We have developed this REST API for an Online Trip Management System. This API performs all the fundamental CRUD operations of any Trip Management Application platform with user validation at every step.
- This project is developed by team of 5 Back-End Developers during project week in Masai School.

## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Swagger
- Lombok

## Modules

- Login, Logout Module
- User Module
- Admin Module
- Booking Management Module
- Feedback Module
- Report Module
- Trip Package Management Module
- Route Mangement Module

## Features

- User and Admin authentication & validation with session uuid having.
- Admin Features:
  - Administrator Role of the entire application
  - Only registered admins with valid session token can add/update/delete Package,Hotel,Route or customer from main database.
  - Admin can access the details of different Routes, Bus, Packages, TicketDetails,Feedback,Customer,Reports,etc.
- User Features:
  - A user can register himself or herself on the platform.
  - He/She can check the Packages and Hotels availabilty.
  - If Trip Package is available, can book the trip package by providing payment details.
  - After booking, he will get booking details for the whole Package inside this there will be all details regarding the ticket details ,total cost, etc.
  - If the customer want can cancel the booking.

## Contributors

- [@Tridip Rong](https://github.com/TridipRong)
- [@MD Farooque Ansari](https://github.com/mrFarooque)
- [@Pushpam Kumar](https://github.com/pushpam-386)
- [@Saurabh Pragrut](https://github.com/SaurabhPagrut)
- [@Efat Husneara](https://github.com/efat56)

## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties](https://github.com/mrFarooque/rightful-order-9279/blob/main/TripManagementSystem/src/main/resources/application.properties) file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/tmsdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## AWS Deployed link

## API Root Endpoint

`https://localhost:8080/`

`http://localhost:8080/swagger-ui/`

## API Module Endpoints

### Login Module

- `POST //api/adminlogin` : Admin can login with mobile number and password provided at the time of registation
<!--

### User Module

- `POST /customer/login` : Logging in customer with valid mobile number & password
- `GET /customer/availablecabs` : Getting the list of all the available cabs
- `GET /customers/cabs` : Getting All the cabs
- `GET /customers/checkhistory` : Getting the history of completed tr
- `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
- `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
- `POST /customer/booktrip` : Customer can book a cab
- `POST /customer/updatetrip` : Customer can modify or update the trip
- `POST /customer/logout` : Logging out customer based on session token
- `DELETE /customer/delete` : Deletes logged in user
- `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid
- `DELETE /customer/canceltrip` : Cancel the trip with the given tripid

### Admin Module

- `POST /admin/register` : Register a new admin with proper data validation and admin session
- `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
- `GET /admin/logout` : Logging out admin based on session token
- `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
- `GET /admin/listoftrips` : Get list of trips of all the trips
- `GET /admin/listocustomers` : Get list of all the customers
- `GET /admin/listodrivers` : Get list of all the drivers
- `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
- `DELETE /admin/delete` : Deletes the admin with passed id -->

### Sample API Response for Admin Login

`POST localhost:8080/login/adminlogin`

- Request Body

```
    {
        "mobileNo": "7056319981",
        "password": "Clickme@007"
    }
```

- Response

```
   CurrentAdminSession(id=11, adminId=10, uuid=ZaVLaK, localDateTime=2022-08-17T11:13:42.772910500)

```

## Video Explainer of flow control

<a href="https://drive.google.com/file/d/17K024rskhj2pOkma9BQkG0Zxeozvd3XA/view?usp=sharing">**Video Drive Link** </a>

### E-R Diagram Of Covid-19 Application

---

<img src=".\Images\ER_Diagram_TMS.jpeg" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Swagger UI

---

<img src=".\Images\SwaggerUI.png" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Login Controller

---

<img src=".\Images\LogInController.png" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Admin Controller

---

<img src=".\Images\AdminController.png" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### User Controller

---

<img src=".\Images\CustomerController.png" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Model Controller

---

<img src=".\Images\Models.png" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

<img src="https://github.com/shivamgarg796/Spring-work/blob/master/Images/Thank-you-word-cloud.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---
