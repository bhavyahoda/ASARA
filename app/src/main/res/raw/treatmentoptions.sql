CREATE TABLE IF NOT EXISTS TreatmentOptions (
    FacilityID INT,
    TreatmentName TEXT(100),
    PRIMARY KEY (FacilityID, TreatmentName),
    FOREIGN KEY (FacilityID) REFERENCES FacilityDetails(FacilityID)
);

-- Sample data for TreatmentOptions
-- FacilityID 9000
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9000, 'Vaccination');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9000, 'Spaying');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9000, 'Neutering');

-- FacilityID 9001
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9001, 'Dental Cleaning');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9001, 'X-ray');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9001, 'Dental Checkup');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9001, 'Orthodontic Consultation');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9001, 'Radiology Services');

-- FacilityID 9002
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9002, 'Flea and Tick Control');

-- FacilityID 9002
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9002, 'Eye Examination');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9002, 'Grooming Services');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9002, 'Chemotherapy');

-- FacilityID 9003
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9003, 'Surgery');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9003, 'Heartworm Testing');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9003, 'Wound Care');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9003, 'Flea and Tick Control');

-- FacilityID 9004
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9004, 'Physical Therapy');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9004, 'Vaccinations');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9004, 'Microchipping');

-- FacilityID 9005
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9005, 'Microchipping');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9005, 'Behavioral Counseling');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9005, 'Deworming');

-- FacilityID 9006
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9006, 'Allergy Testing');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9006, 'Ultrasound');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9006, 'Arthroscopy');

-- FacilityID 9007
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9007, 'Eye Examination');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9007, 'Allergy Testing');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9007, 'Dietary Consultation');

-- FacilityID 9008
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9008, 'Behavioral Counseling');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9008, 'Blood Tests');

-- FacilityID 9009
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9009, 'Ultrasound');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9009, 'Surgery');

-- FacilityID 9010
INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9010, 'Blood Tests');

INSERT INTO TreatmentOptions (FacilityID, TreatmentName)
VALUES (9010, 'Physical Therapy');
