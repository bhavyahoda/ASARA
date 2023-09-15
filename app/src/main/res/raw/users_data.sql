CREATE TABLE IF NOT EXISTS Users (
    UserID INT PRIMARY KEY ,
    PhoneNumber BIGINT UNIQUE NOT NULL CHECK (LENGTH(CAST(PhoneNumber As BIGINT)) = 10),
    Name TEXT(50) NOT NULL,
    Password TEXT(50) NOT NULL
);

-- Sample data with 10-digit integer phone numbers
INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (1234567890, 'Alice', 'password123');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (9876543210, 'Bob', 'securepass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (5555555555, 'Charlie', 'pass1234');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (1112223333, 'David', 'davidpass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (5551234567, 'Eve', 'evepassword');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (8888888888, 'Frank', 'frankpass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (9999999999, 'Grace', 'grace123');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (7777777777, 'Hannah', 'hannahpass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (4444444444, 'Isaac', 'isaacpass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (2223334444, 'Jack', 'jackpassword');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (1235557777, 'Kate', 'katepass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (3335558888, 'Laura', 'laurapassword');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (5556667777, 'Mike', 'mikepass');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (9998887777, 'Nancy', 'nancypassword');

INSERT INTO Users (PhoneNumber, Name, Password)
VALUES (7776665555, 'Oliver', 'oliverpass');