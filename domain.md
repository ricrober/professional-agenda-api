# Domain Model - Professional Agenda API v1

## Service
- id (Long)
- name (String)
- duration (Integer)
- active (Boolean)

Rules:
- name required
- duration > 0
- Inactive service cannot be used for new appointments

---

## Schedule
- id (Long)
- dayOfWeek Enum (MONDAY-SUNDAY)
- startTime (LocalTime)
- endTime (LocalTime)

Rules:
- startTime < endTime
- Not invalid time ranges
- It can exists multiple schedules per day

---

## Appointment
- id (Long)
- date (LocalDate)
- startTime (LocalTime)
- endTime (LocalTime)
- service (Service)
- status Enum (CREATED, CANCELED)

Rules:
- Appointment must fit in Schedule
- No overlapping appointments
- endTime = startTime + service.duration
- Canceled appointments doesn't lock schedule
