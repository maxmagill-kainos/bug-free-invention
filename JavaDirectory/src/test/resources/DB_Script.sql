





CREATE TABLE capability(
    capabilityID TINYINT PRIMARY KEY AUTO_INCREMENT,
    capabilityName varchar (40) NOT NULL
);

CREATE TABLE jobFamily(
    jobFamilyID TINYINT PRIMARY KEY AUTO_INCREMENT,
    jobFamilyTitle varchar (40) NOT NULL,
    capabilityID TINYINT,
    FOREIGN KEY (`capabilityID`) REFERENCES `capability`(`capabilityID`)
);

CREATE TABLE band(
    bandID TINYINT PRIMARY KEY AUTO_INCREMENT,
    bandName varchar (40),
    bandLevel TINYINT NOT NULL,
    bandTraining text,
    bandCompetencies text,
    bandResponsibilites text
);

CREATE TABLE job(
    jobID SMALLINT PRIMARY KEY AUTO_INCREMENT,
    jobTitle varchar (50) NOT NULL,
    jobSpec text NOT NULL,
    bandID TINYINT,
    jobFamilyID TINYINT,
    capabilityID TINYINT,
    FOREIGN KEY (`bandID`) REFERENCES `band`(`bandID`),
    FOREIGN KEY (`jobFamilyID`) REFERENCES `jobFamily`(`jobFamilyID`),
    FOREIGN KEY (`capabilityID`) REFERENCES `capability`(`capabilityID`)
);
CREATE TABLE jobSummary(
	summaryID int NOT NULL,
    summaryText text(200) NOT NULL,
    jobID smallint NOT NULL,
    PRIMARY KEY (summaryID),
    FOREIGN KEY (jobID) REFERENCES job(jobID)
    );

CREATE TABLE employee(
    employeeID SMALLINT PRIMARY KEY AUTO_INCREMENT,
    fName varchar (40) NOT NULL,
    lName varchar (40) NOT NULL,
    username varchar (40) NOT NULL,
    userPassword varchar (60) NOT NULL,
    isAdmin boolean NOT NULL,
    jobID SMALLINT NOT NULL,
    FOREIGN KEY (`jobID`) REFERENCES `job`(`jobID`)
);
