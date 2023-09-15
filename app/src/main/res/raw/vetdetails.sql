CREATE TABLE IF NOT EXISTS VetDetails (
    VetID INT PRIMARY KEY ,
    LicenseNumber TEXT(20) UNIQUE NOT NULL,
    Name TEXT(255) NOT NULL,
    Contact BIGINT NOT NULL CHECK (LENGTH(CAST(Contact AS BIGINT)) = 10)
);

-- Sample data for VetDetails
INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET12345', 'Dr. Alice Smith', 1234567890);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET54321', 'Dr. John Doe', 9876543210);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET98765', 'Dr. Emily Davis', 5555555555);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET56789', 'Dr. Michael Johnson', 1112223333);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET45678', 'Dr. Jessica Brown', 5551234567);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET65432', 'Dr. Robert Lee', 8888888888);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET23456', 'Dr. Maria Martinez', 9999999999);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET87654', 'Dr. William Taylor', 7777777777);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET34567', 'Dr. Linda Anderson', 4444444444);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET76543', 'Dr. Daniel White', 2223334444);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET12349', 'Dr. Sarah Wilson', 1235557777);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET98761', 'Dr. Karen Hall', 3335558888);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET45673', 'Dr. Christopher Evans', 5556667777);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET23459', 'Dr. Amanda Turner', 9998887777);

INSERT INTO VetDetails (LicenseNumber, Name, Contact)
VALUES ('VET87659', 'Dr. Matthew Green', 7776665555);