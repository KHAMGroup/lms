package models;

import java.io.Serializable;
import javax.persistence.*;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;


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
	@Column(name="deposit_number")
	private int depositNumber;

	@Column(nullable=false)
	@Constraints.Required
	private double amount;

	@Column(name="amount_remaining", nullable=false)
	@Constraints.Required
	private double amountRemaining;

	@Column(name="check_number")
	@Constraints.MaxLength(8)
	private String checkNumber;

    @Formats.DateTime(pattern="yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
    @Column(nullable=false)
    @Constraints.Required
	private Date date;

    @Column(nullable=false)
    @Constraints.Required
	private boolean posted;

	@Column(name="refund_amount")
	private double refundAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="refund_date")
	private Date refundDate;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_number")
	private Client client;

	public Deposit() {
	}

	public int getDepositNumber() {
		return this.depositNumber;
	}

	public void setDepositNumber(int depositNumber) {
		this.depositNumber = depositNumber;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmountRemaining() {
		return this.amountRemaining;
	}

	public void setAmountRemaining(double amountRemaining) {
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

	public double getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundDate() {
		return this.refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}