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
 * The persistent class for the sale_item database table.
 * 
 */
@Entity
@Table(name = "sale_item")
@NamedQuery(name = "SaleItem.findAll", query = "SELECT s FROM SaleItem s")
public class SaleItem extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal cost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "defect_quantity", precision = 10, scale = 3)
	private BigDecimal defectQuantity;

	@Column(name = "defect_state", length = 20)
	private String defectState;

	@Column(precision = 10, scale = 2)
	private BigDecimal discount;

	@Column(name = "issue_no", nullable = false)
	private int issueNo;

	@Column(name = "net_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal netAmount;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal profit;

	@Column(nullable = false, precision = 10, scale = 3)
	private BigDecimal quantity;

	@Column(name = "real_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal realAmount;

	@Column(name = "record_state", nullable = false, length = 20)
	private String recordState;

	@Temporal(TemporalType.DATE)
	@Column(name = "sale_date", nullable = false)
	private Date saleDate;

	@Column(name = "sale_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal salePrice;

	@Column(name = "sale_unit", nullable = false, length = 20)
	private String saleUnit;

	@Column(name = "total_cost", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalCost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

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

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public BigDecimal getDefectQuantity() {
		return this.defectQuantity;
	}

	public void setDefectQuantity(BigDecimal defectQuantity) {
		this.defectQuantity = defectQuantity;
	}

	public String getDefectState() {
		return this.defectState;
	}

	public void setDefectState(String defectState) {
		this.defectState = defectState;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public int getIssueNo() {
		return this.issueNo;
	}

	public void setIssueNo(int issueNo) {
		this.issueNo = issueNo;
	}

	public BigDecimal getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getProfit() {
		return this.profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRealAmount() {
		return this.realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public String getRecordState() {
		return this.recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getSaleUnit() {
		return this.saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
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

	public SaleInvoice getSaleInvoice() {
		return this.saleInvoice;
	}

	public void setSaleInvoice(SaleInvoice saleInvoice) {
		this.saleInvoice = saleInvoice;
	}

}