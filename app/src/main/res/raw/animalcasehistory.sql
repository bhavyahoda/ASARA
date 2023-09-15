CREATE TABLE IF NOT EXISTS AnimalCaseHistory (
    CaseID INT,
    AnimalID INT,
    ASARAInitialDiagnosis TEXT NOT NULL,
    DateOfAdmission DATE NOT NULL,
    DateOfDischarge DATE NOT NULL,
    FacilityID INT,
    VetID INT,
    MedsGiven TEXT,
    VaccinationGiven TEXT,
    Remarks TEXT,
    BillAmount FLOAT,
    BillNo TEXT(50),
    PaidThru TEXT(50),
    PRIMARY KEY (CaseID, AnimalID),
    FOREIGN KEY (CaseID) REFERENCES RegisteredCases(CaseID),
    FOREIGN KEY (AnimalID) REFERENCES Animal(AnimalID),
    FOREIGN KEY (FacilityID) REFERENCES FacilityDetails(FacilityID),
    FOREIGN KEY (VetID) REFERENCES VetDetails(VetID)
);


-- Sample data for AnimalCaseHistory
-- CaseID and AnimalID are primary keys, and there are foreign key references to related tables

-- Case 1
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1001, 1, 'Fever and cough', '2023-08-10', '2023-08-15', 9001, 3001, 'Antibiotics', 'None', 'Recovery progressing well.', 250.00, 'AC1001', 'Credit Card');

-- Case 2
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1002, 2, 'Broken leg', '2023-08-12', '2023-08-20', 9002, 3002, 'Painkillers', 'None', 'Surgery successful.', 500.00, 'AC1002', 'Cash');

-- Case 3
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1003, 3, 'Skin allergy', '2023-08-14', '2023-08-18', 9003, 3003, 'Antihistamines', 'None', 'Improving with treatment.', 150.00, 'AC1003', 'Debit Card');

-- Case 4
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1004, 4, 'Stomach infection', '2023-08-16', '2023-08-22', 9004, 3004, 'Antibiotics', 'None', 'Needs more observation.', 300.00, 'AC1004', 'Cash');

-- Case 5
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1005, 5, 'Dental issues', '2023-08-18', '2023-08-25', 9005, 3005, 'Dental cleaning', 'None', 'Recovered after treatment.', 400.00, 'AC1005', 'Facility Fund');

-- Case 6
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1006, 6, 'Fractured tail', '2023-08-20', '2023-08-23', 9006, 3006, 'Rest and pain management', 'None', 'Tail healing well.', 200.00, 'AC1006', 'Facility Fund');

-- Case 7
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1007, 7, 'Eye infection', '2023-08-22', '2023-08-27', 9007, 3007, 'Eye drops', 'None', 'Infection cleared.', 300.00, 'AC1007', 'Facility Fund');

-- Case 8
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1008, 8, 'Allergic reaction', '2023-08-24', '2023-08-30', 9008, 3008, 'Antihistamines', 'None', 'Responding to treatment.', 250.00, 'AC1008', 'Credit Card');

-- Case 9
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1009, 9, 'Internal parasite', '2023-08-26', '2023-08-31', 9009, 3009, 'Deworming medication', 'None', 'Parasite cleared.', 150.00, 'AC1009', 'Debit Card');

-- Case 10
INSERT INTO AnimalCaseHistory (CaseID, AnimalID, ASARAInitialDiagnosis, DateOfAdmission, DateOfDischarge, FacilityID, VetID, MedsGiven, VaccinationGiven, Remarks, BillAmount, BillNo, PaidThru)
VALUES (1010, 10, 'Injury from accident', '2023-08-28', '2023-09-03', 9010, 3010, 'Pain relief', 'Tetanus shot', 'Recovering steadily.', 350.00, 'AC1010', 'Cash');
