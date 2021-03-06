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
 * The persistent class for the cheque_book database table.
 * 
 */
@Entity
@Table(name = "cheque_book")
@NamedQuery(name = "ChequeBook.findAll", query = "SELECT c FROM ChequeBook c")
public class ChequeBook extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "book_description", nullable = false, length = 50)
	private String bookDescription;

	@Column(name = "book_type", nullable = false, length = 10)
	private String bookType;

	@Column(name = "cheque_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal chequeAmount;

	@Column(name = "cheque_no", nullable = false, length = 10)
	private String chequeNo;

	@Column(name = "cheque_status", nullable = false, length = 20)
	private String chequeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(length = 250)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "relese_date", nullable = false)
	private Date releseDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_date", nullable = false)
	private Date transactionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	// bi-directional many-to-one association to BranchAccount
	@ManyToOne
	@JoinColumn(name = "branch_account_id")
	private BranchAccount branchAccount;

	// bi-directional many-to-one association to Purchase
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;

	// bi-directional many-to-one association to SaleInvoice
	@ManyToOne
	@JoinColumn(name = "sale_invoice_id")
	private SaleInvoice saleInvoice;

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

	public String getBookDescription() {
		return this.bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookType() {
		return this.bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public BigDecimal getChequeAmount() {
		return this.chequeAmount;
	}

	public void setChequeAmount(BigDecimal chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	public String getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeStatus() {
		return this.chequeStatus;
	}

	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleseDate() {
		return this.releseDate;
	}

	public void setReleseDate(Date releseDate) {
		this.releseDate = releseDate;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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

	public BranchAccount getBranchAccount() {
		return this.branchAccount;
	}

	public void setBranchAccount(BranchAccount branchAccount) {
		this.branchAccount = branchAccount;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public SaleInvoice getSaleInvoice() {
		return this.saleInvoice;
	}

	public void setSaleInvoice(SaleInvoice saleInvoice) {
		this.saleInvoice = saleInvoice;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}