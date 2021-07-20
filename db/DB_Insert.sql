use teamC_Josh;

INSERT INTO capability(capabilityName) VALUES ("Artificial Intelligence");
INSERT INTO capability(capabilityName) VALUES ("Business Development & Marketing");
INSERT INTO capability(capabilityName) VALUES ("Product");
INSERT INTO capability(capabilityName) VALUES ("Cyber Security");
INSERT INTO capability(capabilityName) VALUES ("Data and Analytics");
INSERT INTO capability(capabilityName) VALUES ("Engineering");
INSERT INTO capability(capabilityName) VALUES ("Experienced Design");
INSERT INTO capability(capabilityName) VALUES ("Delivery Management");
INSERT INTO capability(capabilityName) VALUES ("Platforms");

INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Appreciate", 1, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Trainee", 2, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Associate", 3, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Senior", 4, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Consultant", 5, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Manager", 6, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Principle", 7, "", "", "");
INSERT INTO band(bandName,bandLevel, bandTraining, bandCompetencies, bandResponsibilites) 
VALUES ("Leadership Community", 8, "", "", "");

-- Artificial Intelligence
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Artificial Intelligence (AI) Strategy and Planning", 1);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Artificial Intelligence (AI) Engineering", 1);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Data Science", 1);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Practice Manager", "", 7, 1, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Practice Lead", "", 8, 1, 1);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Trainee AI Engineer", "", 2, 2, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Associate AI Engineer", "", 3, 2, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior AI Engineer", "", 4, 2, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Lead AI Engineer", "", 5, 2, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("AI Engineering Manager", "", 6, 2, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Principal AI Engineer", "", 7, 2, 1);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Trainee Data Scientist", "", 2, 3, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Associate Data Scientist", "", 3, 3, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Data Scientist", "", 4, 3, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Consultant Data Scientist", "", 5, 3, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Data Science Manager", "", 6, 3, 1);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Principal Data Scientist", "", 7, 3, 1);


-- Buisness Devleopment
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Strategy and Planning", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Business Development", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Client Management", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Partners", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Bid Production", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Inside Sales", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Marketing - Business", 2);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Marketing - Martech", 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Global Head of Marketing", "", 8, 3, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Business Lead Development", "", 8, 3, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Account Lead", "", 8, 3, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Business Development Associate", "", 3, 4, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Business Development Associate", "", 4, 4, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Business Development Consultant", "", 5, 4, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Business Development Manager", "", 6, 4, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Business Development Director", "", 7, 4, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Customer Success Associate", "", 3, 5, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Customer Success Consultant", "", 4, 5, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Customer Success Manager", "", 5, 5, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Customer Success Manager", "", 6, 5, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Customer Success Director", "", 7, 5, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Cloud Partner Operations Manager", "", 5, 6, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Partners Consultant", "", 5, 6, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Partners Relationship Manager", "", 6, 6, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Partners Director", "", 7, 6, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Bid Production Associate", "", 4, 7, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Technical Pre-Sales Consultant", "", 5, 7, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Bid Production Consultant", "", 5, 7, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Bid Production Manager", "", 6, 7, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Bid Production Director", "", 7, 7, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Sales Development Representative", "", 3, 8, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Sales Development Representative", "", 4, 8, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Sales Development ​​​​​​​Consultant", "", 5, 8, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Sales Development Manager", "", 6, 8, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Demand Generation Director", "", 7, 8, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Marketing Assistant", "", 2, 9, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Marketing Associate", "", 3, 9, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Marketing Executive", "", 4, 9, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Marketing Executive", "", 5, 9, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Marketing Manager", "", 6, 9, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Marketing Director", "", 7, 9, 2);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Martech and Ops Assistant", "", 2, 10, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Martech and Ops Associate", "", 3, 10, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Martech and Ops Executive", "", 4, 10, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Senior Martech and Ops Executive", "", 5, 10, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Digital Strategy Manager", "", 6, 10, 2);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Digital Strategy Director", "", 7, 10, 2);

-- Product
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Product Consultancy", 3);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Digital Advisory Consultancy", 3);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Specialist Consultancy", 3);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant​​​​​​​", "", 2, 11, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant​​​​​​​", "", 3, 11, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant​​​​​​​", "", 4, 11, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant​​​​​​​", "", 5, 11, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant​​​​​​​", "", 6, 11, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Product Consultant", "", 7, 11, 3);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Digital Advisory Consultant", "", 5, 12, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Digital Advisory Consultant", "", 6, 12, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Digital Advisory Consultant", "", 7, 12, 3);

INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Specialist Consultant", "", 2, 13, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Specialist Consultant", "", 3, 13, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Specialist Consultant", "", 4, 13, 3);
INSERT INTO job(jobTitle, jobSpec, bandID, jobFamilyID, capabilityID) VALUES ("Specialist Consultant", "", 5, 13, 3);


-- Cyber Security
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Security Strategy and Planning", 4);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Security Engineering", 4);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Corporate Security", 4);

-- Data
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Data Strategy and Planning", 5);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Data Engineering", 5);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Analysis & Data Architecture ", 5);

-- Engineering
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Engineering ​​​​​​​Strategy and Planning", 6);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Engineering", 6);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Architecture", 6);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Testing and Quality Assurance", 6);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Product Specialist", 6);

-- Experienced Design
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Insights", 7);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Content Design", 7);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("UX / Visual Design", 7);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Service Design", 7);

-- Delivery Management
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Delivery Strategy & Planning", 8);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Delivery Management", 8);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Engineering Management", 8);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Service Management", 8);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Workday Engagement Management", 8);

-- Platorms
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Platform ​​​​​​​Strategy and Planning", 9);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Platform Engineering", 9);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Platform Architecture", 9);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Platform Specialists", 9);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Cloud Migration", 9);
INSERT INTO jobFamily(jobFamilyTitle, capabilityID) VALUES ("Systems Support", 9);


