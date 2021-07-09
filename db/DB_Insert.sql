use teamC_Josh;

INSERT INTO Capability(Capability_Name) VALUES ("Artificial Intelligence");
INSERT INTO Capability(Capability_Name) VALUES ("Buisness Development & Marketing");
INSERT INTO Capability(Capability_Name) VALUES ("Product");
INSERT INTO Capability(Capability_Name) VALUES ("Cyber Security");
INSERT INTO Capability(Capability_Name) VALUES ("Data and Analytics");
INSERT INTO Capability(Capability_Name) VALUES ("Engineering");
INSERT INTO Capability(Capability_Name) VALUES ("Experienced Design");
INSERT INTO Capability(Capability_Name) VALUES ("Delivery Management");
INSERT INTO Capability(Capability_Name) VALUES ("Platforms");

INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Appreciate", 1, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Trainee", 2, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Associate", 3, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Senior", 4, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Consultant", 5, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Manager", 6, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Principle", 7, "", "", "");
INSERT INTO Band(Band_Name,Band_Level, Band_Training, Band_Competencies, Band_Responsibilites) 
VALUES ("Leadership Community", 8, "", "", "");

-- Artificial Intelligence
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Artificial Intelligence (AI) Strategy and Planning", 1);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Artificial Intelligence (AI) Engineering", 1);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Data Science", 1);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Practise Manager", "", 7, 1, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Practise Lead", "", 8, 1, 1);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Trainee AI Engineer", "", 2, 2, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Associate AI Engineer", "", 3, 2, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior AI Engineer", "", 4, 2, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Lead AI Engineer", "", 5, 2, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("AI Engineering Manager", "", 6, 2, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Principal AI Engineer", "", 7, 2, 1);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Trainee Data Scientist", "", 2, 3, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Associate Data Scientist", "", 3, 3, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Data Scientist", "", 4, 3, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Consultant Data Scientist", "", 5, 3, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Data Science Manager", "", 6, 3, 1);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Prinicple Data Scientist", "", 7, 3, 1);


-- Buisness Devleopment
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Strategy and Planning", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Business Development", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Client Managment", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Partners", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Bid Production", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Inside Sales", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Marketing - Business", 2);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Marketing - Martech", 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Global Head of Marketing", "", 8, 3, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Businsess Lead Development", "", 8, 3, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Account Lead", "", 8, 3, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Business Development Associate", "", 3, 4, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Business Development Associate", "", 4, 4, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Business Development Consultant", "", 5, 4, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Business Development Manager", "", 6, 4, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Business Development Director", "", 7, 4, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Customer Success Associate", "", 3, 5, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Customer Success Consultant", "", 4, 5, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Customer Success Manager", "", 5, 5, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Customer Success Manager", "", 6, 5, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Customer Success Director", "", 7, 5, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Cloud Partner Operations Manager", "", 5, 6, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Partners Consultant", "", 5, 6, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Partners Relationship Manager", "", 6, 6, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Partners Director", "", 7, 6, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Bid Production Associate", "", 4, 7, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Technical Pre-Sales Consultant", "", 5, 7, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Bid Production Consultant", "", 5, 7, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Bid Production Manager", "", 6, 7, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Bid Production Director", "", 7, 7, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Sales Development Representative", "", 3, 8, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Sales Development Representative", "", 4, 8, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Sales Development ​​​​​​​Consultant", "", 5, 8, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Sales Development Manager", "", 6, 8, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Demand Generation Director", "", 7, 8, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Marketing Assistant", "", 2, 9, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Marketing Associate", "", 3, 9, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Marketing Executive", "", 4, 9, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Marketing Executive", "", 5, 9, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Marketing Manager", "", 6, 9, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Marketing Director", "", 7, 9, 2);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Martech and Ops Assistant", "", 2, 10, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Martech and Ops Associate", "", 3, 10, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Martech and Ops Executive", "", 4, 10, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Senior Martech and Ops Executive", "", 5, 10, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Digital Strategy Manager", "", 6, 10, 2);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Digital Strategy Director", "", 7, 10, 2);

-- Product
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Product Consultancy", 3);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Digital Advisory Consultancy", 3);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Specialist Consultancy", 3);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant​​​​​​​", "", 2, 11, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant​​​​​​​", "", 3, 11, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant​​​​​​​", "", 4, 11, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant​​​​​​​", "", 5, 11, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant​​​​​​​", "", 6, 11, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Product Consultant", "", 7, 11, 3);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Digital Advisory Consultant", "", 5, 12, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Digital Advisory Consultant", "", 6, 12, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Digital Advisory Consultant", "", 7, 12, 3);

INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Specialist Consultant", "", 2, 13, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Specialist Consultant", "", 3, 13, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Specialist Consultant", "", 4, 13, 3);
INSERT INTO Job(Job_Title, Job_Spec, Band_ID, Job_Family_ID, Capability_ID) VALUES ("Specialist Consultant", "", 5, 13, 3);


-- Cyber Security
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Security Strategy and Planning", 4);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Security Engineering", 4);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Corporate Security", 4);

-- Data
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Data Strategy and Planning", 5);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Data Engineering", 5);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Analysis & Data Architecture ", 5);

-- Engineering
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Engineering ​​​​​​​Strategy and Planning", 6);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Engineering", 6);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Architecture", 6);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Testing and Quality Assurance", 6);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Product Specialist", 6);

-- Experienced Design
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Insights", 7);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Content Design", 7);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("UX / Visual Design", 7);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Service Design", 7);

-- Delivery Management
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Delivery Strategy & Planning", 8);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Delivery Management", 8);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Engineering Management", 8);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Service Management", 8);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Workday Engagement Management", 8);

-- Platorms
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Platform ​​​​​​​Strategy and Planning", 9);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Platform Engineering", 9);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Platform Architecture", 9);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Platform Specialists", 9);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Cloud Migration", 9);
INSERT INTO Job_Family(Job_Family_Title, Capability_ID) VALUES ("Systems Support", 9);
