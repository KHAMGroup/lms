package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TEST database table.
 * 
 */
@Entity
@Table(name="TEST")
public class TestEntityObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="test_number", unique=true, nullable=false)
	private int testNumber;

	@Column(name="control_result_line", length=10)
	private String controlResultLine;

	@Column(name="control_text", length=300)
	private String controlText;

	@Column(nullable=false, precision=9, scale=2)
	private BigDecimal price;

	@Column(name="price_type", nullable=false, length=1)
	private String priceType;

	@Column(length=8)
	private String respicture;

	@Column(name="test_name", nullable=false, length=30)
	private String testName;

	@Column(name="test_type", nullable=false, length=1)
	private String testType;

	@Column(name="type_of_sample", length=10)
	private String typeOfSample;

	@Column(length=10)
	private String units;

	//bi-directional many-to-one association to CaseTest
	@OneToMany(mappedBy="test")
	private List<CaseTest> caseTests;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="associatedTest")
	private List<Comment> associatedComments;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="default_comment")
	private Comment defaultComment;

	public TestEntityObject() {
	}

	public int getTestNumber() {
		return this.testNumber;
	}

	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}

	public String getControlResultLine() {
		return this.controlResultLine;
	}

	public void setControlResultLine(String controlResultLine) {
		this.controlResultLine = controlResultLine;
	}

	public String getControlText() {
		return this.controlText;
	}

	public void setControlText(String controlText) {
		this.controlText = controlText;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceType() {
		return this.priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getRespicture() {
		return this.respicture;
	}

	public void setRespicture(String respicture) {
		this.respicture = respicture;
	}

	public String getTestName() {
		return this.testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTypeOfSample() {
		return this.typeOfSample;
	}

	public void setTypeOfSample(String typeOfSample) {
		this.typeOfSample = typeOfSample;
	}

	public String getUnits() {
		return this.units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public List<CaseTest> getCaseTests() {
		return this.caseTests;
	}

	public void setCaseTests(List<CaseTest> caseTests) {
		this.caseTests = caseTests;
	}

	public List<Comment> getAssociatedComments() {
		return this.associatedComments;
	}

	public void setAssociatedComments(List<Comment> associatedComments) {
		this.associatedComments = associatedComments;
	}

	public Comment getDefaultComment() {
		return this.defaultComment;
	}

	public void setDefaultComment(Comment defaultComment) {
		this.defaultComment = defaultComment;
	}

}
