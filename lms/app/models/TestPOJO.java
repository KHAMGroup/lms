package models;

import java.io.Serializable;
import play.data.validation.Constraints.*;


public class TestPOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Required
	private int testNumber;

	@MaxLength(10)
	private String controlResultLine;

	@MaxLength(300)
	private String controlText;

	@MaxLength(8)
	private String respicture;

	@MaxLength(30)
	@Required
	private String testName;

	//Acceptable values = L or C
	@MaxLength(1)
	@Required
	private String testType;

	@MaxLength(10)
	private String typeOfSample;

	@MaxLength(10)
	private String units;

	@MaxLength(800)
	private String defaultComment;

	public TestPOJO() {
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

	public String getDefaultComment() {
		return this.defaultComment;
	}

	public void setDefaultComment(String defaultComment) {
		this.defaultComment = defaultComment;
	}
	

}
