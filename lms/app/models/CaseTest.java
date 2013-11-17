package models;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import play.db.jpa.JPA;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * The persistent class for the CASE_TEST database table.
 * 
 */
@Entity
@Table(name="CASE_TEST")
public class CaseTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="case_test_PK", unique=true, nullable=false)
	private long caseTestPK;

//	@Column(name="amount_billed", precision=9, scale=2)
//	private BigDecimal amountBilled;
//
//	@Column(nullable=false)
//	private boolean billed;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name="billed_date")
//	private Date billedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="date_completed")
	private Date dateCompleted;

	@Column(nullable=false)
	private boolean reported;
	
	@Column(nullable=false, name="results_entered")
	private boolean resultsEntered;

	@Temporal(TemporalType.DATE)
	@Column(name="reported_date")
	private Date reportedDate;

	//bi-directional many-to-one association to CaseEntityObject
	@ManyToOne
	@JoinColumn(name="case_FK")
	private CaseEntityObject caseEntity;

	//bi-directional one-to-one association to CaseTestResultsComment
	//@OneToOne
	//@JoinColumns({
	//	@JoinColumn(name="case_FK", referencedColumnName="case_FK", nullable=false, insertable=false, updatable=false),
	//	@JoinColumn(name="test_FK", referencedColumnName="test_FK", nullable=false, insertable=false, updatable=false)
	//	})
	//private CaseTestResultsComments resultsAndComments;

//	@OneToOne(mappedBy = "caseTest")
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	//@JoinColumn(referencedColumnName="case_test_FK", nullable=true, insertable=false, updatable=false)
	private CaseTestResultsComments resultsAndComments;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_entered")
	private Employee employeeEntered;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_performed")
	private Employee employeePerformed;

	//bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name="test_FK")
	private TestEntityObject test;

	public CaseTest() {
	}

//	public CaseTestPK getId() {
//		return this.id;
//	}
//
//	public void setId(CaseTestPK id) {
//		this.id = id;
//	}
//
//	public BigDecimal getAmountBilled() {
//		return this.amountBilled;
//	}
//
//	public void setAmountBilled(BigDecimal amountBilled) {
//		this.amountBilled = amountBilled;
//	}
//
//	public boolean getBilled() {
//		return this.billed;
//	}
//
//	public void setBilled(boolean billed) {
//		this.billed = billed;
//	}
//
//	public Date getBilledDate() {
//		return this.billedDate;
//	}
//
//	public void setBilledDate(Date billedDate) {
//		this.billedDate = billedDate;
//	}

	public Date getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public boolean isReported() {
		return this.reported;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isResultsEntered() {
		return resultsEntered;
	}

	public void setResultsEntered(boolean resultsEntered) {
		this.resultsEntered = resultsEntered;
	}
	
	public Date getReportedDate() {
		return this.reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public CaseEntityObject getCaseEntity() {
		return this.caseEntity;
	}

	public void setCaseEntity(CaseEntityObject caseEntity) {
		this.caseEntity = caseEntity;
	}

	public CaseTestResultsComments getResultsAndComments() {
		return this.resultsAndComments;
	}

	public void setResultsAndComments(CaseTestResultsComments resultsAndComments) {
		this.resultsAndComments = resultsAndComments;
	}

	public Employee getEmployeeEntered() {
		return this.employeeEntered;
	}

	public void setEmployeeEntered(Employee employeeEntered) {
		this.employeeEntered = employeeEntered;
	}

	public Employee getEmployeePerformed() {
		return this.employeePerformed;
	}

	public void setEmployeePerformed(Employee employeePerformed) {
		this.employeePerformed = employeePerformed;
	}

	public TestEntityObject getTest() {
		return this.test;
	}

	public void setTest(TestEntityObject test) {
		this.test = test;
	}
	
	public static List<CaseTest> caseTestsNeedingResults(){
//		List<CaseTest> needsResults = new LinkedList<CaseTest>();
		String query = "from CaseTest ct " +
				"where ct.resultsEntered = 0 ";
//		needsResults.addAll(JPA.em().createQuery(query).getResultList());
		return JPA.em().createQuery(query).getResultList();
	}
	
/*	@Embeddable
	public class CaseTestPK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(unique=true, nullable=false)
		private int case_FK;

		@Column(unique=true, nullable=false)
		private int test_FK;

//		public CaseTestPK() {
//		}
//		public int getCase_FK() {
//			return this.case_FK;
//		}
//		public void setCase_FK(int case_FK) {
//			this.case_FK = case_FK;
//		}
//		public int getTest_FK() {
//			return this.test_FK;
//		}
//		public void setTest_FK(int test_FK) {
//			this.test_FK = test_FK;
//		}

	}*/
}
