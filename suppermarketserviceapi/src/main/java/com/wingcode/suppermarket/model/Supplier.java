package com.wingcode.suppermarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of supplier.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Supplier implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** supplier_Id. */
	private Long supplierId;

	/** suplier_Code. */
	private String suplierCode;

	/** supplier_Name. */
	private String supplierName;

	/** supplier_Address. */
	private String supplierAddress;

	/** supplier_Contact. */
	private String supplierContact;

	/** description. */
	private String description;

	/** on_Update. */
	private Date onUpdate;

	/** The set of purchase. */
	private Set<Purchase> purchaseSet;

	/**
	 * Constructor.
	 */
	public Supplier() {
		this.purchaseSet = new HashSet<Purchase>();
	}

	/**
	 * Set the supplier_Id.
	 * 
	 * @param supplierId
	 *            supplier_Id
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * Get the supplier_Id.
	 * 
	 * @return supplier_Id
	 */
	public Long getSupplierId() {
		return this.supplierId;
	}

	/**
	 * Set the suplier_Code.
	 * 
	 * @param suplierCode
	 *            suplier_Code
	 */
	public void setSuplierCode(String suplierCode) {
		this.suplierCode = suplierCode;
	}

	/**
	 * Get the suplier_Code.
	 * 
	 * @return suplier_Code
	 */
	public String getSuplierCode() {
		return this.suplierCode;
	}

	/**
	 * Set the supplier_Name.
	 * 
	 * @param supplierName
	 *            supplier_Name
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * Get the supplier_Name.
	 * 
	 * @return supplier_Name
	 */
	public String getSupplierName() {
		return this.supplierName;
	}

	/**
	 * Set the supplier_Address.
	 * 
	 * @param supplierAddress
	 *            supplier_Address
	 */
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	/**
	 * Get the supplier_Address.
	 * 
	 * @return supplier_Address
	 */
	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	/**
	 * Set the supplier_Contact.
	 * 
	 * @param supplierContact
	 *            supplier_Contact
	 */
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	/**
	 * Get the supplier_Contact.
	 * 
	 * @return supplier_Contact
	 */
	public String getSupplierContact() {
		return this.supplierContact;
	}

	/**
	 * Set the description.
	 * 
	 * @param description
	 *            description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the description.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.description;
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
	 * Set the set of the purchase.
	 * 
	 * @param purchaseSet
	 *            The set of purchase
	 */
	public void setPurchaseSet(Set<Purchase> purchaseSet) {
		this.purchaseSet = purchaseSet;
	}

	/**
	 * Add the purchase.
	 * 
	 * @param purchase
	 *            purchase
	 */
	public void addPurchase(Purchase purchase) {
		this.purchaseSet.add(purchase);
	}

	/**
	 * Get the set of the purchase.
	 * 
	 * @return The set of purchase
	 */
	public Set<Purchase> getPurchaseSet() {
		return this.purchaseSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
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
		Supplier other = (Supplier) obj;
		if (supplierId == null) {
			if (other.supplierId != null) {
				return false;
			}
		} else if (!supplierId.equals(other.supplierId)) {
			return false;
		}
		return true;
	}

}