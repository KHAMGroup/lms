# --- Archive database schema

# --- !Ups

CREATE TABLE IF NOT EXISTS CLIENT_ARCH
(
	client_id INT NOT NULL AUTO_INCREMENT,	
	archive_date DATE NOT NULL, 
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
	FOREIGN KEY (bill_to_client) REFERENCES CLIENT_ARCH(client_id) 
);

CREATE TABLE IF NOT EXISTS DEPOSIT_ARCH 
(
	deposit_number INT NOT NULL AUTO_INCREMENT,
	archive_date DATE NOT NULL,  
	client_number INT NOT NULL, 
	amount DECIMAL(9,2) NOT NULL, 
	amount_remaining DECIMAL(9,2) NOT NULL, 
	amount_refunded DECIMAL(9,2) NOT NULL DEFAULT 0, 
	date DATE NOT NULL, 
	check_number VARCHAR(8), 
	posted BIT NOT NULL DEFAULT 0, 
	PRIMARY KEY(deposit_number), 
	FOREIGN KEY (client_number) REFERENCES CLIENT_ARCH(client_id) 
);

CREATE TABLE IF NOT EXISTS DEPOSIT_REFUND_ARCH 
(
	refund_PK INT NOT NULL AUTO_INCREMENT, 
	archive_date DATE NOT NULL, 
	deposit_number INT NOT NULL, 
	refund_amount DECIMAL(9,2) NOT NULL, 
	refund_date DATE NOT NULL, 
	PRIMARY KEY(refund_PK), 
	FOREIGN KEY (deposit_number) REFERENCES DEPOSIT_ARCH(deposit_number) 
);


CREATE TABLE IF NOT EXISTS CASES_ARCH
(
	case_PK INT NOT NULL AUTO_INCREMENT, 
	archive_date DATE NOT NULL, 
	case_number VARCHAR(7), 
	clt_no INT NOT NULL, 
	ccto_client INT, 
	subject_lastname VARCHAR(20) NOT NULL, 
	subject_firstname VARCHAR(20) NOT NULL, 
	received_date DATE NOT NULL, 
	received_from INT, 
	received_by TINYINT NOT NULL, 
	date_collected DATE, 
	time_collected TIME, 
	other_id_number VARCHAR(10), 
	total_cost DECIMAL(9,2) NOT NULL DEFAULT 0, 
	total_paid DECIMAL(9,2) NOT NULL DEFAULT 0, 
	unpaid_balance DECIMAL(9,2) NOT NULL DEFAULT 0, 
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
	FOREIGN KEY (clt_no) REFERENCES CLIENT_ARCH(client_id), 
	FOREIGN KEY (note_code) REFERENCES COMMENTS(comment_code), 
	FOREIGN KEY (ccto_client) REFERENCES CLIENT_ARCH(client_id), 
	FOREIGN KEY (received_by) REFERENCES EMPLOYEES(employee_number) 
);

CREATE TABLE IF NOT EXISTS CASE_DEPOSIT_ARCH 
(
	case_dep_PK INT NOT NULL AUTO_INCREMENT, 	
	archive_date DATE NOT NULL, 
	case_FK INT NOT NULL, 
	deposit_FK INT NOT NULL, 
	amount DECIMAL(9,2) NOT NULL, 
	PRIMARY KEY(case_dep_PK), 
	FOREIGN KEY (deposit_FK) REFERENCES DEPOSIT_ARCH(deposit_number), 
	FOREIGN KEY (case_FK) REFERENCES CASES_ARCH(case_PK) 
);

CREATE TABLE IF NOT EXISTS CASE_TEST_ARCH 
(
	case_test_PK BIGINT NOT NULL AUTO_INCREMENT, 	
	archive_date DATE NOT NULL, 
	case_FK INT NOT NULL, 
	test_FK SMALLINT NOT NULL, 
	billed BIT NOT NULL DEFAULT 0, 
	billed_date DATE DEFAULT NULL, 
	amount_billed DECIMAL(9,2), 
	reported BIT NOT NULL DEFAULT 0, 
	reported_date DATE DEFAULT NULL, 
	date_completed DATE, 
	employee_entered TINYINT, 
	employee_performed TINYINT, 
	PRIMARY KEY(case_test_PK), 
	FOREIGN KEY (test_FK) REFERENCES TEST(test_number), 
	FOREIGN KEY (case_FK) REFERENCES CASES_ARCH(case_PK), 
	FOREIGN KEY (employee_entered) REFERENCES EMPLOYEES(employee_number), 
	FOREIGN KEY (employee_performed) REFERENCES EMPLOYEES(employee_number) 
);

CREATE TABLE IF NOT EXISTS CASE_TEST_RESULTS_COMMENTS_ARCH 
(
	case_test_FK BIGINT NOT NULL, 
	archive_date DATE NOT NULL, 
	results VARCHAR(8), 
	employee_entered TINYINT, 
	informational_comment INT, 
	actual_comment INT, 
	UNIQUE(case_test_FK), 
	FOREIGN KEY (case_test_FK) REFERENCES CASE_TEST_ARCH(case_test_PK), 
	FOREIGN KEY (employee_entered) REFERENCES EMPLOYEES(employee_number), 
	FOREIGN KEY (informational_comment) REFERENCES COMMENTS(comment_code), 
	FOREIGN KEY (actual_comment) REFERENCES COMMENTS(comment_code) 
);

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

DROP TABLE IF EXISTS CLIENT_ARCH; 

DROP TABLE IF EXISTS DEPOSIT_ARCH; 

DROP TABLE IF EXISTS DEPOSIT_REFUND_ARCH;

DROP TABLE IF EXISTS CASES_ARCH;

DROP TABLE IF EXISTS CASE_DEPOSIT_ARCH;

DROP TABLE IF EXISTS CASE_TEST_ARCH; 

DROP TABLE IF EXISTS CASE_TEST_RESULTS_COMMENTS_ARCH; 

SET REFERENTIAL_INTEGRITY TRUE;
