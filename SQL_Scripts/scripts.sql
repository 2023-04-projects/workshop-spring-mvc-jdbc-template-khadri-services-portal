create schema 2024_batch; 
use 2024_batch; 

CREATE TABLE students (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  course varchar(100) NOT NULL,
  marks int NOT NULL,
  PRIMARY KEY (id)
) ;

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phoneNumber long NOT NULL
);