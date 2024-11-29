-- Create the database if it does not already exist
CREATE DATABASE IF NOT EXISTS sb_boilerplate;

-- Use the newly created or existing database
USE sb_boilerplate;

CREATE TABLE BATCH (
                       batch_id INT AUTO_INCREMENT PRIMARY KEY,
                       batch_name VARCHAR(255) NOT NULL,
                       batch_desc VARCHAR(1500) NOT NULL,
                       batch_status VARCHAR(255) NOT NULL
);

CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_name VARCHAR(255) NOT NULL,
                       rollno VARCHAR(10) NOT NULL UNIQUE,
                       mail_id VARCHAR(255) NOT NULL UNIQUE,
                       pass VARCHAR(255) NOT NULL,
                       user_status VARCHAR(25) NOT NULL,
                       created_date DATE NOT NULL,
                       user_role VARCHAR(255) NOT NULL
);


CREATE TABLE Goals (
                       gid INT AUTO_INCREMENT PRIMARY KEY,
                       goal_title VARCHAR(25) NOT NULL,
                       goal_desc VARCHAR(255) NOT NULL,
                       assigned_to INT NOT NULL,
                       created_by INT NOT NULL,
                       goal_start_date DATE NOT NULL,
                       goal_end_date DATE NOT NULL,
                       goal_created_date DATE NOT NULL,
                       goal_updated_date DATE NOT NULL,
                       goal_type VARCHAR(255) NOT NULL,
                       goal_status VARCHAR(255) NOT NULL,
                       goal_priority INT NOT NULL,
                       goal_ref VARCHAR(255) NOT NULL,
                       FOREIGN KEY (assigned_to) REFERENCES Users(id),
                       FOREIGN KEY (created_by) REFERENCES Users(id)
);

CREATE TABLE Tasks (
                       tid INT AUTO_INCREMENT PRIMARY KEY,
                       task_title VARCHAR(255) NOT NULL,
                       created_by INT NOT NULL,
                       assigned_to INT NOT NULL,
                       task_start_date DATE NOT NULL,
                       task_end_date DATE NOT NULL,
                       task_created_date DATE NOT NULL,
                       task_updated_date DATE NOT NULL,
                       task_status VARCHAR(25) NOT NULL,
                       task_desc VARCHAR(255) NOT NULL,
                       task_priority INT NOT NULL,
                       task_ref VARCHAR(255) NOT NULL,
                       gid INT,
                       FOREIGN KEY (gid) REFERENCES Goals(gid)
);

INSERT INTO BATCH (batch_name,batch_desc,batch_status) VALUES
                                                           ('msc2k22','msc 2022 to 2027','active'),
                                                           ('msc2k21','msc 2021 to 2028','active');

select * from BATCH;


select * from Users;
INSERT INTO Users (user_name, rollno, mail_id, pass,user_status,created_date,user_role) VALUES
    ('Arjun','22pt01', '22pt01@psgtech.ac.in', 'Arjunpass','active','2024-01-01','student');


INSERT INTO Goals (goal_title, goal_desc, assigned_to, created_by, goal_start_date, goal_end_date, goal_created_date, goal_updated_date, goal_type, goal_status, goal_priority, goal_ref)
VALUES ('Increase Sales', 'Increase quarterly sales by 10%', 1, 1, '2024-01-01', '2024-04-01', '2023-12-15', '2023-12-15', 'Revenue', 'In Progress', 3, 'SALES-Q1-2024');

INSERT INTO Users (user_name, rollno, mail_id, pass, user_status, created_date, user_role)
VALUES
    ('Ravi', '22pt02', '22pt02@psgtech.ac.in', 'Ravipass', 'active', '2024-01-01', 'student'),
    ('Sita', '22pt03', '22pt03@psgtech.ac.in', 'Sitapass', 'active', '2024-01-01', 'student'),
    ('Amit', '22pt04', '22pt04@psgtech.ac.in', 'Amitpass', 'active', '2024-01-01', 'student'),
    ('Lata', '22pt05', '22pt05@psgtech.ac.in', 'Latapass', 'active', '2024-01-01', 'student');


INSERT INTO Goals (goal_title, goal_desc, assigned_to, created_by, goal_start_date, goal_end_date, goal_created_date, goal_updated_date, goal_type, goal_status, goal_priority, goal_ref)
VALUES
    ('Complete Research Paper', 'Complete the research paper on AI and its applications', 1, 1, '2024-02-01', '2024-06-01', '2024-01-01', '2024-01-01', 'Academic', 'In Progress', 1, 'REF001'),
    ('Finish Online Course', 'Complete the online course on Data Science and Machine Learning', 2, 2, '2024-02-15', '2024-05-15', '2024-01-10', '2024-01-10', 'Learning', 'Not Started', 2, 'REF002'),
    ('Internship Application', 'Apply for internships in software engineering by March', 3, 3, '2024-01-15', '2024-03-15', '2024-01-01', '2024-01-01', 'Career Development', 'Not Started', 3, 'REF003'),
    ('Finish Group Project', 'Complete the final group project for the course on Cloud Computing', 4, 4, '2024-03-01', '2024-04-01', '2024-02-01', '2024-02-01', 'Academic', 'In Progress', 1, 'REF004'),
    ('Web Dev Portfolio', 'web development portfolio website', 5, 5, '2024-02-01', '2024-05-30', '2024-01-15', '2024-01-15', 'Personal Development', 'Not Started', 2, 'REF005');






