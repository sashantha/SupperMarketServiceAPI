package com.wingcode.suppermarket.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Model class of item.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Entity
@Table(name = "item")
@JsonRootName(value = "Item")
public class Item extends AuditModel {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** item_Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_Id", nullable = false, updatable = false)
	private Long itemId;

	/** item_Code. */
	@Column(name = "item_Code")
	private String itemCode;

	/** item_Barcode. */
	@Column(name = "item_Barcode")
	private String itemBarcode;

	/** item_Name. */
	@Column(name = "item_Name")
	private String itemName;

	/** item_Group. */
	@Column(name = "item_Group")
	private ItemGroup itemGroup;

	/** item_Sub_Group. */
	@Column(name = "item_Sub_Group")
	private ItemSubGroup itemSubGroup;

	/** item_Cost. */
	@Column(name = "item_Cost")
	private Double itemCost;

	/** item_Wholesale_Price. */
	@Column(name = "item_Wholesale_Price")
	private Double itemWholesalePrice;

	/** item_Retail_Price. */
	@Column(name = "")
	private Double itemRetailPrice;

	/** item_discount. */
	@Column(name = "item_discount")
	private Double itemDiscount;

	/** available_Quantity. */
	@Column(name = "available_Quantity")
	private Double availableQuantity;

	/** reorder_Level. */
	@Column(name = "reorder_Level")
	private Double reorderLevel;

	/** record_State. */
	@Column(name = "record_State")
	private String recordState;

	/** on_Updated. */
	@Column(name = "on_Updated")
	private Date onUpdated;

	/**
	 * Set the item_Id.
	 * 
	 * @param itemId
	 *            item_Id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * Get the item_Id.
	 * 
	 * @return item_Id
	 */
	public Long getItemId() {
		return this.itemId;
	}

	/**
	 * Set the item_Code.
	 * 
	 * @param itemCode
	 *            item_Code
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Get the item_Code.
	 * 
	 * @return item_Code
	 */
	public String getItemCode() {
		return this.itemCode;
	}

	/**
	 * Set the item_Barcode.
	 * 
	 * @param itemBarcode
	 *            item_Barcode
	 */
	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}

	/**
	 * Get the item_Barcode.
	 * 
	 * @return item_Barcode
	 */
	public String getItemBarcode() {
		return this.itemBarcode;
	}

	/**
	 * Set the item_Name.
	 * 
	 * @param itemName
	 *            item_Name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Get the item_Name.
	 * 
	 * @return item_Name
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * Set the item_Group.
	 * 
	 * @param itemGroup
	 *            item_Group
	 */
	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	/**
	 * Get the item_Group.
	 * 
	 * @return item_Group
	 */
	public ItemGroup getItemGroup() {
		return this.itemGroup;
	}

	/**
	 * Set the item_Sub_Group.
	 * 
	 * @param itemSubGroup
	 *            item_Sub_Group
	 */
	public void setItemSubGroup(ItemSubGroup itemSubGroup) {
		this.itemSubGroup = itemSubGroup;
	}

	/**
	 * Get the item_Sub_Group.
	 * 
	 * @return item_Sub_Group
	 */
	public ItemSubGroup getItemSubGroup() {
		return this.itemSubGroup;
	}

	/**
	 * Set the item_Cost.
	 * 
	 * @param itemCost
	 *            item_Cost
	 */
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	/**
	 * Get the item_Cost.
	 * 
	 * @return item_Cost
	 */
	public Double getItemCost() {
		return this.itemCost;
	}

	/**
	 * Set the item_Wholesale_Price.
	 * 
	 * @param itemWholesalePrice
	 *            item_Wholesale_Price
	 */
	public void setItemWholesalePrice(Double itemWholesalePrice) {
		this.itemWholesalePrice = itemWholesalePrice;
	}

	/**
	 * Get the item_Wholesale_Price.
	 * 
	 * @return item_Wholesale_Price
	 */
	public Double getItemWholesalePrice() {
		return this.itemWholesalePrice;
	}

	/**
	 * Set the item_Retail_Price.
	 * 
	 * @param itemRetailPrice
	 *            item_Retail_Price
	 */
	public void setItemRetailPrice(Double itemRetailPrice) {
		this.itemRetailPrice = itemRetailPrice;
	}

	/**
	 * Get the item_Retail_Price.
	 * 
	 * @return item_Retail_Price
	 */
	public Double getItemRetailPrice() {
		return this.itemRetailPrice;
	}

	/**
	 * Set the item_discount.
	 * 
	 * @param itemDiscount
	 *            item_discount
	 */
	public void setItemDiscount(Double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	/**
	 * Get the item_discount.
	 * 
	 * @return item_discount
	 */
	public Double getItemDiscount() {
		return this.itemDiscount;
	}

	/**
	 * Set the available_Quantity.
	 * 
	 * @param availableQuantity
	 *            available_Quantity
	 */
	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	/**
	 * Get the available_Quantity.
	 * 
	 * @return available_Quantity
	 */
	public Double getAvailableQuantity() {
		return this.availableQuantity;
	}

	/**
	 * Set the reorder_Level.
	 * 
	 * @param reorderLevel
	 *            reorder_Level
	 */
	public void setReorderLevel(Double reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	/**
	 * Get the reorder_Level.
	 * 
	 * @return reorder_Level
	 */
	public Double getReorderLevel() {
		return this.reorderLevel;
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
	 * Set the on_Updated.
	 * 
	 * @param onUpdated
	 *            on_Updated
	 */
	public void setOnUpdated(Date onUpdated) {
		this.onUpdated = onUpdated;
	}

	/**
	 * Get the on_Updated.
	 * 
	 * @return on_Updated
	 */
	public Date getOnUpdated() {
		return this.onUpdated;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		Item other = (Item) obj;
		if (itemId == null) {
			if (other.itemId != null) {
				return false;
			}
		} else if (!itemId.equals(other.itemId)) {
			return false;
		}
		return true;
	}

}
