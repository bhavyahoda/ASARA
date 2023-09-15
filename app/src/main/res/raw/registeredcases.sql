CREATE TABLE IF NOT EXISTS RegisteredCases (
    CaseID INT PRIMARY KEY ,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Sample data for RegisteredCases
INSERT INTO RegisteredCases (UserID)
VALUES (8000);  -- Mapping CaseID 1000 to UserID 800

INSERT INTO RegisteredCases (UserID)
VALUES (8002);  -- Mapping CaseID 1001 to UserID 8002

INSERT INTO RegisteredCases (UserID)
VALUES (8003);  -- Mapping CaseID 1002 to UserID 8003

INSERT INTO RegisteredCases (UserID)
VALUES (8004);  -- Mapping CaseID 1003 to UserID 8004

INSERT INTO RegisteredCases (UserID)
VALUES (8000);  -- Mapping CaseID 1004 to UserID 8000

INSERT INTO RegisteredCases (UserID)
VALUES (8002);  -- Mapping CaseID 1005 to UserID 8002

INSERT INTO RegisteredCases (UserID)
VALUES (8007);  -- Mapping CaseID 1006 to UserID 8007

INSERT INTO RegisteredCases (UserID)
VALUES (8005);  -- Mapping CaseID 1007 to UserID 8005

INSERT INTO RegisteredCases (UserID)
VALUES (8002);  -- Mapping CaseID 1008 to UserID 8002

INSERT INTO RegisteredCases (UserID)
VALUES (8005);  -- Mapping CaseID 1009 to UserID 8005

INSERT INTO RegisteredCases (UserID)
VALUES (8002);  -- Mapping CaseID 1010 to UserID 8002

INSERT INTO RegisteredCases (UserID)
VALUES (8008);  -- Mapping CaseID 1011 to UserID 8008

INSERT INTO RegisteredCases (UserID)
VALUES (8003);  -- Mapping CaseID 1012 to UserID 8003

INSERT INTO RegisteredCases (UserID)
VALUES (8004);  -- Mapping CaseID 1013 to UserID 8004

INSERT INTO RegisteredCases (UserID)
VALUES (8005);  -- Mapping CaseID 1014 to UserID 8005

