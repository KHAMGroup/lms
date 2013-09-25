package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DEPOSIT_REFUND database table.
 * 
 */
@Entity
@Table(name="DEPOSIT_REFUND")
public class DepositRefund implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="refund_amount", nullable=false, precision=9, scale=2)
	private BigDecimal refundAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="refund_date", nullable=false)
	private Date refundDate;

	//bi-directional many-to-one association to Deposit
	@ManyToOne
	@JoinColumn(name="deposit_number", nullable=false)
	private Deposit deposit;

	public DepositRefund() {
	}

	public BigDecimal getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Date getRefundDate() {
		return this.refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public Deposit getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Deposit deposit) {
		this.deposit = deposit;
	}

}