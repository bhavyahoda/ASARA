CREATE TABLE IF NOT EXISTS FacilityDetails (
    FacilityID INTEGER PRIMARY KEY,
    Name TEXT NOT NULL,
    Address TEXT NOT NULL,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    LicenseNo TEXT UNIQUE NOT NULL,
    ContactPersonName TEXT NOT NULL,
    ContactPersonPhoneNo BIGINT NOT NULL CHECK (LENGTH(CAST(ContactPersonPhoneNo AS TEXT)) = 10),
    AmbulanceAvailable CHAR(1) NOT NULL DEFAULT 'N' CHECK (AmbulanceAvailable IN ('Y', 'N')),
    KennelsNumber INT NOT NULL,
    OperationTables INT NOT NULL,
    StaffNumbers INT NOT NULL,
    AnimalAssisted INT NOT NULL DEFAULT 0
);
-- Sample data for FacilityDetails
INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Pet Haven Vet Clinic', '123 Elm Street', 12.9555, 77.6983, 'LIC12345', 'Dr. Emily Smith', 1234567890, 'Y', 20, 5, 10, 30);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Furry Friends Animal Hospital', '456 Oak Avenue', 12.9300, 77.6853, 'LIC54321', 'Dr. John Doe', 9876543210, 'N', 15, 3, 8, 25);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Paws and Claws Veterinary Clinic', '789 Maple Lane', 12.9351, 77.6255, 'LIC98765', 'Dr. Sarah Johnson', 5555555555, 'Y', 25, 6, 12, 40);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Animal Wellness Center', '321 Pine Road', 'LIC24680', 12.9232, 77.6763, 'Dr. Michael Davis', 1112223333, 'Y', 18, 4, 9, 35);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Healthy Paws Veterinary Care', '567 Birch Lane', 12.9122, 77.6446, 'LIC13579', 'Dr. Jessica White', 4444444444, 'N', 22, 5, 11, 28);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Paw Prints Animal Hospital', '987 Cedar Street', 12.9794, 77.5905, 'LIC86420', 'Dr. Daniel Smith', 7777777777, 'Y', 30, 7, 15, 50);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Companion Animal Clinic', '456 Redwood Avenue', 12.9716, 77.5957, 'LIC97531', 'Dr. Linda Brown', 2223334444, 'N', 12, 2, 6, 18);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Whiskers and Tails Vet Center', '789 Elmwood Lane', 13.3705, 77.6841, 'LIC78901', 'Dr. William Taylor', 3335558888, 'Y', 24, 5, 10, 42);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('PetCare Wellness Clinic', '234 Cedar Road', 12.9495, 77.5899, 'LIC45678', 'Dr. Emily Anderson', 1235557777, 'N', 16, 3, 7, 22);

INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Animal Healing Center', '101 Oakwood Avenue', 13.1986, 77.7066, 'LIC11111', 'Dr. Christopher Evans', 5556667777, 'Y', 28, 6, 14, 48);

-- Facility 12
INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Loving Hearts Vet Clinic', '909 Cedar Avenue', 12.9784, 77.6408, 'LIC6780', 'Daniel Turner', 5552345000, 'N', 7, 1, 9, 1);

-- Facility 13
INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Pets Paradise Vet Center', '1010 Elm Street', 13.1000, 77.5963, 'LIC9010', 'Sarah Davis', 5553456000, 'Y', 15, 3, 20, 5);

-- Facility 14
INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Healing Paws Animal Clinic', '1111 Pine Road', 12.9076, 77.5853, 'LIC2340', 'Michael Turner', 5554567000, 'N', 8, 1, 12, 0);

-- Facility 15
INSERT INTO FacilityDetails (Name, Address, Latitude, Longitude, LicenseNo, ContactPersonName, ContactPersonPhoneNo, AmbulanceAvailable, KennelsNumber, OperationTables, StaffNumbers, AnimalAssisted)
VALUES ('Pet Care Haven', '1212 Cedar Lane', 12.9417, 77.5745, 'LIC5670', 'Emily Wilson', 5555678000, 'Y', 12, 2, 16, 3);