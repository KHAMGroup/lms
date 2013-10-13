package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import play.libs.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import play.libs.F.*;
import play.db.jpa.*;


public class CaseEntityObjectTest extends WithApplication {

	@Test
	public void createCaseWithExistingClient() {
		running(fakeApplication(), new Runnable() {
		   public void run() {
		       JPA.withTransaction(new play.libs.F.Callback0() {
		           public void invoke() {
		        	   	Employee jeff = Employee.findByUserName("labman");
						Client saul = Client.findByFirstAndLastName("Saul", "Goodman").get(0);
						CaseEntityObject newCase = new CaseEntityObject();
						newCase.setClient(saul);
						newCase.setCaseNumber("001100");
						newCase.setSubjectFirstname("Ham");
						newCase.setSubjectLastname("Burgler");
						newCase.setReceivedDate(new Date(Calendar.getInstance().getTimeInMillis()));
						newCase.setReceivedByEmployee(jeff);
						newCase.setSampleType("blood");
						newCase.setEmailInvoiceOk(saul.getEmailInvoiceOk());
						newCase.setEmailResultsOk(saul.getEmailReportOk());
						newCase.save();
						
						CaseEntityObject foundCheck = CaseEntityObject.findByCaseNumber("001100");
						assertEquals("blood",foundCheck.getSampleType());

		           }
		       });
		   }
		});
	}
	
	@Test
	public void findExistingCase() {
		running(fakeApplication(), new Runnable() {
			   public void run() {
			       JPA.withTransaction(new play.libs.F.Callback0() {
			           public void invoke() {

			           }
			       });
			   }
			});
	}

}
