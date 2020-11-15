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
 * The persistent class for the purchase database table.
 * 
 */
@Entity
@Table(name = "purchase")
@NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p")
public class Purchase extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "cost_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal costAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "credit_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal creditAmount;

	@Column(name = "discount_percent", nullable = false, precision = 10, scale = 2)
	private BigDecimal discountPercent;

	@Column(name = "invoice_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal invoiceAmount;

	@Column(name = "invoice_no", length = 50)
	private String invoiceNo;

	@Column(name = "invoice_type", nullable = false, length = 50)
	private String invoiceType;

	@Column(name = "net_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal netAmount;

	@Column(name = "pay_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal payAmount;

	@Column(name = "chq_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal chqAmount;

	@Column(name = "pay_method", nullable = false, length = 20)
	private String payMethod;

	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;

	@Column(name = "purchase_discount", nullable = false, precision = 10, scale = 2)
	private BigDecimal purchaseDiscount;

	@Column(name = "record_state", nullable = false, length = 20)
	private String recordState;

	@Column(name = "total_purchase_item", nullable = false)
	private int totalPurchaseItem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	// bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCostAmount() {
		return this.costAmount;
	}

	public void setCostAmount(BigDecimal costAmount) {
		this.costAmount = costAmount;
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

	public BigDecimal getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	public BigDecimal getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public BigDecimal getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getPayAmount() {
		return this.payAmount;
	}

	public void setChqAmount(BigDecimal chqAmount) {
		this.chqAmount = chqAmount;
	}

	public BigDecimal getChqAmount() {
		return this.chqAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getPurchaseDiscount() {
		return this.purchaseDiscount;
	}

	public void setPurchaseDiscount(BigDecimal purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	public String getRecordState() {
		return this.recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public int getTotalPurchaseItem() {
		return this.totalPurchaseItem;
	}

	public void setTotalPurchaseItem(int totalPurchaseItem) {
		this.totalPurchaseItem = totalPurchaseItem;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}