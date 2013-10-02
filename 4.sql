# --- !Ups
delimiter $$
CREATE TRIGGER deposits_refunded AFTER INSERT ON DEPOSIT_REFUND 
FOR EACH ROW 
BEGIN
	UPDATE DEPOSIT 
	SET amount_refunded = amount_refunded + NEW.refund_amount 
	WHERE deposit_number = NEW.deposit_number; 
	UPDATE DEPOSIT 
	SET amount_remaining = amount_remaining - NEW.refund_amount  
	WHERE deposit_number = NEW.deposit_number; 
END; $$
delimiter ;

delimiter $$
CREATE TRIGGER deposits_applied AFTER INSERT ON CASE_DEPOSIT
FOR EACH ROW 
BEGIN
	UPDATE DEPOSIT 
	SET amount_remaining = amount_remaining - NEW.amount  
	WHERE deposit_number = NEW.deposit_FK; 
	UPDATE CASES 
	SET total_paid = total_paid + NEW.amount 
	WHERE case_PK = NEW.case_FK; 
	UPDATE CASES 
	SET unpaid_balance = unpaid_balance - NEW.amount 
	WHERE case_PK = NEW.case_FK;
END; $$
delimiter ;

# --- !Downs

