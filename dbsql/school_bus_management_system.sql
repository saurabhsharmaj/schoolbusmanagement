drop database school_bus_management_system;
create database school_bus_management_system;
USE school_bus_management_system;


CREATE TABLE User (
    user_id int    NOT NULL AUTO_INCREMENT,
    fname varchar(100)    NOT NULL ,
    lname varchar(100)    NOT NULL ,
    year int    NOT NULL ,
    department varchar(50)    NOT NULL ,
    semester int    NOT NULL ,
    role int    NOT NULL default 1 ,
    CONSTRAINT Student_pk PRIMARY KEY (user_id)
);


CREATE TABLE UserProfile (
id int NOT NULL AUTO_INCREMENT,
title varchar(1024),
username varchar(255),
password varchar(255),
CONSTRAINT UserProfile_pk PRIMARY KEY (id)
);

CREATE TABLE ROLE(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
role_name varchar(255)
);

-- Table billing_data
CREATE TABLE transport_assignment(
    transport_assignment_id int    NOT NULL AUTO_INCREMENT ,
    user_id int    NOT NULL ,
    bus_detail_id int NOT NULL,
    fees int    NOT NULL ,
    paid int default 0,
    due int  default 0,
    CONSTRAINT billing_data_pk PRIMARY KEY (transport_assignment_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

-- Table route
CREATE TABLE route (
    route_id int    NOT NULL AUTO_INCREMENT,
    route_name varchar(255)    NOT NULL ,
    CONSTRAINT route_pk PRIMARY KEY (route_id)
    
);

-- Table bus_detail
CREATE TABLE bus_detail (
    bus_detail_id int    NOT NULL AUTO_INCREMENT,
    route_id int Not NULL,
    bus_stop_name varchar(255) NOT NULL ,
    bus_stop_time varchar(10)    NOT NULL ,
    distance int    NOT NULL ,
    CONSTRAINT bus_detail_pk PRIMARY KEY (bus_detail_id),
    FOREIGN KEY (route_id) REFERENCES route(route_id) ON DELETE CASCADE
);
