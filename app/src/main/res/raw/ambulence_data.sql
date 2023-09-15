CREATE TABLE IF NOT EXISTS AmbulanceDetails (
    AmbulanceID INT,
    VehicleNumber TEXT UNIQUE NOT NULL,
    DriverName TEXT NOT NULL,
    DriverContact BIGINT NOT NULL CHECK (LENGTH(DriverContact) = 10)
);


-- Sample data for AmbulanceDetails
INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB123', 'John Doe', 1234567890);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB456', 'Jane Smith', 9876543210);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB789', 'Michael Johnson', 5555555555);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB101', 'Emily Davis', 1112223333);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB202', 'Sarah Wilson', 5551234567);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB303', 'Robert Lee', 8888888888);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB404', 'Maria Martinez', 9999999999);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB505', 'William Taylor', 7777777777);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB606', 'Linda Anderson', 4444444444);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB707', 'Daniel White', 2223334444);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB808', 'Jessica Brown', 1235557777);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB909', 'Matthew Green', 3335558888);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB010', 'Karen Hall', 5556667777);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB111', 'Christopher Evans', 9998887777);

INSERT INTO AmbulanceDetails (VehicleNumber, DriverName, DriverContact)
VALUES ('AMB212', 'Amanda Turner', 7776665555);