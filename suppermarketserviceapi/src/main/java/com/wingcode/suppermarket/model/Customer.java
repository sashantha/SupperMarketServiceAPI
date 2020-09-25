package com.wingcode.suppermarket.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, unique = true, nullable = false)
	private Long id;

	@Column(length = 150)
	private String address;

	@Column(length = 50)
	private String code;

	@Column(length = 40)
	private String contact;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(length = 250)
	private String description;

	@Column(nullable = false, length = 100)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	// bi-directional one-to-one association to CustomerCreditAccount
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "customer_credit_account_id", nullable = false)
	private CustomerCreditAccount customerCreditAccount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public CustomerCreditAccount getCustomerCreditAccount() {
		return this.customerCreditAccount;
	}

	public void setCustomerCreditAccount(CustomerCreditAccount customerCreditAccount) {
		this.customerCreditAccount = customerCreditAccount;
	}

}