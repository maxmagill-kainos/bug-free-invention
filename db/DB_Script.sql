CREATE DATABASE teamC_Josh;

USE teamC_Josh;

CREATE TABLE capability(
    capabilityID TINYINT PRIMARY KEY AUTOINCREMENT, 
    capabilityName varchar (40) NOT NULL
);

CREATE TABLE jobFamily(
    jobFamilyID TINYINT PRIMARY KEY AUTOINCREMENT,
    jobFamilyTitle varchar (40) NOT NULL,
    capabilityID TINYINT,
    FOREIGN KEY (`capabilityID`) REFERENCES `capability`(`capabilityID`)
);

CREATE TABLE band(
    bandID TINYINT PRIMARY KEY AUTOINCREMENT,
    bandName varchar (40), 
    bandLevel TINYINT NOT NULL, 
    bandTraining text, 
    bandCompetencies text, 
    bandResponsibilites text
);

CREATE TABLE job(
    jobID SMALLINT PRIMARY KEY AUTOINCREMENT,
    jobTitle varchar (50) NOT NULL,
    jobSpec text NOT NULL,
    bandID TINYINT,
    jobFamilyID TINYINT,
    capabilityID TINYINT,
    FOREIGN KEY (`bandID`) REFERENCES `band`(`bandID`),
    FOREIGN KEY (`jobFamilyID`) REFERENCES `jobFamily`(`jobFamilyID`),
    FOREIGN KEY (`capabilityID`) REFERENCES `capability`(`capabilityID`)
);

CREATE TABLE employee(
    employeeID SMALLINT PRIMARY KEY AUTOINCREMENT,
    fName varchar (40) NOT NULL,
    lName varchar (40) NOT NULL,
    username varchar (40) NOT NULL,
    userPassword varchar (60) NOT NULL,
    isAdmin boolean NOT NULL, 
    jobID SMALLINT NOT NULL, 
    FOREIGN KEY (`jobID`) REFERENCES `job`(`jobID`)
);
