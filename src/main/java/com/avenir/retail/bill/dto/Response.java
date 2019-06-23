package com.avenir.retail.bill.dto;

public class Response<T> {
	T result;
	
	public Response() {
		
	}
	
	public Response(T result) {
		this.result = result;
	}
	
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
