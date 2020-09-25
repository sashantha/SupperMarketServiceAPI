package com.wingcode.suppermarket.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the unit_of_measure database table.
 * 
 */
@Entity
@Table(name = "unit_of_measure")
@NamedQuery(name = "UnitOfMeasure.findAll", query = "SELECT u FROM UnitOfMeasure u")
public class UnitOfMeasure extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "measure_quantity", nullable = false, precision = 10, scale = 3)
	private BigDecimal measureQuantity;

	@Column(name = "measure_type", nullable = false, length = 20)
	private String measureType;

	@Column(name = "measure_unit", nullable = false, length = 20)
	private String measureUnit;

	@Column(name = "per_one_unit", nullable = false, precision = 10, scale = 3)
	private BigDecimal perOneUnit;

	@Column(name = "purchase_unit", nullable = false, length = 20)
	private String purchaseUnit;

	@Column(name = "sale_unit", nullable = false, length = 20)
	private String saleUnit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional one-to-one association to Item
	@OneToOne(mappedBy = "unitOfMeasure", cascade = { CascadeType.ALL })
	private Item item;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getMeasureQuantity() {
		return this.measureQuantity;
	}

	public void setMeasureQuantity(BigDecimal measureQuantity) {
		this.measureQuantity = measureQuantity;
	}

	public String getMeasureType() {
		return this.measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public String getMeasureUnit() {
		return this.measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public BigDecimal getPerOneUnit() {
		return this.perOneUnit;
	}

	public void setPerOneUnit(BigDecimal perOneUnit) {
		this.perOneUnit = perOneUnit;
	}

	public String getPurchaseUnit() {
		return this.purchaseUnit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public String getSaleUnit() {
		return this.saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}