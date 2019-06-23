package com.avenir.retail.bill.controller;

import com.avenir.retail.bill.exception.BadRequestException;

public class BaseController {

	protected void assertNull(Object obj, String errorMsg) throws BadRequestException {
		if(obj == null) {
			throw new BadRequestException(errorMsg);
		}
	}
	
	protected void assertPositiveNumber(Long number, String errorMsg) throws BadRequestException {
		if(number == null || number.compareTo(0L) < 0) {
			throw new BadRequestException(errorMsg);
		}
	}
}
