package com.avenir.retail.bill.dto;

import java.util.Map;

public class BillDTO {

	private Long id;
	private Map<String, Object> userDetails;
	private Map<String, Object> itemDetails;
	private Map<String, Object> billDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Map<String, Object> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Map<String, Object> userDetails) {
		this.userDetails = userDetails;
	}
	public Map<String, Object> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Map<String, Object> itemDetails) {
		this.itemDetails = itemDetails;
	}
	public Map<String, Object> getBillDetails() {
		return billDetails;
	}
	public void setBillDetails(Map<String, Object> billDetails) {
		this.billDetails = billDetails;
	}
}
