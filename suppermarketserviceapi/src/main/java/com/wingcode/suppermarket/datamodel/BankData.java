package com.wingcode.suppermarket.datamodel;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the bank database table.
 * 
 */

public class BankData implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;

	private Date createdAt;

	private String name;
	
	private Date updatedAt;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}