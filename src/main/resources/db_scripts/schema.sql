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







