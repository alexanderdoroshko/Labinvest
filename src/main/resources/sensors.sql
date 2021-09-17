--------------------------------------------------------
--  DDL for schema LABINVENT
--------------------------------------------------------

DROP SCHEMA IF EXISTS LABINVENT;
CREATE SCHEMA IF NOT EXISTS LABINVENT;

--------------------------------------------------------
--  DDL for Table SENSORS
--------------------------------------------------------
DROP TABLE IF EXISTS LABINVENT.SENSORS;
CREATE TABLE IF NOT EXISTS LABINVENT.SENSORS (
    ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(30) NOT NULL,
    MODEL VARCHAR(15) NOT NULL,
    RANGE_FROM INT,
    RANGE_TO INT,
    TYPE VARCHAR(45) NOT NULL,
    UNIT VARCHAR (45),
    LOCATION VARCHAR (40),
    DESCRIPTION VARCHAR (200),
    PRIMARY KEY (ID),
    UNIQUE INDEX IDX_ID_UNIQUE (ID ASC));

--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------
DROP TABLE IF EXISTS LABINVENT.USERS;
CREATE TABLE IF NOT EXISTS LABINVENT.USERS(
    ID BIGINT NOT NULL AUTO_INCREMENT,
    PASSWORD VARCHAR(255),
    USERNAME VARCHAR(255),
    PRIMARY KEY(ID),
    UNIQUE INDEX IDX_ID_UNIQUE (ID ASC));

--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------
DROP TABLE IF EXISTS LABINVENT.ROLE;
CREATE TABLE IF NOT EXISTS LABINVENT.ROLE (
    ID BIGINT NOT NULL,
    NAME VARCHAR(255),
    PRIMARY KEY(ID),
    UNIQUE INDEX IDX_ID_UNIQUE (ID ASC));