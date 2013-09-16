package models;

import java.io.Serializable;
import javax.persistence.*;

import play.data.validation.Constraints;

import java.util.List;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = -2390031803338014946L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="client_id")
	private int clientId;

	@Column(nullable=false)
	@Constraints.Required
	@Constraints.MaxLength(30)
	private String city;

	@Constraints.MaxLength(30)
	private String company;

	@Column(nullable=false)
	@Constraints.Required
	private boolean email_invoice_OK;

	@Column(nullable=false)
	@Constraints.Required
	private boolean email_report_OK;

	@Constraints.MaxLength(10)
	private String fax;

	@Column(nullable=false)
	@Constraints.Required
	@Constraints.MaxLength(20)
	private String first;

	@Column(name="invoice_email")
	@Constraints.MaxLength(30)
	private String invoiceEmail;

	
	@Column(nullable=false)
	@Constraints.Required
	@Constraints.MaxLength(20)
	private String last;

	@Column(name="mailing_address")
	@Constraints.MaxLength(50)
	private String mailingAddress;

	@Constraints.MaxLength(1)
	private String mi;

	@Column(name="office_phone", nullable=false)
	@Constraints.Required
	@Constraints.MaxLength(10)
	private String officePhone;
	
	@Column(name="cell_phone")
	@Constraints.MaxLength(10)
	private String cellPhone;
	
	@Column(nullable=false)
	@Constraints.Required
	private boolean phoneReportOK;

	@Column(name="reporting_email")
	@Constraints.MaxLength(30)
	private String reportingEmail;

	@Constraints.MaxLength(1)
	private String sex;

	@Constraints.MaxLength(2)
	private String state;

	@Column(name="street_address")
	@Constraints.MaxLength(50)
	private String streetAddress;

	@Constraints.MaxLength(10)
	private String zip;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="bill_to_client")
	private Client client;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="client")
	private List<Client> clients;

	//bi-directional many-to-one association to Deposit
	@OneToMany(mappedBy="client")
	private List<Deposit> deposits;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean getEmailInvoiceOK() {
		return this.email_invoice_OK;
	}

	public void setEmailInvoiceOK(boolean email_invoice_OK) {
		this.email_invoice_OK = email_invoice_OK;
	}

	public boolean getEmailReportOK() {
		return this.email_report_OK;
	}

	public void setEmailReportOK(boolean email_report_OK) {
		this.email_report_OK = email_report_OK;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getInvoiceEmail() {
		return this.invoiceEmail;
	}

	public void setInvoiceEmail(String invoiceEmail) {
		this.invoiceEmail = invoiceEmail;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getMailingAddress() {
		return this.mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getMi() {
		return this.mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public boolean getPhoneReportOK() {
		return this.phoneReportOK;
	}

	public void setPhoneReportOK(boolean phone_report_OK) {
		this.phoneReportOK = phone_report_OK;
	}

	public String getReportingEmail() {
		return this.reportingEmail;
	}

	public void setReportingEmail(String reportingEmail) {
		this.reportingEmail = reportingEmail;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Client getBillToClient() {
		return this.client;
	}

	public void setBillToClient(Client client) {
		this.client = client;
	}

	/*
	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	*/

	public List<Deposit> getDeposits() {
		return this.deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

}