package com.wingcode.suppermarket.model;

public class ItemCriteria {

	private Long id;
	private String code;
	private String barcode;
	private String name;
	private String otherName;

	public ItemCriteria(Long id, String code, String barcode, String name, String otherName) {
		super();
		this.id = id;
		this.code = code;
		this.barcode = barcode;
		this.name = name;
		this.otherName = otherName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

}
