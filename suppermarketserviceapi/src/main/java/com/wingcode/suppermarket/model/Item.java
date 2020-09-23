package com.wingcode.suppermarket.model;

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
 * The persistent class for the item database table.
 * 
 */
@Entity
@Table(name = "item")
@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
public class Item extends com.wingcode.suppermarket.model.AuditModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 50)
	private String barcode;

	@Column(nullable = false, length = 10)
	private String category;

	@Column(nullable = false, length = 50)
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(nullable = false, length = 150)
	private String name;

	@Column(name = "other_name", length = 200)
	private String otherName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	// bi-directional many-to-one association to ItemGroup
	@ManyToOne
	@JoinColumn(name = "item_group_id", nullable = false)
	private ItemGroup itemGroup;

	// bi-directional many-to-one association to ItemSubGroup
	@ManyToOne
	@JoinColumn(name = "item_sub_group_id", nullable = false)
	private ItemSubGroup itemSubGroup;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ItemGroup getItemGroup() {
		return this.itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}

	public ItemSubGroup getItemSubGroup() {
		return this.itemSubGroup;
	}

	public void setItemSubGroup(ItemSubGroup itemSubGroup) {
		this.itemSubGroup = itemSubGroup;
	}

}