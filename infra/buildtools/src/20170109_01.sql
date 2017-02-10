CREATE DATABASE HibernateAnnotation;

CREATE TABLE tblAddress (
   id SERIAL PRIMARY KEY,

   streetNumber INT NULL,
   barangay    VARCHAR(20) NULL,
   city        VARCHAR(20) NULL,
   zipcode     INT NULL
);

CREATE TABLE tblPerson (
   id SERIAL PRIMARY KEY NOT NULL,

   firstName   VARCHAR(20) NOT NULL,
   lastName    VARCHAR(20) NOT NULL,
   middleName  VARCHAR(20) NULL,
   suffix      VARCHAR(20) NULL,
   title       VARCHAR(20) NULL,
   
   birthday    DATE NULL,
   gwa         DECIMAL NULL,  --converted to numeric
   dateHired   DATE NULL,
   currentlyEmployed BOOLEAN NULL,
   gender      VARCHAR(20) NULL,

   addressId   INT NOT NULL REFERENCES tblAddress(id)
);

CREATE TABLE tblContact (
   id SERIAL PRIMARY KEY,

   type  VARCHAR(20) NOT NULL,
   value VARCHAR(30) NOT NULL,

   personId INT NULL REFERENCES tblPerson(id) ON DELETE CASCADE
);

CREATE TABLE tblRole (
   id SERIAL PRIMARY KEY,

   value VARCHAR(50) NOT NULL
);

CREATE TABLE tblPerson_Role (
   personId INT NOT NULL REFERENCES tblPerson(id) ON DELETE CASCADE,
   roleId   INT NOT NULL REFERENCES tblRole(id) ON DELETE CASCADE,
   PRIMARY KEY (personId, roleId)
);
