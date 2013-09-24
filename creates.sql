DROP TABLE IF EXISTS DEPOSIT_REFUND;

DROP TABLE IF EXISTS CASE_DEPOSIT; 

DROP TABLE IF EXISTS CASE_TEST; 

DROP TABLE IF EXISTS CASE_CONSULT; 

DROP TABLE IF EXISTS CASES; 

DROP TABLE IF EXISTS DEPOSIT; 

DROP TABLE IF EXISTS CLIENT; 

DROP TABLE IF EXISTS TEST; 

DROP TABLE IF EXISTS CONSULT; 

DROP TABLE IF EXISTS COMMENTS;

DROP TABLE IF EXISTS EMPLOYEES; 

DROP TABLE IF EXISTS USER_ROLES;


CREATE TABLE IF NOT EXISTS COMMENTS
(
	comment_code INT NOT NULL AUTO_INCREMENT, 
	comment VARCHAR(800) NOT NULL, 
	test_number SMALLINT, 
	PRIMARY KEY(comment_code) 
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS TEST
(
	test_number SMALLINT NOT NULL AUTO_INCREMENT, 
	test_name VARCHAR(30) NOT NULL, 
	price DECIMAL(9,2) NOT NULL, 
	units VARCHAR(10) NOT NULL, 
	default_comment INT, 
	type_of_sample VARCHAR(10) NOT NULL, 
	respicture VARCHAR(8), 
	control_text VARCHAR(300), 
	control_result_line VARCHAR(10), 
	PRIMARY KEY(test_number), 
	INDEX (default_comment), 
	FOREIGN KEY (default_comment) REFERENCES COMMENTS(comment_code) 
) ENGINE=InnoDB; 

CREATE INDEX suggestComments ON COMMENTS(test_number); 

ALTER TABLE COMMENTS ADD CONSTRAINT FOREIGN KEY (test_number) REFERENCES TEST(test_number); 

CREATE TABLE IF NOT EXISTS EMPLOYEES
(
	employee_number CHAR(3) NOT NULL AUTO_INCREMENT,  
	username VARCHAR(20) NOT NULL, 
	password VARCHAR(20), 
	first VARCHAR(20) NOT NULL, 
	last VARCHAR(20) NOT NULL, 
	user_role TINYINT NOT NULL, 
	PRIMARY KEY(employee_number)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS USER_ROLES 
(
	role_level TINYINT NOT NULL, 
	privilege_name VARCHAR(64) NOT NULL, 
	UNIQUE(role_level, privilege_name) 
) ENGINE=InnoDB; 

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
) ENGINE=InnoDB;

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
) ENGINE=InnoDB; 

CREATE TABLE IF NOT EXISTS CASES
(
	case_PK INT NOT NULL AUTO_INCREMENT, 
	case_number VARCHAR(7), 
	clt_no INT NOT NULL, 
	ccto_client INT, 
	subject_lastname VARCHAR(20) NOT NULL, 
	subject_firstname VARCHAR(20) NOT NULL, 
	timestamp_received BIT NOT NULL DEFAULT 0, 
	received_from INT, 
	received_by CHAR(3) NOT NULL, 
	date_collected DATE, 
	time_collected TIME, 
	other_id_number VARCHAR(10), 
	total_cost DECIMAL(9,2) NOT NULL, 
	total_paid DECIMAL(9,2) NOT NULL, 
	unpaid_balance DECIMAL(9,2) NOT NULL, 
	invoice_number INT, 
	sample_type VARCHAR(10) NOT NULL, 
	medical_history_notes VARCHAR(100), 
	note_code INT, 
	email_invoice_OK BIT NOT NULL,  
	email_results_OK BIT NOT NULL, 
	all_tasks_completed BIT NOT NULL DEFAULT 0, 
	date_tasks_completed DATE, 
	UNIQUE(case_number), 
	PRIMARY KEY(case_PK), 
	INDEX (clt_no), 
	INDEX (ccto_client), 
	INDEX (note_code), 
	FOREIGN KEY (clt_no) REFERENCES CLIENT(client_id), 
	FOREIGN KEY (note_code) REFERENCES COMMENTS(comment_code), 
	FOREIGN KEY (ccto_client) REFERENCES CLIENT(client_id) 
) ENGINE=InnoDB; 

CREATE TABLE IF NOT EXISTS CASE_DEPOSIT 
(
	case_FK INT NOT NULL, 
	deposit_FK INT NOT NULL, 
	amount DECIMAL(9,2) NOT NULL, 
	PRIMARY KEY(case_FK, deposit_FK), 
	INDEX (deposit_FK), 
	INDEX (case_FK), 
	FOREIGN KEY (deposit_FK) REFERENCES DEPOSIT(deposit_number), 
	FOREIGN KEY (case_FK) REFERENCES CASES(case_PK) 
) ENGINE=InnoDB; 

CREATE TABLE IF NOT EXISTS CASE_TEST 
(
	case_FK INT NOT NULL, 
	test_FK SMALLINT NOT NULL, 
	billed DATE DEFAULT NULL, 
	results VARCHAR(8), 
	amount_billed DECIMAL(9,2), 
	date_completed DATE, 
	employee_entered CHAR(3), 
	informational_comment INT, 
	actual_comment INT, 
	PRIMARY KEY(case_FK, test_FK), 
	INDEX (test_FK), 
	INDEX (case_FK), 
	INDEX (informational_comment), 
	INDEX (actual_comment), 
	FOREIGN KEY (test_FK) REFERENCES TEST(test_number), 
	FOREIGN KEY (case_FK) REFERENCES CASES(case_PK), 
	FOREIGN KEY (informational_comment) REFERENCES COMMENTS(comment_code), 
	FOREIGN KEY (actual_comment) REFERENCES COMMENTS(comment_code) 
) ENGINE=InnoDB; 

CREATE TABLE IF NOT EXISTS CASE_CONSULT 
(
	case_FK INT NOT NULL, 
	consult_FK SMALLINT NOT NULL, 
	billed DATE DEFAULT NULL, 
	amount_billed DECIMAL(9,2), 
	date_completed DATE, 
	employee_FK CHAR(3), 
	consulting_employee_FK CHAR(3), 
	PRIMARY KEY(case_FK, consult_FK), 
	INDEX (consult_FK), 
	INDEX (case_FK), 
	FOREIGN KEY (consult_FK) REFERENCES CONSULT(consult_number), 
	FOREIGN KEY (case_FK) REFERENCES CASES(case_PK) 
) ENGINE=InnoDB; 

