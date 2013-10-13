# --- !Ups


INSERT INTO EMPLOYEES(first,last,username) VALUES('Jeff','Zehnder','labman');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'produce quarterly reports');
INSERT INTO USER_ROLES(employee_number,role_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'manage clients');
INSERT INTO CLIENT(last,first,city,zip, office_phone,phone_report_OK, email_report_OK, email_invoice_OK) 
VALUES('goodman','saul','Riverside','92005','9098675309',1,1,1);
INSERT INTO DEPOSIT(deposit_number, client_number, amount, amount_remaining, date) VALUES(1, (SELECT c.client_id FROM CLIENT AS c WHERE c.last = 'goodman') ,1000.0,1000.0,NOW());
INSERT INTO DEPOSIT_REFUND(deposit_number, refund_amount, refund_date) VALUES(1, 200, NOW());


INSERT INTO CASES(clt_no, case_number, subject_lastname, subject_firstname,  received_by, sample_type, total_cost, total_paid, unpaid_balance, email_invoice_OK, email_results_OK) 
VALUES((SELECT c.client_id FROM CLIENT AS c WHERE c.last = 'goodman'), '007','Heisenberg', 'Walter', (SELECT employee_number FROM EMPLOYEES WHERE username = 'labman'), 
'blood', 300, 0, 300, 1, 1); 

INSERT INTO CASE_DEPOSIT(case_FK, deposit_FK, amount) VALUES(1,1,300); 

INSERT INTO CASES(clt_no, case_number, subject_lastname, subject_firstname, received_date, received_by, sample_type, total_cost, total_paid, unpaid_balance, email_invoice_OK, email_results_OK) 
VALUES((SELECT c.client_id FROM CLIENT AS c WHERE c.last = 'goodman'), '008','Heisenberg', 'Walter', NOW(), (SELECT employee_number FROM EMPLOYEES WHERE username = 'labman'), 
'blood', 500, 0, 500, 1, 1); 

INSERT INTO CASE_DEPOSIT(case_FK, deposit_FK, amount) VALUES(2,1,300); 

INSERT INTO CASE_DEPOSIT(case_FK, deposit_FK, amount) VALUES(2,1,200); 

--alter table EMPLOYEES ENGINE=InnoDB;
--alter table USER_ROLES ENGINE=InnoDB;
--alter table COMMENTS ENGINE=InnoDB;
--alter table TEST ENGINE=InnoDB;
--alter table CLIENT ENGINE=InnoDB;
--alter table DEPOSIT ENGINE=InnoDB;
--alter table DEPOSIT_REFUND ENGINE=InnoDB;
--alter table CASES ENGINE=InnoDB;
--alter table CASE_DEPOSIT ENGINE=InnoDB;
--alter table CASE_TEST ENGINE=InnoDB;
--alter table CASE_TEST_RESULTS_COMMENTS ENGINE=InnoDB;

# --- !Downs

