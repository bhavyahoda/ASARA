CREATE TABLE IF NOT EXISTS VetFacilityMap (
    FacilityID Int,
    VetID Int,
    PRIMARY KEY (FacilityID, VetID),
    FOREIGN KEY (FacilityID) REFERENCES FacilityDetails(FacilityID),
    FOREIGN KEY (VetID) REFERENCES VetDetails(VetID)
);

-- Sample data for VetFacilityMap
-- FacilityID: 9000-9010, VetID: 3000-3010

-- FacilityID 9000
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9000', '3000');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9000', '3001');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9000', '3004');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9000', '3007');

-- FacilityID 9001
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9001', '3002');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9001', '3003');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9001', '3008');

-- FacilityID 9002
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9002', '3004');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9002', '3005');

-- FacilityID 9003
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9003', '3001');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9003', '3005');

-- FacilityID 9004
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9004', '3003');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9004', '3006');

-- FacilityID 9005
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9005', '3007');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9005', '3009');

-- FacilityID 9006
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9006', '3006');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9006', '3008');

-- FacilityID 9007
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9007', '3002');

INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9007', '3009');

-- FacilityID 9008
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9008', '3010');

-- FacilityID 9009
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9009', '3000');

-- FacilityID 9010
INSERT INTO VetFacilityMap (FacilityID, VetID)
VALUES ('9010', '3001');