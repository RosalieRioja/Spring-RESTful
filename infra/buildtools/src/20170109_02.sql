DROP DATABASE HibernateAnnotations;

DROP TABLE tblAddress;
DROP TABLE tblPerson;
DROP TABLE tblContact;
DROP TABLE tblRole;
DROP TABLE tblPerson_Role;

INSERT INTO tblAddress (streetNumber, barangay, city, zipcode)
	VALUES (1, 'barangay1', 'city1', 1);
INSERT INTO tblPerson (firstName, lastName, middleName, suffix, title, birthday, gwa, dateHired, currentlyEmployed, gender, addressId)
	VALUES ('firstName1', 'lastName1', 'middleName1', 'suffix1', 'title1', '01/01/01', 1.1, '01/01/11', true, 'FEMALE', 1);
INSERT INTO tblContact (type, value, personId)
	VALUES ('MOBILE', 'mobile1', 1);

INSERT INTO tblRole (value) VALUES ('Director');
INSERT INTO tblRole (value) VALUES ('Manager');
INSERT INTO tblRole (value) VALUES ('Supervisor');
INSERT INTO tblRole (value) VALUES ('Developer');
INSERT INTO tblRole (value) VALUES ('Designer');
INSERT INTO tblRole (value) VALUES ('Support');