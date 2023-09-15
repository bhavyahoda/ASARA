CREATE TABLE IF NOT EXISTS StatusDetails (
    StatusID INT PRIMARY KEY ,
    Description TEXT(255) NOT NULL
);
-- Inserting status values into StatusDetails
INSERT INTO StatusDetails (Description)
VALUES ('Case Reported');

INSERT INTO StatusDetails (Description)
VALUES ('Ambulance Assigned');

INSERT INTO StatusDetails (Description)
VALUES ('Ambulance Dispatched');

INSERT INTO StatusDetails (Description)
VALUES ('Ambulance Arrived');

INSERT INTO StatusDetails (Description)
VALUES ('Diagnosis & Rehab');

INSERT INTO StatusDetails (Description)
VALUES ('Discharged');