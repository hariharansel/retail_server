package com.avenir.retail.bill.entities;

import com.avenir.retail.bill.enums.ItemTypeEnum;

/**
 *This is considered item entity mapped to table 
 * 
 *
 */
public class Item {

	private Long id;
	private String name;
	private ItemTypeEnum type;
	private Double price;
	
	public Item() {}
	
	public Item(Long id, String name, ItemTypeEnum type, Double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ItemTypeEnum getType() {
		return type;
	}
	public void setType(ItemTypeEnum type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
