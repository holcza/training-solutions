CREATE TABLE citizens (
citizen_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
citizen_name VARCHAR(200) NOT NULL,
zip VARCHAR(4) NOT NULL,
age BIGINT NOT NULL,
email VARCHAR(200),
taj VARCHAR(10) UNIQUE,
number_of_vaccination BIGINT,
last_vaccination DATE);

CREATE TABLE Vaccinations (
vaccination_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
citizen_id BIGINT NOT NULL,
vaccination_date DATE NOT NULL,
status_of_vaccination VARCHAR(10),
note VARCHAR(200),
vaccination_type VARCHAR(20));


ALTER TABLE vaccinations ADD CONSTRAINT FK_CITIZEN_ID FOREIGN KEY (citizen_id) REFERENCES citizens (citizen_id);

insert into citizens(citizen_name,zip,age,email,taj,number_of_vaccination) VALUES ('Jack Doe','2000',40,'f@f','123456788',0);
insert into citizens(citizen_name,zip,age,email,taj,number_of_vaccination) VALUES ('Jane Doe','2000',41,'f@g','122456785',0);

CREATE TABLE Cities (
city_id BIGINT NOT NULL primary key AUTO_INCREMENT,
zip VARCHAR(4) NOT NULL,
city VARCHAR(40) NOT NULL,
citypart VARCHAR(40));

LOAD DATA INFILE 'zips.csv' INTO TABLE cities
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES(zip,city,citypart);