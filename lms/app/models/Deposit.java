package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import play.data.format.*;

/**
 * The persistent class for the DEPOSIT database table.
 * 
 */
@Entity
@Table(name="DEPOSIT")
public class Deposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="deposit_number", unique=true, nullable=false)
	private int depositNumber;

	@Column(nullable=false, precision=9, scale=2)
	private BigDecimal amount;

	@Column(name="amount_refunded", nullable=false, precision=9, scale=2)
	private BigDecimal amountRefunded;

	@Column(name="amount_remaining", nullable=false, precision=9, scale=2)
	private BigDecimal amountRemaining;

	@Column(name="check_number", length=8)
	private String checkNumber;

	@Temporal(TemporalType.DATE)
	@Formats.DateTime(pattern="yyyy-MM-dd")
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false)
	private boolean posted;

	//bi-directional many-to-one association to CaseDeposit
	@OneToMany(mappedBy="deposit")
	private List<CaseDeposit> caseDeposits;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_number", nullable=false)
	private Client client;

	//bi-directional many-to-one association to DepositRefund
	@OneToMany(mappedBy="deposit")
	private List<DepositRefund> refunds;

	public Deposit() {
	}

	public int getDepositNumber() {
		return this.depositNumber;
	}

	public void setDepositNumber(int depositNumber) {
		this.depositNumber = depositNumber;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountRefunded() {
		return this.amountRefunded;
	}

	public void setAmountRefunded(BigDecimal amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public BigDecimal getAmountRemaining() {
		return this.amountRemaining;
	}

	public void setAmountRemaining(BigDecimal amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getPosted() {
		return this.posted;
	}

	public void setPosted(boolean posted) {
		this.posted = posted;
	}

	public List<CaseDeposit> getCaseDeposits() {
		return this.caseDeposits;
	}

	public void setCaseDeposits(List<CaseDeposit> caseDeposits) {
		this.caseDeposits = caseDeposits;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<DepositRefund> getRefunds() {
		return this.refunds;
	}

	public void setRefunds(List<DepositRefund> refunds) {
		this.refunds = refunds;
	}

   	public static Deposit findByDepositNumber(int depositNumber){
    		return JPA.em().find(Deposit.class, depositNumber);
   	}

	public void save(){
		JPA.em().persist(this);
	}

}
