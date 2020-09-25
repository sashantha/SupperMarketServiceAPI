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
 * The persistent class for the store_infor database table.
 * 
 */
@Entity
@Table(name = "store_infor")
@NamedQuery(name = "StoreInfor.findAll", query = "SELECT s FROM StoreInfor s")
public class StoreInfor extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "available_quantity", precision = 10, scale = 3)
	private BigDecimal availableQuantity;

	@Column(precision = 10, scale = 2)
	private BigDecimal cost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(precision = 10, scale = 2)
	private BigDecimal discount;

	@Column(name = "reorder_level", precision = 10, scale = 2)
	private BigDecimal reorderLevel;

	@Column(name = "retail_price", precision = 10, scale = 2)
	private BigDecimal retailPrice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@Column(name = "wholesale_price", precision = 10, scale = 2)
	private BigDecimal wholesalePrice;

	// bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	// bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(BigDecimal availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(BigDecimal reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public BigDecimal getWholesalePrice() {
		return this.wholesalePrice;
	}

	public void setWholesalePrice(BigDecimal wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}