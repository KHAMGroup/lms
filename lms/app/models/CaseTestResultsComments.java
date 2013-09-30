package models;

import java.io.Serializable;
import javax.persistence.*;
import models.CaseTest.CaseTestPK;


@Entity
@Table(name="CASE_TEST_RESULTS_COMMENTS")
public class CaseTestResultsComments implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CaseTestPK id;

	@Column(length = 8)
	private String results;
	
	@ManyToOne
	@JoinColumn(name="informational_comment")
	private Comment informationalComment;
	
	
	@ManyToOne
	@JoinColumn(name="actual_comment")
	private Comment actualComment;
	
	
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_entered")
	private Employee employeeEntered;

//	public CaseTestPK getId() {
//		return this.id;
//	}
//
//	public void setId(CaseTestPK id) {
//		this.id = id;
//	}
	
	public String getResults() {
		return this.results;
	}
	
	public void setResults(String results) {
		this.results = results;
	}
	
	public Employee getEmployeeEntered() {
		return this.employeeEntered;
	}

	public void setEmployeeEntered(Employee employeeEntered) {
		this.employeeEntered = employeeEntered;
	}

	public Comment getInformationalComment() {
		return this.informationalComment;
	}
	
	public void setInformationalComment(Comment infoComment) {
		this.informationalComment = infoComment;
	}
	
	public Comment getActualComment() {
		return this.actualComment;
	}
	
	public void setActualComment(Comment comment) {
		this.actualComment = comment;
	}
}
