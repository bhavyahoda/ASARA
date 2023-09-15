CREATE TABLE IF NOT EXISTS VetFacilityReview (
    FacilityID Int,
    UserID Int,
    Review TEXT NOT NULL,
    Rating INT NOT NULL CHECK (Rating >= 1 AND Rating <= 5),
    Timestamp DATETIME NOT NULL,
    PRIMARY KEY (FacilityID, UserID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Sample data for VetFacilityReview
-- FacilityID: 9000-9010, Matching PhoneNumber samples from Users

-- FacilityID 9000
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9000, 8000, 'Great experience! Knowledgeable staff.', 5, '2023-09-15 09:30:00');

INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9000, 8001, 'Very friendly and caring team.', 4, '2023-09-15 10:45:00');

-- FacilityID 9001
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9001, 8002, 'Excellent service and cleanliness.', 5, '2023-09-16 11:15:00');

INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9001, 8004, 'Prompt attention to pet emergencies.', 4, '2023-09-16 13:30:00');

-- FacilityID 9002
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9002, 8000, 'Good place for regular checkups.', 3, '2023-09-17 14:45:00');

INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9002, 8003, 'Professional and courteous staff.', 4, '2023-09-17 16:00:00');

-- FacilityID 9003
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9003, 8005, 'Helpful and caring team.', 4, '2023-09-18 08:30:00');

-- FacilityID 9004
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9004, 8006, 'Knowledgeable about pet conditions.', 4, '2023-09-18 09:45:00');

-- FacilityID 9005
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9005, 8007, 'Friendly atmosphere for pets.', 5, '2023-09-19 12:15:00');

-- FacilityID 9006
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9006, 8002, 'Clean and well-maintained facility.', 4, '2023-09-19 14:30:00');

-- FacilityID 9007
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9007, 8005, 'Courteous and efficient service.', 4, '2023-09-20 15:45:00');

-- FacilityID 9008
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9008, 8000, 'Expertise in pet surgeries.', 5, '2023-09-20 17:00:00');

-- FacilityID 9009
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9009, 8008, 'Great place for pet diagnostics.', 4, '2023-09-21 09:30:00');

-- FacilityID 9010
INSERT INTO VetFacilityReview (FacilityID, UserID, Review, Rating, Timestamp)
VALUES (9010, 8009, 'Helped my pet recover quickly.', 5, '2023-09-21 11:45:00');