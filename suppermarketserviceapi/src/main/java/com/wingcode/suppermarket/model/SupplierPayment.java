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
 * The persistent class for the supplier_payment database table.
 * 
 */
@Entity
@Table(name = "supplier_payment")
@NamedQuery(name = "SupplierPayment.findAll", query = "SELECT s FROM SupplierPayment s")
public class SupplierPayment extends com.wingcode.suppermarket.model.AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amonut;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "pay_date", nullable = false)
	private Date payDate;

	@Column(name = "pay_method", nullable = false, length = 20)
	private String payMethod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to SupplierCreditInvoice
	@ManyToOne
	@JoinColumn(name = "supplier_credit_invoice_id", nullable = false)
	private SupplierCreditInvoice supplierCreditInvoice;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmonut() {
		return this.amonut;
	}

	public void setAmonut(BigDecimal amonut) {
		this.amonut = amonut;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public SupplierCreditInvoice getSupplierCreditInvoice() {
		return this.supplierCreditInvoice;
	}

	public void setSupplierCreditInvoice(SupplierCreditInvoice supplierCreditInvoice) {
		this.supplierCreditInvoice = supplierCreditInvoice;
	}

}