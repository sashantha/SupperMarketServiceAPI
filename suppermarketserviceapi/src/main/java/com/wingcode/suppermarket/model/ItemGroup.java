package com.wingcode.suppermarket.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of item_Group.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class ItemGroup implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** group_Name. */
	private String groupName;

	/** The set of item. */
	private Set<Item> itemSet;

	/**
	 * Constructor.
	 */
	public ItemGroup() {
		this.itemSet = new HashSet<Item>();
	}

	/**
	 * Set the group_Name.
	 * 
	 * @param groupName
	 *            group_Name
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Get the group_Name.
	 * 
	 * @return group_Name
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Set the set of the item.
	 * 
	 * @param itemSet
	 *            The set of item
	 */
	public void setItemSet(Set<Item> itemSet) {
		this.itemSet = itemSet;
	}

	/**
	 * Add the item.
	 * 
	 * @param item
	 *            item
	 */
	public void addItem(Item item) {
		this.itemSet.add(item);
	}

	/**
	 * Get the set of the item.
	 * 
	 * @return The set of item
	 */
	public Set<Item> getItemSet() {
		return this.itemSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
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
		ItemGroup other = (ItemGroup) obj;
		if (groupName == null) {
			if (other.groupName != null) {
				return false;
			}
		} else if (!groupName.equals(other.groupName)) {
			return false;
		}
		return true;
	}

}
