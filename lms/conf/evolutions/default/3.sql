# --- First database schema

# --- !Ups

INSERT INTO EMPLOYEES(first,last,username) VALUES('Jeff','Zehnder','labman');
INSERT INTO USER_ROLES(employee_number,privilege_name) VALUES((SELECT employee_number FROM EMPLOYEES WHERE username = 'labman') ,'produce quarterly reports');
# --- !Downs

