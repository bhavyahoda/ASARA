CREATE TABLE IF NOT EXISTS Animal (
    AnimalID INT PRIMARY KEY AUTOINCREMENT,
    Name TEXT(50) NOT NULL,
    Species TEXT(50) NOT NULL,
    Breed TEXT(50),
    DateOfBirth DATE
);

-- Insert Data into Animal Table
-- Sample 1
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Mittens', 'Cat', 'Siamese', '2020-01-20');

-- Sample 2
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Fido', 'Dog', 'Golden Retriever', '2021-09-03');

-- Sample 3
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Bubbles', 'Fish', NULL, '2023-03-04');

-- Sample 4
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Tigger', 'Tiger', 'Bengal', '2020-12-24');

-- Sample 5
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Rocky', 'Raccoon', NULL, '2018-06-10');

-- Sample 6
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Whiskers', 'Cat', 'Persian', '2022-08-30');

-- Sample 7
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Rover', 'Dog', 'Labrador Retriever', '2023-10-21');

-- Sample 8
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Fluffy', 'Cat', 'Maine Coon', '2023-11-12');

-- Sample 9
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Rex', 'Dog', 'German Shepherd', '2022-01-26');

-- Sample 10
INSERT INTO Animal (Name, Species, Breed, DateOfBirth)
VALUES ('Spike', 'Hedgehog', NULL, '2023-08-15');
