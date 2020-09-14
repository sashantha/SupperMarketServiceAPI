package com.wingcode.suppermarket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model class of purchase.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Entity
@Table(name = "purchase")
//@JsonRootName(value = "Purchase")
public class Purchase extends AuditModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** purchase_Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_Id", nullable = false, updatable = false)
	private Long purchaseId;

	/** supplier. */
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_Id", nullable = false)
	private Supplier supplier;

	/** invoice_No. */
	@Column(name = "invoice_No")
	private String invoiceNo;

	/** purchase_Date. */
	@Column(name = "purchase_Date")
	private Date purchaseDate;

	/** invoice_Type. */
	@Column(name = "invoice_Type")
	private String invoiceType;

	/** invoice_Amount. */
	@Column(name = "invoice_Amount")
	private Double invoiceAmount;

	/** purchase_Discount. */
	@Column(name = "purchase_Discount")
	private Double purchaseDiscount;

	/** discount_Percent. */
	@Column(name = "discount_Percent")
	private Double discountPercent;

	/** net_Amount. */
	@Column(name = "net_Amount")
	private Double netAmount;

	/** cash_Pay_Amount. */
	@Column(name = "cash_Pay_Amount")
	private Double cashPayAmount;

	/** cheque_Pay_Amount. */
	@Column(name = "cheque_Pay_Amount")
	private Double chequePayAmount;

	/** credit_Amount. */
	@Column(name = "credit_Amount")
	private Double creditAmount;

	/** purchase_Day. */
	@Column(name = "purchase_Day")
	private Integer purchaseDay;

	/** purchase_Month. */
	@Column(name = "purchase_Month")
	private Integer purchaseMonth;

	/** purchase_Year. */
	@Column(name = "purchase_Year")
	private Integer purchaseYear;

	/** total_Purchase_Item. */
	@Column(name = "total_Purchase_Item")
	private Integer totalPurchaseItem;

	/** record_State. */
	@Column(name = "record_State")
	private String recordState;

	/** on_Update. */
	@Column(name = "on_Update")
	private Date onUpdate;

	/** user. */
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id", nullable = false)
	private User user;

	/** The set of purchase_Item. */
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	private List<PurchaseItem> purchaseItemSet;

	/**
	 * Constructor.
	 */
	public Purchase() {
		this.purchaseItemSet = new ArrayList<>();
	}

	/**
	 * Set the purchase_Id.
	 * 
	 * @param purchaseId
	 *            purchase_Id
	 */
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * Get the purchase_Id.
	 * 
	 * @return purchase_Id
	 */
	public Long getPurchaseId() {
		return this.purchaseId;
	}

	/**
	 * Set the supplier.
	 * 
	 * @param supplier
	 *            supplier
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Get the supplier.
	 * 
	 * @return supplier
	 */
	public Supplier getSupplier() {
		return this.supplier;
	}

	/**
	 * Set the invoice_No.
	 * 
	 * @param invoiceNo
	 *            invoice_No
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * Get the invoice_No.
	 * 
	 * @return invoice_No
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	/**
	 * Set the purchase_Date.
	 * 
	 * @param purchaseDate
	 *            purchase_Date
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Get the purchase_Date.
	 * 
	 * @return purchase_Date
	 */
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	/**
	 * Set the invoice_Type.
	 * 
	 * @param invoiceType
	 *            invoice_Type
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	/**
	 * Get the invoice_Type.
	 * 
	 * @return invoice_Type
	 */
	public String getInvoiceType() {
		return this.invoiceType;
	}

	/**
	 * Set the invoice_Amount.
	 * 
	 * @param invoiceAmount
	 *            invoice_Amount
	 */
	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	/**
	 * Get the invoice_Amount.
	 * 
	 * @return invoice_Amount
	 */
	public Double getInvoiceAmount() {
		return this.invoiceAmount;
	}

	/**
	 * Set the purchase_Discount.
	 * 
	 * @param purchaseDiscount
	 *            purchase_Discount
	 */
	public void setPurchaseDiscount(Double purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	/**
	 * Get the purchase_Discount.
	 * 
	 * @return purchase_Discount
	 */
	public Double getPurchaseDiscount() {
		return this.purchaseDiscount;
	}

	/**
	 * Set the discount_Percent.
	 * 
	 * @param discountPercent
	 *            discount_Percent
	 */
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * Get the discount_Percent.
	 * 
	 * @return discount_Percent
	 */
	public Double getDiscountPercent() {
		return this.discountPercent;
	}

	/**
	 * Set the net_Amount.
	 * 
	 * @param netAmount
	 *            net_Amount
	 */
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * Get the net_Amount.
	 * 
	 * @return net_Amount
	 */
	public Double getNetAmount() {
		return this.netAmount;
	}

	/**
	 * Set the cash_Pay_Amount.
	 * 
	 * @param cashPayAmount
	 *            cash_Pay_Amount
	 */
	public void setCashPayAmount(Double cashPayAmount) {
		this.cashPayAmount = cashPayAmount;
	}

	/**
	 * Get the cash_Pay_Amount.
	 * 
	 * @return cash_Pay_Amount
	 */
	public Double getCashPayAmount() {
		return this.cashPayAmount;
	}

	/**
	 * Set the cheque_Pay_Amount.
	 * 
	 * @param chequePayAmount
	 *            cheque_Pay_Amount
	 */
	public void setChequePayAmount(Double chequePayAmount) {
		this.chequePayAmount = chequePayAmount;
	}

	/**
	 * Get the cheque_Pay_Amount.
	 * 
	 * @return cheque_Pay_Amount
	 */
	public Double getChequePayAmount() {
		return this.chequePayAmount;
	}

	/**
	 * Set the credit_Amount.
	 * 
	 * @param creditAmount
	 *            credit_Amount
	 */
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	/**
	 * Get the credit_Amount.
	 * 
	 * @return credit_Amount
	 */
	public Double getCreditAmount() {
		return this.creditAmount;
	}

	/**
	 * Set the purchase_Day.
	 * 
	 * @param purchaseDay
	 *            purchase_Day
	 */
	public void setPurchaseDay(Integer purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	/**
	 * Get the purchase_Day.
	 * 
	 * @return purchase_Day
	 */
	public Integer getPurchaseDay() {
		return this.purchaseDay;
	}

	/**
	 * Set the purchase_Month.
	 * 
	 * @param purchaseMonth
	 *            purchase_Month
	 */
	public void setPurchaseMonth(Integer purchaseMonth) {
		this.purchaseMonth = purchaseMonth;
	}

	/**
	 * Get the purchase_Month.
	 * 
	 * @return purchase_Month
	 */
	public Integer getPurchaseMonth() {
		return this.purchaseMonth;
	}

	/**
	 * Set the purchase_Year.
	 * 
	 * @param purchaseYear
	 *            purchase_Year
	 */
	public void setPurchaseYear(Integer purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	/**
	 * Get the purchase_Year.
	 * 
	 * @return purchase_Year
	 */
	public Integer getPurchaseYear() {
		return this.purchaseYear;
	}

	/**
	 * Set the total_Purchase_Item.
	 * 
	 * @param totalPurchaseItem
	 *            total_Purchase_Item
	 */
	public void setTotalPurchaseItem(Integer totalPurchaseItem) {
		this.totalPurchaseItem = totalPurchaseItem;
	}

	/**
	 * Get the total_Purchase_Item.
	 * 
	 * @return total_Purchase_Item
	 */
	public Integer getTotalPurchaseItem() {
		return this.totalPurchaseItem;
	}

	/**
	 * Set the record_State.
	 * 
	 * @param recordState
	 *            record_State
	 */
	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	/**
	 * Get the record_State.
	 * 
	 * @return record_State
	 */
	public String getRecordState() {
		return this.recordState;
	}

	/**
	 * Set the on_Update.
	 * 
	 * @param onUpdate
	 *            on_Update
	 */
	public void setOnUpdate(Date onUpdate) {
		this.onUpdate = onUpdate;
	}

	/**
	 * Get the on_Update.
	 * 
	 * @return on_Update
	 */
	public Date getOnUpdate() {
		return this.onUpdate;
	}

	/**
	 * Set the user.
	 * 
	 * @param user
	 *            user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Get the user.
	 * 
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Set the set of the purchase_Item.
	 * 
	 * @param purchaseItemSet
	 *            The set of purchase_Item
	 */
	public void setPurchaseItemSet(List<PurchaseItem> purchaseItemSet) {
		this.purchaseItemSet = purchaseItemSet;
	}

	/**
	 * Add the purchase_Item.
	 * 
	 * @param purchaseItem
	 *            purchase_Item
	 */
	public void addPurchaseItem(PurchaseItem purchaseItem) {
		this.purchaseItemSet.add(purchaseItem);
	}

	/**
	 * Get the set of the purchase_Item.
	 * 
	 * @return The set of purchase_Item
	 */
	public List<PurchaseItem> getPurchaseItemSet() {
		return this.purchaseItemSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purchaseId == null) ? 0 : purchaseId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Purchase other = (Purchase) obj;
		if (purchaseId == null) {
			if (other.purchaseId != null) {
				return false;
			}
		} else if (!purchaseId.equals(other.purchaseId)) {
			return false;
		}
		return true;
	}

}
