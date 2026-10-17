# Smart Clinic Management System — Database Schema

## 1. Patient Table
Stores patient details.

| Column | Data Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| name | VARCHAR(100) | Patient name |
| age | INT | Patient age |
| gender | VARCHAR(20) | Patient gender |
| email | VARCHAR(150) | Patient email |
| password | VARCHAR(255) | Patient password |

## 2. Doctor Table
Stores doctor details.

| Column | Data Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| name | VARCHAR(100) | Doctor name |
| specialty | VARCHAR(100) | Medical specialty |
| available_time | VARCHAR(100) | Available time |
| email | VARCHAR(150) | Doctor email |

## 3. Appointment Table
Stores appointment details.

| Column | Data Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| patient_id | BIGINT | Patient ID |
| doctor_id | BIGINT | Doctor ID |
| appointment_date | VARCHAR(50) | Appointment date |
| appointment_time | VARCHAR(50) | Appointment time |
| status | VARCHAR(30) | Appointment status |

## Relationships
- One patient can have multiple appointments.
- One doctor can have multiple appointments.
- Each appointment refers to a patient and a doctor.

## Note
This schema describes the current prototype models. Database constraints and authentication security should be verified during implementation.
