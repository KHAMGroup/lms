# --- !Ups


INSERT INTO EMPLOYEES(first,last,username) VALUES('Jeff','Zehnder','labman');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'admin');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'manage clients');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'manage cases');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'manage results');
INSERT INTO CLIENT(last,first,city,zip, office_phone,phone_report_OK, email_report_OK) 
VALUES('goodman','saul','Riverside','92005','9098675309',1,1);


INSERT INTO CASES(clt_no, case_number, subject_lastname, subject_firstname,  received_by, sample_type, email_results_OK) 
VALUES((SELECT c.client_id FROM CLIENT AS c WHERE c.last = 'goodman'), '007','Heisenberg', 'Walter', (SELECT employee_number FROM EMPLOYEES WHERE username = 'labman'), 
'blood',  1); 


INSERT INTO CASES(clt_no, case_number, subject_lastname, subject_firstname, received_date, received_by, sample_type, email_results_OK) 
VALUES((SELECT c.client_id FROM CLIENT AS c WHERE c.last = 'goodman'), '008','Heisenberg', 'Walter', NOW(), (SELECT employee_number FROM EMPLOYEES WHERE username = 'labman'), 
'blood', 1); 

INSERT INTO TEST(test_number, test_name, test_type)
VALUES(100, 'mary-j blood', 't');

INSERT INTO TEST(test_number, test_name, test_type)
VALUES(101, 'mary-j urine', 't');

--alter table EMPLOYEES ENGINE=InnoDB;
--alter table USER_ROLES ENGINE=InnoDB;
--alter table COMMENTS ENGINE=InnoDB;
--alter table TEST ENGINE=InnoDB;
--alter table CLIENT ENGINE=InnoDB;
--alter table CASES ENGINE=InnoDB;
--alter table CASE_TEST ENGINE=InnoDB;
--alter table CASE_TEST_RESULTS_COMMENTS ENGINE=InnoDB;

# --- !Downs

