# To create database 
CREATE DATABASE hibernate_mapping_ont_to_one;

# To view databases
show databases;

# To use database
USE hibernate_mapping_ont_to_one;

# To delete tables
DROP TABLE student;
DROP TABLE student_details;

# To create table student_details
CREATE TABLE student_details(
    id INT NOT NULL AUTO_INCREMENT,
    college_name VARCHAR(100) DEFAULT NULL,
    stream VARCHAR(100) DEFAULT 'Commerce',
    PRIMARY KEY(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

# To create table student
CREATE TABLE student (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) DEFAULT NULL,
    age INT NOT NULL DEFAULT 0,
    email VARCHAR(50) DEFAULT NULL,
    student_details_id INT UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (student_details_id)
    REFERENCES student_details(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

# To view table list available in current database
SHOW TABLES;

# To view student table structure
DESC student;

# To view student_details table structure
DESC student_details;

# To view all records avaialble inside student table
SELECT * FROM student;

# To view all records avaialble inside student_details table
SELECT * FROM student_details;

# To delete some records filtered by id from tables
DELETE FROM student WHERE id IN (4);

DELETE FROM student_details WHERE id IN (5);