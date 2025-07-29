CREATE DATABASE IF NOT EXISTS ufc_fighters;
USE ufc_fighters;

CREATE TABLE fighters (
    fighter_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    height DECIMAL(3,2),          -- in meters
    weight DECIMAL(5,2),          -- in kg
    division VARCHAR(50),
    record VARCHAR(20),           -- e.g., "22-5-0"
    strikes_per_minute DECIMAL(4,2),
    takedown_accuracy DECIMAL(4,2)
);

INSERT INTO fighters VALUES
(1, 'Islam Makhachev', 32, 1.78, 70.3, 'Lightweight', '25-1-0', 3.48, 2.32),
(2, 'Alex Pereira', 36, 1.93, 84.4, 'Light Heavyweight', '9-2-0', 5.27, 0.00);
-- Add 8 more fighters