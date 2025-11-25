-- SQL schema for Project Management System (pms_db)
CREATE DATABASE IF NOT EXISTS pms_db;
USE pms_db;

CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL
);
