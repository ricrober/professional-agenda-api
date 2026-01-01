## Professional Agenda API - v1

REST API for managing a professional agenda:
- Services
- Availability schedules
- Internal appointments

This API is designed for **a single professional to manage the agenda**.

---

## Base URL
/api/v1

---

## General
- Content-Type: `application/json`
- Date format: `YYYY-MM-DD`
- Time format `HH:mm`
- Authentication: **Not required**

---

## 1. Services

### Create service
**POST** `/services`

Request:
```json
{
  "name": "Consultation",
  "duration": 30, // Minutes
}
```

Response - **201 Created**
```json
{
  "id": 1,
  "name": "Consultation",
  "duration": 30,
  "active": true
}
```

### Get all services
**GET** `/services`

Response - **200 OK**
```json
[
  {
    "id": 1,
    "name": "Consultation",
    "duration": 30,
    "active": true
  },
  {
    "id": 2,
    "name": "My Consultation",
    "duration": 90,
    "active": false
  }
]
```

### Update service
**PUT** `/services/{id}`

Request:
```json
{
  "name": "Extended consultation",
  "duration": 60,
  "active": true
}
```

Response - **200 OK**
```json
{
  "id": 1,
  "name": "Extended consultation",
  "duration": 60,
  "active": true
}
```

### Delete service
**DELETE** `/services/{id}`

Response - **204 No Content**

---

## 2. Schedules

### Create schedule
**POST** `/schedules`

Request:
```json
{
  "dayOfWeek": "MONDAY",
  "startTime": "09:00",
  "endTime": "17:00"
}
```

Response - **201 Created**
```json
{
  "id": 1,
  "dayOfWeek": "MONDAY",
  "startTime": "09:00",
  "endTime": "17:00"
}
```

### Get all schedules
**GET** `/schedules`

Response - **200 OK**
```json
[
  {
    "id": 1,
    "dayOfWeek": "MONDAY",
    "startTime": "09:00",
    "endTime": "17:00"
  },
  {
    "dayOfWeek": "TUESDAY",
    "startTime": "09:00",
    "endTime": "17:00"
  }
]
```

### Delete schedule
**DELETE** `/schedules/{id}`

Response - **204 No Content**

---

## 3. Appointments

### Create appointment
**POST** `/appointments`

Request:
```json
{
  "date": "2025-02-10",
  "startTime": "10:00",
  "serviceId": 1
}
```

Response: - **201 Created**
```json
{
  "id": 1,
  "date": "2025-02-10",
  "startTime": "10:00",
  "endTime": "10:30",
  "serviceId": 1,
  "status": "CREATED"
}
```

### Cancel appointment

**DELETE** `/appointments/{id}`

Response: - **204 No Content**

### Get daily agenda
**GET** `/appointments/daily?date=2025-02-10`

Response: - **200 OK**
```json
{
  "id": 1,
  "startTime": "10:00",
  "endTime": "10:30",
  "serviceName": "Consultation",
  "status": "CREATED"
}
```

## 4. Error responses

### 400 Bad Request
```json
{
  "error": "Invalid request data"
}
```

### 404 Not Found
```json
{
  "error": "Resource not found"
}
```

### 409 Conflict
```json
{
  "error": "Appointment overlaps with an existing appointment"
}
