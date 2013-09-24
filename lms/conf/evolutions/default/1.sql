# --- First database schema

# --- !Ups
CREATE TABLE IF NOT EXISTS EMPLOYEES
(
	employee_number SMALLINT NOT NULL AUTO_INCREMENT,  
	username VARCHAR(20) NOT NULL, 
	password VARCHAR(20), 
	first VARCHAR(20) NOT NULL, 
	last VARCHAR(20) NOT NULL, 
	user_role TINYINT NOT NULL, 
	PRIMARY KEY(employee_number)
);

CREATE TABLE IF NOT EXISTS CLIENT
(
	client_id INT NOT NULL AUTO_INCREMENT,	
	last VARCHAR(20) NOT NULL,
	first VARCHAR(20) NOT NULL, 
	mi VARCHAR(1), 
	company VARCHAR(30), 
	street_address VARCHAR(50), 
	mailing_address VARCHAR(50), 
	city VARCHAR(30) NOT NULL, 
	state CHAR(2), 
	zip VARCHAR(10) NOT NULL, 
	office_phone CHAR(10) NOT NULL, 
	cell_phone CHAR(10), 
	sex CHAR(1), 
	fax CHAR(10), 
	reporting_email VARCHAR(30), 
	invoice_email VARCHAR(30), 
	phone_report_OK BIT NOT NULL, 
	email_report_OK BIT NOT NULL, 
	email_invoice_OK BIT NOT NULL, 
	bill_to_client INT, 
	PRIMARY KEY(client_id), 
	UNIQUE(first, last, mailing_address, city, state, zip), 
	INDEX (bill_to_client), 
	FOREIGN KEY (bill_to_client) REFERENCES CLIENT(client_id) 
);

CREATE TABLE IF NOT EXISTS DEPOSIT 
(
	deposit_number INT NOT NULL AUTO_INCREMENT, 
	client_number INT NOT NULL, 
	amount DECIMAL(9,2) NOT NULL, 
	amount_remaining DECIMAL(9,2) NOT NULL, 
	date DATE NOT NULL, 
	check_number VARCHAR(8), 
	posted BIT NOT NULL DEFAULT 0, 
	refund_date DATE, 
	refund_amount DECIMAL(9,2), 
	PRIMARY KEY(deposit_number), 
	INDEX (client_number), 
	FOREIGN KEY (client_number) REFERENCES CLIENT(client_id) 
);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

DROP TABLE IF EXISTS EMPLOYEES;

DROP TABLE IF EXISTS CLIENT;

DROP TABLE IF EXISTS DEPOSIT;

SET REFERENTIAL_INTEGRITY TRUE;