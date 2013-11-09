package models;

import java.io.Serializable;
import javax.persistence.*;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.jpa.JPA;
import play.data.format.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * The persistent class for the CASES database table.
 * 
 */
@Entity
@Table(name="CASES")
public class CaseEntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int case_PK;

	@Column(name="all_tasks_completed", nullable=false)
	private boolean allTasksCompleted;

	@Column(name="case_number", length=7, unique=true)
	@MaxLength(7)
	@Required
	private String caseNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="date_collected")
	private Date dateCollected;

	@Temporal(TemporalType.DATE)
	@Column(name="date_tasks_completed")
	private Date dateTasksCompleted;

//	@Column(nullable=false)
//	private boolean email_invoice_OK;

	@Column(nullable=false)
	private boolean email_results_OK;

//	@Column(name="invoice_number")
//	private int invoiceNumber;

	@Column(name="medical_history_notes", length=100)
	private String medicalHistoryNotes;

	@Column(name="other_id_number", length=10)
	private String otherIdNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "received_date", 
			columnDefinition = "received_date DATE")
	@Formats.DateTime(pattern="yyyy-MM-dd")
	private Date receivedDate;

	@Column(name="received_from")
	private int receivedFrom;

	@Column(name="sample_type", nullable=false, length=10)
	private String sampleType;

	@Column(name="subject_firstname", nullable=false, length=20)
	private String subjectFirstname;

	@Column(name="subject_lastname", nullable=false, length=20)
	private String subjectLastname;

	@Column(name="time_collected")
	private Time timeCollected;

//	@Column(columnDefinition="total_cost DECIMAL(9,2) NOT NULL DEFAULT 0", 
//			name="total_cost", precision=9, scale=2)
//	private BigDecimal totalCost;
//
//	@Column(columnDefinition="total_paid DECIMAL(9,2) NOT NULL DEFAULT 0", 
//			name="total_paid", precision=9, scale=2)
//	private BigDecimal totalPaid;
//
//	@Column(columnDefinition="unpaid_balance DECIMAL(9,2) NOT NULL DEFAULT 0",
//			name="unpaid_balance", precision=9, scale=2)
//	private BigDecimal unpaidBalance;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clt_no", nullable=false)
	private Client client;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ccto_client")
	private Client cctoClient;

	//bi-directional many-to-one association to Comment
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="note_code")
	private Comment caseNote;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="received_by", nullable=false)
	private Employee receivedByEmployee;

	//bi-directional many-to-one association to CaseDeposit
//	@OneToMany(mappedBy="caseEntity")
//	private List<CaseDeposit> caseDeposits;

	//bi-directional many-to-one association to CaseTest
	//@OneToMany(mappedBy="caseEntity", fetch=FetchType.EAGER, cascade={CascadeType.MERGE})//mappedBy="caseEntity",
	@OneToMany(mappedBy="caseEntity", cascade=CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name="case_FK")
	private List<CaseTest> caseTests;

	public CaseEntityObject() {
//		setUnpaidBalance(new BigDecimal(0.0));
//		setTotalCost(new BigDecimal(0.0));
//		setTotalPaid(new BigDecimal(0.0));
	}

	public int getCasePK() {
		return this.case_PK;
	}

	public void setCasePK(int casePK) {
		this.case_PK = casePK;
	}

	public boolean getAllTasksCompleted() {
		return this.allTasksCompleted;
	}

	public void setAllTasksCompleted(boolean allTasksCompleted) {
		this.allTasksCompleted = allTasksCompleted;
	}

	public String getCaseNumber() {
		return this.caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Date getDateCollected() {
		return this.dateCollected;
	}

	public void setDateCollected(Date dateCollected) {
		this.dateCollected = dateCollected;
	}

	public Date getDateTasksCompleted() {
		return this.dateTasksCompleted;
	}

	public void setDateTasksCompleted(Date dateTasksCompleted) {
		this.dateTasksCompleted = dateTasksCompleted;
	}

//	public boolean getEmailInvoiceOk() {
//		return this.email_invoice_OK;
//	}
//
//	public void setEmailInvoiceOk(boolean email_invoice_OK) {
//		this.email_invoice_OK = email_invoice_OK;
//	}

	public boolean getEmailResultsOk() {
		return this.email_results_OK;
	}

	public void setEmailResultsOk(boolean email_results_OK) {
		this.email_results_OK = email_results_OK;
	}

//	public int getInvoiceNumber() {
//		return this.invoiceNumber;
//	}
//
//	public void setInvoiceNumber(int invoiceNumber) {
//		this.invoiceNumber = invoiceNumber;
//	}

	public String getMedicalHistoryNotes() {
		return this.medicalHistoryNotes;
	}

	public void setMedicalHistoryNotes(String medicalHistoryNotes) {
		this.medicalHistoryNotes = medicalHistoryNotes;
	}

	public String getOtherIdNumber() {
		return this.otherIdNumber;
	}

	public void setOtherIdNumber(String otherIdNumber) {
		this.otherIdNumber = otherIdNumber;
	}

	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public int getReceivedFrom() {
		return this.receivedFrom;
	}

	public void setReceivedFrom(int receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getSubjectFirstname() {
		return this.subjectFirstname;
	}

	public void setSubjectFirstname(String subjectFirstname) {
		this.subjectFirstname = subjectFirstname;
	}

	public String getSubjectLastname() {
		return this.subjectLastname;
	}

	public void setSubjectLastname(String subjectLastname) {
		this.subjectLastname = subjectLastname;
	}

	public Time getTimeCollected() {
		return this.timeCollected;
	}

	public void setTimeCollected(Time timeCollected) {
		this.timeCollected = timeCollected;
	}

//	public BigDecimal getTotalCost() {
//		return this.totalCost;
//	}
//
//	public void setTotalCost(BigDecimal totalCost) {
//		this.totalCost = totalCost;
//	}
//	
//	public void setTotalCost(double totalCost) {
//		setTotalCost(new BigDecimal(totalCost));
//	}
//
//	public BigDecimal getTotalPaid() {
//		return this.totalPaid;
//	}
//
//	public void setTotalPaid(BigDecimal totalPaid) {
//		this.totalPaid = totalPaid;
//	}
//	
//	public void setTotalPaid(double totalPaid){
//		setTotalPaid(new BigDecimal(totalPaid));
//	}
//
//	public BigDecimal getUnpaidBalance() {
//		return this.unpaidBalance;
//	}
//
//	public void setUnpaidBalance(BigDecimal unpaidBalance) {
//		this.unpaidBalance = unpaidBalance;
//	}
//	
//	public void setUnpaidBalance(double unpaidBalance) {
//		setUnpaidBalance(new BigDecimal(unpaidBalance));
//	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getCctoClient() {
		return this.cctoClient;
	}

	public void setCctoClient(Client cctoClient) {
		this.cctoClient = cctoClient;
	}

	public Comment getCaseNote() {
		return this.caseNote;
	}

	public void setCaseNote(Comment caseNote) {
		this.caseNote = caseNote;
	}

	public Employee getReceivedByEmployee() {
		return this.receivedByEmployee;
	}

	public void setReceivedByEmployee(Employee receivedByEmployee) {
		this.receivedByEmployee = receivedByEmployee;
	}

//	public List<CaseDeposit> getCaseDeposits() {
//		return this.caseDeposits;
//	}
//
//	public void setCaseDeposits(List<CaseDeposit> caseDeposits) {
//		this.caseDeposits = caseDeposits;
//	}

	public List<CaseTest> getCaseTests() {
		return this.caseTests;
	}

	public void setCaseTests(List<CaseTest> caseTests) {
		this.caseTests = caseTests;
	}
	
	public List<String> getCaseTestsSparse(){
		List<String> sparseTests = new LinkedList<String>();
		for(CaseTest caseTest : this.getCaseTests()){
			sparseTests.add(caseTest.getTest().getTestNumber()+"");
		}
		return sparseTests;
	}

    public void save(){
    	if(this.getCaseNote() != null){ //this one works
    		JPA.em().persist(this.getCaseNote());
    	}
    	
    	/*for(CaseTest t : this.getCaseTests()){ //this one doesn't
    		JPA.em().merge(t);
    	}*/
    	
        JPA.em().persist(this);
    }
    
    public void update(int casePK) {
    	setCasePK(casePK);
    	JPA.em().merge(this);
    }
    
    public static CaseEntityObject findByCasePK(int casePK){
    	return JPA.em().find(CaseEntityObject.class, casePK);
    }
    
    public static CaseEntityObject findByCaseNumber(String caseNumber){
    	List<CaseEntityObject> found = JPA.em().createQuery("from " +
    			"CaseEntityObject where caseNumber = ? ")
    			.setParameter(1, caseNumber)
    			.getResultList();
    	if(found.size()>0){
    		return found.get(0);
    	}else{
    		return new CaseEntityObject();
    	}
    }
    
	public static List<CaseEntityObject> findBySubjectFirstAndLastName(
			String first, String last) {
    	return JPA.em().createQuery("from CaseEntityObject where lower(subjectFirstname) LIKE ? " +
    			"AND lower(subjectLastname) LIKE ? ")
    		.setParameter(1, first.toLowerCase()+"%")
    		.setParameter(2, last.toLowerCase()+"%")
    		.getResultList(); 
	}

	public static List<CaseEntityObject> findBySubjectFirstOrLastName(
			String firstOrLast) {
    	String asLowerCase = firstOrLast.toLowerCase() + "%";
    	return JPA.em().createQuery("from CaseEntityObject where lower(subjectFirstname) LIKE ? " +
    			"OR lower(subjectLastname) LIKE ? ")
    		.setParameter(1, asLowerCase)
    		.setParameter(2, asLowerCase)
    		.getResultList();
	}

}
