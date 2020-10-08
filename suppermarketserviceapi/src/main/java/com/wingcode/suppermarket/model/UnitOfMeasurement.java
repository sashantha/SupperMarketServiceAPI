package com.wingcode.suppermarket.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the unit_of_measurement database table.
 * 
 */
@Entity
@Table(name = "unit_of_measurement")
@NamedQuery(name = "UnitOfMeasurement.findAll", query = "SELECT u FROM UnitOfMeasurement u")
public class UnitOfMeasurement extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "base_precision", nullable = false, precision = 10, scale = 3)
	private BigDecimal basePrecision;

	@Column(name = "base_ratio", nullable = false, precision = 10, scale = 3)
	private BigDecimal baseRatio;

	@Column(name = "base_ratio_to_purchase", nullable = false, precision = 10, scale = 3)
	private BigDecimal baseRatioToPurchase;

	@Column(name = "base_ratio_to_sale", nullable = false, precision = 10, scale = 3)
	private BigDecimal baseRatioToSale;

	@Column(name = "base_unit_name", nullable = false, length = 20)
	private String baseUnitName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "purchase_precision", nullable = false, precision = 10, scale = 3)
	private BigDecimal purchasePrecision;

	@Column(name = "purchase_precision_unit_name", length = 20)
	private String purchasePrecisionUnitName;

	@Column(name = "purchase_quantify_value", precision = 10, scale = 3)
	private BigDecimal purchaseQuantifyValue;

	@Column(name = "purchase_unit_name", nullable = false, length = 20)
	private String purchaseUnitName;

	@Column(name = "sale_other_unit_name", length = 45)
	private String saleOtherUnitName;

	@Column(name = "sale_precision", nullable = false, precision = 10, scale = 3)
	private BigDecimal salePrecision;

	@Column(name = "sale_unit_name", nullable = false, length = 20)
	private String saleUnitName;

	@Column(name = "unit_description", nullable = false, length = 100)
	private String unitDescription;

	@Column(name = "unit_type", nullable = false, length = 45)
	private String unitType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBasePrecision() {
		return this.basePrecision;
	}

	public void setBasePrecision(BigDecimal basePrecision) {
		this.basePrecision = basePrecision;
	}

	public BigDecimal getBaseRatio() {
		return this.baseRatio;
	}

	public void setBaseRatio(BigDecimal baseRatio) {
		this.baseRatio = baseRatio;
	}

	public BigDecimal getBaseRatioToPurchase() {
		return this.baseRatioToPurchase;
	}

	public void setBaseRatioToPurchase(BigDecimal baseRatioToPurchase) {
		this.baseRatioToPurchase = baseRatioToPurchase;
	}

	public BigDecimal getBaseRatioToSale() {
		return this.baseRatioToSale;
	}

	public void setBaseRatioToSale(BigDecimal baseRatioToSale) {
		this.baseRatioToSale = baseRatioToSale;
	}

	public String getBaseUnitName() {
		return this.baseUnitName;
	}

	public void setBaseUnitName(String baseUnitName) {
		this.baseUnitName = baseUnitName;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getPurchasePrecision() {
		return this.purchasePrecision;
	}

	public void setPurchasePrecision(BigDecimal purchasePrecision) {
		this.purchasePrecision = purchasePrecision;
	}

	public String getPurchasePrecisionUnitName() {
		return this.purchasePrecisionUnitName;
	}

	public void setPurchasePrecisionUnitName(String purchasePrecisionUnitName) {
		this.purchasePrecisionUnitName = purchasePrecisionUnitName;
	}

	public BigDecimal getPurchaseQuantifyValue() {
		return this.purchaseQuantifyValue;
	}

	public void setPurchaseQuantifyValue(BigDecimal purchaseQuantifyValue) {
		this.purchaseQuantifyValue = purchaseQuantifyValue;
	}

	public String getPurchaseUnitName() {
		return this.purchaseUnitName;
	}

	public void setPurchaseUnitName(String purchaseUnitName) {
		this.purchaseUnitName = purchaseUnitName;
	}

	public String getSaleOtherUnitName() {
		return this.saleOtherUnitName;
	}

	public void setSaleOtherUnitName(String saleOtherUnitName) {
		this.saleOtherUnitName = saleOtherUnitName;
	}

	public BigDecimal getSalePrecision() {
		return this.salePrecision;
	}

	public void setSalePrecision(BigDecimal salePrecision) {
		this.salePrecision = salePrecision;
	}

	public String getSaleUnitName() {
		return this.saleUnitName;
	}

	public void setSaleUnitName(String saleUnitName) {
		this.saleUnitName = saleUnitName;
	}

	public String getUnitDescription() {
		return this.unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public String getUnitType() {
		return this.unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}