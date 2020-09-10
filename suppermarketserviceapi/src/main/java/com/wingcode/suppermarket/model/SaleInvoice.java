package com.wingcode.suppermarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of sale_Invoice.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class SaleInvoice implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** sale_Id. */
	private Long saleId;

	/** invoice_No. */
	private String invoiceNo;

	/** invoice_Date. */
	private Date invoiceDate;

	/** total_Cost. */
	private Double totalCost;

	/** total_Amount. */
	private Double totalAmount;

	/** total_Discount. */
	private Double totalDiscount;

	/** invoice_Discount. */
	private Double invoiceDiscount;

	/** net_Amount. */
	private Double netAmount;

	/** recieved_Cash. */
	private Double recievedCash;

	/** recieved_Cheque. */
	private Double recievedCheque;

	/** paid_Amount. */
	private Double paidAmount;

	/** card_Pay. */
	private Double cardPay;

	/** balance_Amount. */
	private Double balanceAmount;

	/** credit_Amount. */
	private Double creditAmount;

	/** total_profit. */
	private Double totalProfit;

	/** invoice_Type. */
	private String invoiceType;

	/** sale_Day. */
	private Integer saleDay;

	/** sale_Month. */
	private Integer saleMonth;

	/** sale_Year. */
	private Integer saleYear;

	/** record_State. */
	private String recordState;

	/** customer. */
	private Customer customer;

	/** user. */
	private User user;

	/** on_Update. */
	private Date onUpdate;

	/** The set of sale_Item. */
	private Set<SaleItem> saleItemSet;

	/**
	 * Constructor.
	 */
	public SaleInvoice() {
		this.saleItemSet = new HashSet<SaleItem>();
	}

	/**
	 * Set the sale_Id.
	 * 
	 * @param saleId
	 *            sale_Id
	 */
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	/**
	 * Get the sale_Id.
	 * 
	 * @return sale_Id
	 */
	public Long getSaleId() {
		return this.saleId;
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
	 * Set the invoice_Date.
	 * 
	 * @param invoiceDate
	 *            invoice_Date
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	/**
	 * Get the invoice_Date.
	 * 
	 * @return invoice_Date
	 */
	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	/**
	 * Set the total_Cost.
	 * 
	 * @param totalCost
	 *            total_Cost
	 */
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Get the total_Cost.
	 * 
	 * @return total_Cost
	 */
	public Double getTotalCost() {
		return this.totalCost;
	}

	/**
	 * Set the total_Amount.
	 * 
	 * @param totalAmount
	 *            total_Amount
	 */
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Get the total_Amount.
	 * 
	 * @return total_Amount
	 */
	public Double getTotalAmount() {
		return this.totalAmount;
	}

	/**
	 * Set the total_Discount.
	 * 
	 * @param totalDiscount
	 *            total_Discount
	 */
	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * Get the total_Discount.
	 * 
	 * @return total_Discount
	 */
	public Double getTotalDiscount() {
		return this.totalDiscount;
	}

	/**
	 * Set the invoice_Discount.
	 * 
	 * @param invoiceDiscount
	 *            invoice_Discount
	 */
	public void setInvoiceDiscount(Double invoiceDiscount) {
		this.invoiceDiscount = invoiceDiscount;
	}

	/**
	 * Get the invoice_Discount.
	 * 
	 * @return invoice_Discount
	 */
	public Double getInvoiceDiscount() {
		return this.invoiceDiscount;
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
	 * Set the recieved_Cash.
	 * 
	 * @param recievedCash
	 *            recieved_Cash
	 */
	public void setRecievedCash(Double recievedCash) {
		this.recievedCash = recievedCash;
	}

	/**
	 * Get the recieved_Cash.
	 * 
	 * @return recieved_Cash
	 */
	public Double getRecievedCash() {
		return this.recievedCash;
	}

	/**
	 * Set the recieved_Cheque.
	 * 
	 * @param recievedCheque
	 *            recieved_Cheque
	 */
	public void setRecievedCheque(Double recievedCheque) {
		this.recievedCheque = recievedCheque;
	}

	/**
	 * Get the recieved_Cheque.
	 * 
	 * @return recieved_Cheque
	 */
	public Double getRecievedCheque() {
		return this.recievedCheque;
	}

	/**
	 * Set the paid_Amount.
	 * 
	 * @param paidAmount
	 *            paid_Amount
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * Get the paid_Amount.
	 * 
	 * @return paid_Amount
	 */
	public Double getPaidAmount() {
		return this.paidAmount;
	}

	/**
	 * Set the card_Pay.
	 * 
	 * @param cardPay
	 *            card_Pay
	 */
	public void setCardPay(Double cardPay) {
		this.cardPay = cardPay;
	}

	/**
	 * Get the card_Pay.
	 * 
	 * @return card_Pay
	 */
	public Double getCardPay() {
		return this.cardPay;
	}

	/**
	 * Set the balance_Amount.
	 * 
	 * @param balanceAmount
	 *            balance_Amount
	 */
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * Get the balance_Amount.
	 * 
	 * @return balance_Amount
	 */
	public Double getBalanceAmount() {
		return this.balanceAmount;
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
	 * Set the total_profit.
	 * 
	 * @param totalProfit
	 *            total_profit
	 */
	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}

	/**
	 * Get the total_profit.
	 * 
	 * @return total_profit
	 */
	public Double getTotalProfit() {
		return this.totalProfit;
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
	 * Set the sale_Day.
	 * 
	 * @param saleDay
	 *            sale_Day
	 */
	public void setSaleDay(Integer saleDay) {
		this.saleDay = saleDay;
	}

	/**
	 * Get the sale_Day.
	 * 
	 * @return sale_Day
	 */
	public Integer getSaleDay() {
		return this.saleDay;
	}

	/**
	 * Set the sale_Month.
	 * 
	 * @param saleMonth
	 *            sale_Month
	 */
	public void setSaleMonth(Integer saleMonth) {
		this.saleMonth = saleMonth;
	}

	/**
	 * Get the sale_Month.
	 * 
	 * @return sale_Month
	 */
	public Integer getSaleMonth() {
		return this.saleMonth;
	}

	/**
	 * Set the sale_Year.
	 * 
	 * @param saleYear
	 *            sale_Year
	 */
	public void setSaleYear(Integer saleYear) {
		this.saleYear = saleYear;
	}

	/**
	 * Get the sale_Year.
	 * 
	 * @return sale_Year
	 */
	public Integer getSaleYear() {
		return this.saleYear;
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
	 * Set the customer.
	 * 
	 * @param customer
	 *            customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Get the customer.
	 * 
	 * @return customer
	 */
	public Customer getCustomer() {
		return this.customer;
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
	 * Set the set of the sale_Item.
	 * 
	 * @param saleItemSet
	 *            The set of sale_Item
	 */
	public void setSaleItemSet(Set<SaleItem> saleItemSet) {
		this.saleItemSet = saleItemSet;
	}

	/**
	 * Add the sale_Item.
	 * 
	 * @param saleItem
	 *            sale_Item
	 */
	public void addSaleItem(SaleItem saleItem) {
		this.saleItemSet.add(saleItem);
	}

	/**
	 * Get the set of the sale_Item.
	 * 
	 * @return The set of sale_Item
	 */
	public Set<SaleItem> getSaleItemSet() {
		return this.saleItemSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((saleId == null) ? 0 : saleId.hashCode());
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
		SaleInvoice other = (SaleInvoice) obj;
		if (saleId == null) {
			if (other.saleId != null) {
				return false;
			}
		} else if (!saleId.equals(other.saleId)) {
			return false;
		}
		return true;
	}

}