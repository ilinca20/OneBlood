INSERT INTO doctors (first_name, last_name, specialty, phone_number, email)
VALUES
('John', 'Doe', 'Cardiology', '555-1234', 'john.doe@one.com'),
('Sarah', 'Connor', 'Immunology', '555-5678', 'sarah.connor@one.com'),
('James', 'Smith', 'Hematology', '555-8765', 'james.smith@one.com');

INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email, status)
VALUES
('Alice', 'Brown', '1985-06-20', 'Female', '555-1122', 'alice.brown@example.com', 'ELIGIBLE'),
('Bob', 'Johnson', '1978-02-12', 'Male', '555-3344', 'bob.johnson@example.com', 'ON_HOLD'),
('Catherine', 'Lee', '1990-12-05', 'Female', '555-5566', 'catherine.lee@example.com', 'BLOCKED');

INSERT INTO appointments (doctor_id, patient_id, appointment_date_and_hour, status, city, county, notes)
VALUES
(1, 1, '2024-10-15 10:00:00', 'Completed', 'Iasi', 'Iasi', 'notes'),
(2, 2, '2024-11-16 10:20:00', 'Scheduled', 'Cluj', 'Cluj-Napoca', 'notes'),
(3, 3, '2024-11-16 10:00:00', 'Scheduled', 'Sibiu', 'Sibiu', 'notes');