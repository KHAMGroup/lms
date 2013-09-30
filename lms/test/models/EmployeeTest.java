package models;

import models.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;
import play.libs.*;
import java.util.List;
import play.libs.F.*;
import play.db.jpa.*;


public class EmployeeTest extends WithApplication {
	
	private void setUp() {
		start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
	}

	@Test
	public void createAndRetrieveUser() {
		running(fakeApplication(), new Runnable() {
		   public void run() {
		       JPA.withTransaction(new play.libs.F.Callback0() {
		           public void invoke() {
				Employee bob = new Employee();
				bob.setFirst("bob");
				bob.setLast("boba");
				bob.setUserName("bb");
				bob.save();

				Employee foundBob = Employee.findByUserName("bb");

				assertEquals("bob",foundBob.getFirst());

				List<Employee> foundBobAgain = Employee.findByFirstAndLastName("bob","boba");
				assertEquals("boba",foundBobAgain.get(0).getLast());
		           }
		       });
		   }
		});
	}
}