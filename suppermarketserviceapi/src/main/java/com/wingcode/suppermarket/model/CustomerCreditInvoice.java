package com.wingcode.suppermarket.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the customer_credit_invoice database table.
 * 
 */
@Entity
@Table(name = "customer_credit_invoice")
@NamedQuery(name = "CustomerCreditInvoice.findAll", query = "SELECT c FROM CustomerCreditInvoice c")
public class CustomerCreditInvoice extends AuditModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "balance_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal balanceAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "credit_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal creditAmount;

	@Column(name = "paid_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal paidAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to CustomerCreditAccount
	@ManyToOne
	@JoinColumn(name = "customer_credit_account_id", nullable = false)
	private CustomerCreditAccount customerCreditAccount;

	// bi-directional many-to-one association to SaleInvoice
	@ManyToOne
	@JoinColumn(name = "sale_invoice_id", nullable = false)
	private SaleInvoice saleInvoice;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalanceAmount() {
		return this.balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getCreditAmount() {
		return this.creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CustomerCreditAccount getCustomerCreditAccount() {
		return this.customerCreditAccount;
	}

	public void setCustomerCreditAccount(CustomerCreditAccount customerCreditAccount) {
		this.customerCreditAccount = customerCreditAccount;
	}

	public SaleInvoice getSaleInvoice() {
		return this.saleInvoice;
	}

	public void setSaleInvoice(SaleInvoice saleInvoice) {
		this.saleInvoice = saleInvoice;
	}

}