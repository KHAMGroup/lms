package models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CASE_DEPOSIT database table.
 * 
 */
@Entity
@Table(name="CASE_DEPOSIT")
public class CaseDeposit implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CaseDepositPK id;

	@Column(nullable=false, precision=9, scale=2)
	private BigDecimal amount;

	//bi-directional many-to-one association to CaseEntityObject
	@ManyToOne
	@JoinColumn(name="case_FK", nullable=false, insertable=false, updatable=false)
	private CaseEntityObject caseEntity;

	//bi-directional many-to-one association to Deposit
	@ManyToOne
	@JoinColumn(name="deposit_FK", nullable=false, insertable=false, updatable=false)
	private Deposit deposit;

	public CaseDeposit() {
	}

//	public CaseDepositPK getId() {
//		return this.id;
//	}
//
//	public void setId(CaseDepositPK id) {
//		this.id = id;
//	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CaseEntityObject getCaseEntity() {
		return this.caseEntity;
	}

	public void setCaseEntity(CaseEntityObject caseEntity) {
		this.caseEntity = caseEntity;
	}

	public Deposit getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Deposit deposit) {
		this.deposit = deposit;
	}
	
	@Embeddable
	private class CaseDepositPK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(unique=true, nullable=false)
		private int case_FK;

		@Column(unique=true, nullable=false)
		private int deposit_FK;

//		public CaseDepositPK() {
//		}
//		public int getCase_FK() {
//			return this.case_FK;
//		}
//		public void setCase_FK(int case_FK) {
//			this.case_FK = case_FK;
//		}
//		public int getDeposit_FK() {
//			return this.deposit_FK;
//		}
//		public void setDeposit_FK(int deposit_FK) {
//			this.deposit_FK = deposit_FK;
//		}

	}
}